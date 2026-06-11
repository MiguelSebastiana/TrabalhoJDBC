package view;

import service.ServiceHistorico;
import utils.Ferramentas;

public class RegistrarEvento {
    
    public static void registrarEventoEntrega(){
        
        ServiceHistorico service = new ServiceHistorico();

        System.out.println("Id da entrega: ");
        int idEntrega = Ferramentas.lerInteiro();

        System.out.println();
    }
}
