package com.macgarcia.github.rinha2024.dto.extrato;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.macgarcia.github.rinha2024.entity.TipoTransacao;
import com.macgarcia.github.rinha2024.entity.Transacao;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Introspected
@Serdeable.Serializable
public record UltimasTransacoes(Long valor, TipoTransacao tipo, String descricao
        , @JsonProperty("realizada_em") LocalDateTime realizadaEm) implements Serializable {

    public UltimasTransacoes(Transacao transacao) {
        this(transacao.getValor(), transacao.getTipo(), transacao.getDescricao(), transacao.getDataTransacao());
    }
}
