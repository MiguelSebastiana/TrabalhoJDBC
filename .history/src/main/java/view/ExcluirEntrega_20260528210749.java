package view;

import java.util.ArrayList;
import java.util.List;

import model.Entrega;
import model.Pedido;
import service.ServiceEntrega;

public class ExcluirEntrega {
    
    public static void excluirEntrega(){
        
        List<Entrega> entregas = new ArrayList<>();

        var serviceEntrega = new ServiceEntrega();

        entregas = serviceEntrega.serviceListarEntregas();

        System.out.println("--- ENTREGAS ---");
        for(Entrega e : entregas){
            System.out.println("ID: " + e.getId());
            System.out.println("ID DO MOTORISTA: " + e.getMotorista_id());
            System.out.println("PESO DO PEDIDO: " + e.get());
            System.out.println("---------------------------------------");
        }

    }
}
