package model;

public enum StatusPedido {

    PENDENTE(codigo: 1, descricao: "Pendente"),
    

    private int codigo;
    private String descricao;

    private StatusPedido(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
