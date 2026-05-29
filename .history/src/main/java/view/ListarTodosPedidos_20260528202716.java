package view;

import java.sql.SQLException;

import service.ServicePedido;

public class ListarTodosPedidos {

    static ServicePedido servicePedido = new ServicePedido();

    public static void listrarPedidos() throws SQLException{

        servicePedido.serviceListarTodos();
    }    
}
