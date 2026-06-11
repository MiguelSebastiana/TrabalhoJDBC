package view;

import java.util.List;

import model.Entrega;
import service.ServiceEntrega;

public class EntregasClienteEMotorista {
    
    public static void entregasClienteEMotorista(){
        ServiceEntrega service = new ServiceEntrega();

        System.out.println("--- Lista de todas as entregas ---");

        try {
            List<Entrega> entregas = service.serviceListarEntregas();
            if(entregas.isEmpty()){
                System.out.println("Nenhuma entrega encontrada");
            } else {
                for(Entrega e : entregas){
                    System.out.println("Id entrega : ");
                }
            }
        }
    }
}
