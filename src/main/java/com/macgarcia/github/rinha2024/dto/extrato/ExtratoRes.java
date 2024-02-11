package com.macgarcia.github.rinha2024.dto.extrato;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;
import java.util.List;

@Introspected
@Serdeable.Serializable
public record ExtratoRes(@JsonProperty("saldo") Saldo saldo
        , @JsonProperty("ultimas_transacoes")List<UltimasTransacoes> transacoes) implements Serializable {

}
