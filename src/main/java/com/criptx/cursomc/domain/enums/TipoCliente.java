package com.criptx.cursomc.domain.enums;

public enum TipoCliente {
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int code;
    private String descricao;

    TipoCliente(int code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEmum(Integer code) {
        if (code == null) {
            return null;
        }

        for (TipoCliente cliente : TipoCliente.values()) {
            if (code.equals(cliente.getCode())) {
                return cliente;
            }
        }
        throw new IllegalArgumentException("Id inválido" + code);
    }
}
