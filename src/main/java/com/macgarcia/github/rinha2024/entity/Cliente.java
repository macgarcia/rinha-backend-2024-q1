package com.macgarcia.github.rinha2024.entity;

import com.macgarcia.github.rinha2024.dto.transacao.TransacaoReq;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter @Setter
@NoArgsConstructor
public class Cliente  implements Serializable {

    @Id
    private Long id;

    @Column(name = "limite")
    private Long limite;

    @Column(name = "saldo_inicial")
    private Long saldoInicial;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Transacao> transacaoList;

    public void calcularTransacao(TransacaoReq req) {
        if (TipoTransacao.c.equals(req.tipo())) {
            this.saldoInicial += req.valor();
        } else {
            this.saldoInicial -= req.valor();
        }
    }

}
