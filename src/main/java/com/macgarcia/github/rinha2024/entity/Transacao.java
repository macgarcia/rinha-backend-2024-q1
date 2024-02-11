package com.macgarcia.github.rinha2024.entity;

import com.macgarcia.github.rinha2024.dto.transacao.TransacaoReq;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Getter @Setter
@NoArgsConstructor
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_transacao")
    private LocalDateTime dataTransacao;

    @Column(name = "valor")
    private Long valor;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    private transient TransacaoReq req;

    public Transacao(Cliente cliente, TransacaoReq req) {
        this.cliente = cliente;
        this.descricao = req.descricao();
        this.dataTransacao = LocalDateTime.now();
        this.valor = req.valor();
        this.tipo = req.tipo();
    }

}
