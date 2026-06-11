package view;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Pedido;
import model.enums.StatusPedido;
import repository.PedidoDAO;
import service.ServicePedido;
import utils.Ferramentas;

public class CriarPedido {

    public static void criarPedido (){

        var servicePedido = new ServicePedido();

        System.out.print("Digite o id do cliente responsável pelo pedido: ");
        int id = Ferramentas.lerInteiro();

        LocalDate date = LocalDate.now();
        Date data = Date.valueOf(date);

        System.out.print("Digite o volume: ");
        double volume = Ferramentas.lerDouble();

        System.out.print("Digite o peso: ");
        double peso = Ferramentas.lerDouble();

        try {
        Pedido pedido = new Pedido(id, data, volume, peso, StatusPedido.PENDENTE);
        servicePedido.serviceInserirPedido(pedido);

     }

}
