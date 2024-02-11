package com.macgarcia.github.rinha2024.dto.extrato;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.macgarcia.github.rinha2024.entity.Cliente;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Introspected
@Serdeable.Serializable
public record Saldo(Long total, @JsonProperty("data_extrato") LocalDateTime dataExtrato, Long limite) {

    public Saldo(Cliente cliente) {
        this(cliente.getSaldoInicial(), LocalDateTime.now(), cliente.getLimite());
    }
}
