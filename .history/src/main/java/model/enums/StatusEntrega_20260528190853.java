package model.enums;

public enum StatusEntrega{

    EM_ROTA(1, "Em rota"),
    ENTREGUE(2, "Entregue"),
    ATRASADA(3, "Atrasada");

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

    public StatusEntrega fromDesc (String descricao){
        for(StatusEntrega status : StatusEntrega.values()){
            if(status.getDescricao().equals(descricao)){
                return status;
            }
        }
    }
}