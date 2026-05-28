package view;

import java.security.Provider.Service;

import model.Cliente;
import service.ServiceCliente;
import service.serviceCliente;
import utils.Ferramentas;

public class CadastrarCliente {

    static ServiceCliente serviceCliente = new ServiceCliente();

    public static void cadastrarCliente(){

        System.out.print("Digite o nome do cliente: ");
        String nome = Ferramentas.lerString();

        System.out.print("Digite o cpf do cliente: ");
        String cpf = Ferramentas.lerString();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = Ferramentas.lerString();

        System.out.print("Digite a cidade do cliente: ");
        String cidade = Ferramentas.lerString();

        System.out.print("Digite o estado do cliente: ");
        String estado = Ferramentas.lerString();

        Cliente cliente = new Cliente (nome, cpf, endereco, cidade, estado);

        serviceCliente.serviceInserirCliente(cliente);

     }

}
