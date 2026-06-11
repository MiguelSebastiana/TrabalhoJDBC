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

        Ferramentas.limpaTerminal(40);
        System.out.println("───────────────── Criando Pedido ─────────────────");
        var servicePedido = new ServicePedido();

        Ferramentas.limpaTerminal(3);

        Ferramentas.linha();
        System.out.print("Digite o id do cliente responsável pelo pedido: ");
        int id = Ferramentas.lerInteiro();
        Ferramentas.linha();

        LocalDate date = LocalDate.now();
        Date data = Date.valueOf(date);

        Ferramentas.linha();
        System.out.print("Digite o volume: ");
        double volume = Ferramentas.lerDouble();
        Ferramentas.linha();

        System.out.print("Digite o peso: ");
        double peso = Ferramentas.lerDouble();
        Ferramentas.linha();

        try {
        Pedido pedido = new Pedido(0, id, data, volume, peso, StatusPedido.PENDENTE);
        servicePedido.serviceInserirPedido(pedido);
        } catch (Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao criar pedido " + e.getMessage());
            Ferramentas.linha();
        }

        Ferramentas.esperarTecla();
     }

}
