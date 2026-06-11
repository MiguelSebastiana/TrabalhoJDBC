package view;

import model.Motorista;
import service.ServiceCliente;
import service.ServiceMotorista;
import utils.Ferramentas;

public class CadastrarMotorista {
 
    public static void cadastrarMotorista(){
        
        ServiceMotorista serviceMotorista = new ServiceMotorista();

        System.out.print("Digite o nome do motorista: ");
        String nome = Ferramentas.lerString();

        System.out.print("Digite o cnh do motorista: ");
        String cnh = Ferramentas.lerString();

        System.out.print("Digite o veiculo do motorista: ");
        String veiculo = Ferramentas.lerString();

        System.out.print("Digite a cidade base do motorista: ");
        String cidade_base = Ferramentas.lerString();

        try {
        Motorista motorista = new Motorista(nome, cnh, veiculo, cidade_base);
        serviceMotorista.serviceInserirMotorista(motorista);
        }catch

}
