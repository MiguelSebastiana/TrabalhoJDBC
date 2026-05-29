package view;

import service.ServicePedido;
import utils.Ferramentas;

public class CancelarPedido {
    
    public static void cancelarPedido(){

        var servicePedido = new ServicePedido();

        System.out.print("Digite o id do pedido que voce deseja cancelar: ");
        int id = Ferramentas.lerInteiro();
    }
}
