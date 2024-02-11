package com.macgarcia.github.rinha2024.resource;

import com.macgarcia.github.rinha2024.ControleBancarioService;
import com.macgarcia.github.rinha2024.dto.transacao.TransacaoReq;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller(value = "/clientes")
public class ControleBancarioController {

    @Inject
    private ControleBancarioService service;

    @Post(value = "/{id}/transacoes")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public HttpResponse<?> executarTransacao(@PathVariable("id") Long id, @Body TransacaoReq req) {
        return service.executarTransacao(id, req);
    }

    @Get(value = "/{id}/extrato")
    @Produces(value = MediaType.APPLICATION_JSON)
    public HttpResponse<?> consultarExtrato(@PathVariable("id") Long id) {
        return service.consultarExtrato(id);
    }
}
