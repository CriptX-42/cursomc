package com.criptx.cursomc.domain.enums;

public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");


    private int code;
    private String descricao;

    Perfil(int code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEmum(Integer code) {
        if (code == null) {
            return null;
        }

        for (Perfil pagamento : Perfil.values()) {
            if (code.equals(pagamento.getCode())) {
                return pagamento;
            }
        }
        throw new IllegalArgumentException("Id inválido" + code);
    }
}
