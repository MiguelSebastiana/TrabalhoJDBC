package model;

public enum StatusPedido {

    PENDENTE(codigo: 1, descricao: "Pendente"),
    ENTREGUE(codigo: 2, descricao: "Entregue")

    private int codigo;
    private String descricao;

    private StatusPedido(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
