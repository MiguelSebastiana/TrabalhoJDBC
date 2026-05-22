package model;

public enum StatusPedido {

    PENDENTE(1, "Pendente"),
    ENTREGUE(2, "Entregue"),
    CANCELADO(3,"Cancelado");

    private int codigo;
    private String descricao;

    private StatusPedido(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

}
