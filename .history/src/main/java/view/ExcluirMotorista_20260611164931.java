package view;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import service.ServiceCliente;
import utils.Ferramentas;

public class ExcluirMotorista {
    
    public static void excluirMotorista(){
        
        var serviceCliente = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<>();

        clientes = serviceCliente.serviceListarClientes();

        System.out.println("--- Clientes ---");
        for(Cliente c : clientes){
            System.out.println("ID: " + c.getId());
            System.out.println("NOME: " + c.getNome());
            System.out.println("ESTADO: " + c.getEstado());
            System.out.println("CIDADE: " + c.getCidade());
            System.out.println("CPF/CNPJ: " + c.getCpf_cnpj());
            System.out.println("--------------------------------");
        }
        
        System.out.print("Digite o id do motorista que voce deseja deletar: ");
        int id = Ferramentas.lerInteiro();

        
    }
}
