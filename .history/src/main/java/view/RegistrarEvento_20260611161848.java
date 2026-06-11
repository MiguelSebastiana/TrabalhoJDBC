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
        String descricao = Ferramentas.lerString();

        try{
            HistoricoEntrega historico = service.registrarEvento(idEntrega, descricao);
        }catch (Exception e){
            System.out.println("");
        }
    }
}
