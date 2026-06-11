package view;

import model.HistoricoEntrega;
import service.ServiceHistorico;
import utils.Ferramentas;

public class RegistrarEvento {
    
    public static void registrarEventoEntrega(){
        
        ServiceHistorico service = new ServiceHistorico();

        System.out.print("Id da entrega: ");
        int idEntrega = Ferramentas.lerInteiro();

        System.out.print("Descrição do Evento: ");

        try{
            HistoricoEntrega historico
        }
    }
}
