package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import service.ServiceCliente;
import utils.Ferramentas;

public class ExcluirCliente {
    
    public static void excluirCliente() throws SQLException{
        
        System.out.println("───────── Excluir Clientes ──────────");

        var serviceCliente = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<>();

        clientes = serviceCliente.serviceListarClientes();

        System.out.println("───────────── Clientes ─────────────");
        for(Cliente c : clientes){
            System.out.println("ID: " + c.getId());
            System.out.println("NOME: " + c.getNome());
            System.out.println("ESTADO: " + c.getEstado());
            System.out.println("CIDADE: " + c.getCidade());
            System.out.println("CPF/CNPJ: " + c.getCpf_cnpj());
            Ferramentas.linha();
        }

        System.out.print("Digite o id do cliente que voce deseja remover: ");
        int id = Ferramentas.lerInteiro();

        try {
            serviceCliente.serviceDeletarCliente(id);
        } catch(Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
            Ferramentas.linha();
        }
        
    }
}
