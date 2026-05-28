package view;

import model.Motorista;
import utils.Ferramentas;

public class CadastrarMotorista {
 
    public static void cadastrarMotorista(){
        System.out.print("Digite o nome do motorista: ");
        String nome = Ferramentas.lerString();

        System.out.print("Digite o cnh do motorista: ");
        String cnh = Ferramentas.lerString();

        System.out.print("Digite o veiculo do motorista: ");
        String veiculo = Ferramentas.lerString();

        System.out.print("Digite a cidade base do motorista: ");
        String cidade_base = Ferramentas.lerString();

        Motorista motorista = new Motorista(nome, cnh, veiculo, cidade_base);

     }
}
