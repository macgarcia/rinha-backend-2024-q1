package com.macgarcia.github.rinha2024;

import com.macgarcia.github.rinha2024.dto.extrato.ExtratoRes;
import com.macgarcia.github.rinha2024.dto.extrato.Saldo;
import com.macgarcia.github.rinha2024.dto.extrato.UltimasTransacoes;
import com.macgarcia.github.rinha2024.dto.transacao.TransacaoReq;
import com.macgarcia.github.rinha2024.dto.transacao.TransacaoRes;
import com.macgarcia.github.rinha2024.entity.Cliente;
import com.macgarcia.github.rinha2024.entity.TipoTransacao;
import com.macgarcia.github.rinha2024.entity.Transacao;
import com.macgarcia.github.rinha2024.repository.ClienteRepository;
import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

@Singleton
public class ControleBancarioService {

    private final int NUMERO_DE_TRANSACOES = 10;

    @Inject
    private ClienteRepository repository;

    public HttpResponse<?> executarTransacao(Long id, TransacaoReq req) {

        var clienteBuscado = this.buscarClientePorId(id);
        if (clienteBuscado.isEmpty()) {
            return HttpResponse.notFound();
        }

        Cliente cliente = clienteBuscado.get();

        var podeExecutar = this.verificarLimitesDaTransacao(cliente, req);
        if (!podeExecutar) {
            return HttpResponse.unprocessableEntity();
        }

        processarTransacao(cliente, req);

        var res = new TransacaoRes(cliente.getLimite(), cliente.getSaldoInicial());
        return HttpResponse.ok(res);
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return repository.findById(id);
    }

    public boolean verificarLimitesDaTransacao(Cliente cliente, TransacaoReq req) {
        if (TipoTransacao.d.equals(req.tipo())) {
            return cliente.getSaldoInicial() >= req.valor();
        }
        return true;
    }

    private void processarTransacao(Cliente cliente, TransacaoReq req) {
        if (Objects.isNull(cliente.getTransacaoList())) {
            cliente.setTransacaoList(new ArrayList<>());
        }
        Transacao novaTransacao = new Transacao(cliente, req);
        cliente.getTransacaoList().add(novaTransacao);
        cliente.calcularTransacao(req);
        repository.merge(cliente);
    }

    public HttpResponse<?> consultarExtrato(Long id) {
        var clienteBuscado = this.buscarClientePorId(id);
        if (clienteBuscado.isEmpty()) {
            return HttpResponse.notFound();
        }

        Cliente cliente = clienteBuscado.get();

        var saldo = new Saldo(cliente);

        var transacoes = cliente.getTransacaoList().stream()
                .sorted(Comparator.comparing(Transacao::getDataTransacao).reversed())
                .limit(NUMERO_DE_TRANSACOES)
                .map(UltimasTransacoes::new)
                .toList();

        ExtratoRes res = new ExtratoRes(saldo, transacoes);

        return HttpResponse.ok(res);
    }

}
