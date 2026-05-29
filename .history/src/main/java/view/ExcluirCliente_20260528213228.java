package view;

import java.sql.SQLException;

import service.ServiceCliente;
import utils.Ferramentas;

public class ExcluirCliente {
    
    public static void excluirCliente() throws SQLException{
        
        var serviceCliente = new ServiceCliente();

        System.out.print("Digite o id do cliente que voce deseja remover: ");
        int id = Ferramentas.lerInteiro();

        serviceCliente.serviceDeletarCliente(id);
        
    }
}
