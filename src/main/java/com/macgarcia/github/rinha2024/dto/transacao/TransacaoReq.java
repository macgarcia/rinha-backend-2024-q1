package com.macgarcia.github.rinha2024.dto.transacao;

import com.macgarcia.github.rinha2024.entity.TipoTransacao;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Introspected
@Serdeable.Deserializable
public record TransacaoReq(Long valor, TipoTransacao tipo, String descricao) implements Serializable {
}
