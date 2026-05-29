package view;

import java.sql.SQLException;
import java.util.List;

import service.ServicePedido;
import utils.Ferramentas;

public class CancelarPedido {
    
    public static void cancelarPedido() throws SQLException{

        List<Pedido

        var servicePedido = new ServicePedido();

        servicePedido.serviceListarTodos();

        System.out.print("Digite o id do pedido que voce deseja cancelar: ");
        int id = Ferramentas.lerInteiro();
    }
}
