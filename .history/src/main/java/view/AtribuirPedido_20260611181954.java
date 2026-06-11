package view;

import java.sql.Date;
import java.time.LocalDate;

import model.Entrega;
import service.ServiceEntrega;
import utils.Ferramentas;

public class AtribuirPedido {

    public static void atribuirPedidoAoMotorista(){

        ServiceEntrega service = new ServiceEntrega();

        System.out.print("Digite o id do pedido: ");
        int idPedido = Ferramentas.lerInteiro();

        System.out.print("Digite o id do motorista que voce deseja atribuir o pedido: ");
        int idMotorista = Ferramentas.lerInteiro();

        System.out.println("Digite a data de entrega: ");
        String data = Ferramentas.lerString();

        LocalDate dataEntrega = value

        try{
            Entrega entrega = service.serviceGerarEntrega(idPedido, idMotorista, dataEntrega);
        }catch (Exception e){
            System.out.println("Erro ao atribuir pedido " + e.getMessage());
        }
        
        Ferramentas.esperarTecla();

    }
}
