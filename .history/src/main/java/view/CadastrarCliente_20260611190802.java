package view;

import java.security.Provider.Service;

import model.Cliente;
import service.ServiceCliente;
import utils.Ferramentas;

public class CadastrarCliente {

    

    public static void cadastrarCliente(){

        Ferramentas.limpaTerminal(40);
        System.out.println("──────────────── Cadastrando Cliente ───────────────");

        ServiceCliente serviceCliente = new ServiceCliente();
        
        Ferramentas.limpaTerminal(3);

        Ferramentas.linha();
        System.out.print("Digite o nome do cliente: ");
        String nome = Ferramentas.lerString();
        Ferramentas.linha();

        Ferramentas.linha();
        System.out.print("CPF/CNPJ: ");
        String cpf = Ferramentas.lerString();
        Ferramentas.linha();

        Ferramentas.linha();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = Ferramentas.lerString();
        Ferramentas.linha();

        Ferramentas.linha();
        System.out.print("Digite a cidade do cliente: ");
        String cidade = Ferramentas.lerString();

        System.out.print("Digite o estado do cliente: ");
        String estado = Ferramentas.lerString();
        try{
        Cliente cliente = new Cliente (nome, cpf, endereco, cidade, estado);
        serviceCliente.serviceInserirCliente(cliente);
        }catch(IllegalArgumentException e){
            System.out.println("Erro de validação " + e.getMessage());
        }

        Ferramentas.esperarTecla();

     }



}
