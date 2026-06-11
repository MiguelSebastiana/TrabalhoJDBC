package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import service.ServicePedido;
import utils.Ferramentas;

public class CancelarPedido {
    
    public static void cancelarPedido() throws SQLException{

        Ferramentas.limpaTerminal(40);
        System.out.println("───────────── Cancelando Motorista ─────────────");

        List<Pedido> pedidos = new ArrayList();

        var servicePedido = new ServicePedido();

        pedidos = servicePedido.serviceListarTodos();

        System.out.println("───────────────────── PEDIDOS ──────────────────────");
        for(Pedido p : pedidos){
            System.out.println("ID: " + p.getId());
            System.out.println("ID DO CLIENTE: " + p.getCliente_id());
            System.out.println("PESO DO PEDIDO: " + p.getPeso_kg());
            Ferramentas.linha();
        }

        Ferramentas.linha();
        System.out.print("Digite o id do pedido que voce deseja cancelar: ");
        int id = Ferramentas.lerInteiro();
        Ferramentas.linha();

        try{
        servicePedido.serviceCancelarPedido(id);
        }catch(Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao tentar cancelar pedido: " + e.getMessage());
            Ferramentas.linha();
        }
        Ferramentas.esperarTecla();
    }
}
