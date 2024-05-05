package com.criptx.cursomc.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int code;
    private String descricao;

    EstadoPagamento(int code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEmum(Integer code) {
        if (code == null) {
            return null;
        }

        for (EstadoPagamento pagamento : EstadoPagamento.values()) {
            if (code.equals(pagamento.getCode())) {
                return pagamento;
            }
        }
        throw new IllegalArgumentException("Id inválido" + code);
    }
}
