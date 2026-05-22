package model;

public enum StatusPedido {

    PENDENTE(1, "Pendente"),
    ENTREGUE(2, "Entregue"),
    CANCELADO(codigo: 3, descricao "Cancelado");

    private int codigo;
    private String descricao;

    private StatusPedido(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }


}
