package model;

public enum StatusEntrega{

    EM_ROTA(1, "Em rota"),
    ENTREGUE(2, "Entregue"),
    ATRASADA(3, );

    private int codigo;
    private String descricao;

    private StatusEntrega(int codigo, String descricao){
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