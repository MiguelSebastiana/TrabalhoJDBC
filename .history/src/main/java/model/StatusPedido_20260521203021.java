package model;

public enum StatusPedido {

    PENDENTE(1, descricao: "Pendente"),
    ENTREGUE(codigo: 2, descricao: "Entregue"),
    CANCELADO(codigo: 3, descricao "Cancelado");

    private int codigo;
    private String descricao;

    private StatusPedido(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }


}
