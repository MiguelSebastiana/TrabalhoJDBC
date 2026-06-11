package view;

import model.Entrega;
import service.ServiceEntrega;
import utils.Ferramentas;

public class AtribuirPedido {

    public static void atribuirPedidoAoMotorista(){

        ServiceEntrega service = new ServiceEntrega();

        System.out.println("Digite o id do pedido: ");
        int idPedido = Ferramentas.lerInteiro();

        System.out.println("Digite o id do motorista que voce deseja atribuir o pedido: ");
        int idMotorista = Ferramentas.lerInteiro();

        try{
            Entrega entrega = service.serviceGerarEntrega(idPedido, idMotorista);
        }catch (Exception e){
            System.out.println("Erro ao atribuir pedido");
        }
        
    }
}
