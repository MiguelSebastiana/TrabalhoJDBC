package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import service.ServicePedido;
import utils.Ferramentas;

public class CancelarPedido {
    
    public static void cancelarPedido() throws SQLException{

        List<Pedido> pedidos = new ArrayList();

        var servicePedido = new ServicePedido();

        servicePedido.serviceListarTodos();

        pedidos =

        System.out.print("Digite o id do pedido que voce deseja cancelar: ");
        int id = Ferramentas.lerInteiro();
    }
}
