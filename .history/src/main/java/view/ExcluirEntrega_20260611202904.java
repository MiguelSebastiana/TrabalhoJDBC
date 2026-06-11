package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Entrega;
import model.Pedido;
import service.ServiceEntrega;
import utils.Ferramentas;

public class ExcluirEntrega {
    
    public static void excluirEntrega() throws SQLException{
        
        List<Entrega> entregas = new ArrayList<>();

        var serviceEntrega = new ServiceEntrega();

        entregas = serviceEntrega.serviceListarEntregas();

        Ferramentas.limpaTerminal(40);
        System.out.println("───────── Excluir Entrega ──────────");

        Ferramentas.limpaTerminal(3);

        System.out.println("─────────────── ENTREGAS ───────────────");
        for(Entrega e : entregas){
            System.out.println("ID: " + e.getId());
            System.out.println("ID DO MOTORISTA: " + e.getMotorista_id());
            System.out.println("ID DO PEDIDO: " + e.getPedido_id());
            System.out.println("──────────────────────────────────────────");
        }

        Ferramentas.linha();
        System.out.print("Digite o id da entrega que voce deseja cancelar: ");
        int id = Ferramentas.lerInteiro();
        Ferramentas.linha();

        try{
        serviceEntrega.serviceCancelarEntrega(id);
        }catch(Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao excluir entrega: " + e.getMessage());
            Ferramentas.linha();
        }
    }
}
