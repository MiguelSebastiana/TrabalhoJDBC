package view;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Entrega;
import service.ServiceEntrega;
import utils.Ferramentas;

public class AtribuirPedido {

    public static void atribuirPedidoAoMotorista(){

        System.out.println("───────────────── Atribuindo Pedido ────────────────");

        ServiceEntrega service = new ServiceEntrega();

        Ferramentas.linha();
        System.out.print("Digite o id do pedido: ");
        int idPedido = Ferramentas.lerInteiro();
        Ferramentas.linha();

        System.out.print("Digite o id do motorista que voce deseja atribuir o pedido: ");
        int idMotorista = Ferramentas.lerInteiro();
        Ferramentas.linha();

        System.out.println("Digite a data de entrega: ");
        String data = Ferramentas.lerString();
        Ferramentas.linha();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataEntregaString = LocalDate.parse(data, formato);
        Date dataEntrega = Date.valueOf(dataEntregaString);
        Ferramentas.linha();

        try{
            Entrega entrega = service.serviceGerarEntrega(idPedido, idMotorista, dataEntrega);
        }catch (Exception e){
            System.out.println("Erro ao atribuir pedido " + e.getMessage());
        }
        
        Ferramentas.esperarTecla();

    }
}
