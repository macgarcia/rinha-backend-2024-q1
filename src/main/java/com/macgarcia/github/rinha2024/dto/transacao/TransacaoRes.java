package com.macgarcia.github.rinha2024.dto.transacao;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Introspected
@Serdeable.Serializable
public record TransacaoRes(Long limite, Long saldo) implements Serializable {
}
