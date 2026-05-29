package view;

import service.ServiceCliente;
import utils.Ferramentas;

public class ExcluirCliente {
    
    public static void excluirCliente(){
        
        var serviceCliente = new ServiceCliente();

        System.out.print("Digite o id do cliente que voce deseja remover: ");
        int id = Ferramentas.lerInteiro();

        serviceCliente.serviceDeletarCliente(id);
    }
}
