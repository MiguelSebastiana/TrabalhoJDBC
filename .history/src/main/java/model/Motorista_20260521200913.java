package model;

public class Motorista {
    
    private int id;
    private String nome;
    private String cnh;
    private String veiculo;
    private String cidade_base;
    public Motorista(int id, String nome, String cnh, String veiculo, String cidade_base) {
        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidade_base = cidade_base;
    }

    
}
