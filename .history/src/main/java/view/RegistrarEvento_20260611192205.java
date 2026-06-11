package view;

import model.HistoricoEntrega;
import service.ServiceHistorico;
import utils.Ferramentas;

public class RegistrarEvento {
    
    public static void registrarEventoEntrega(){
        
        Ferramentas.l
        System.out.println("──────────────── Cadastrando Cliente ───────────────");
        ServiceHistorico service = new ServiceHistorico();

        Ferramentas.linha();
        System.out.print("Id da entrega: ");
        int idEntrega = Ferramentas.lerInteiro();
        Ferramentas.linha();

        Ferramentas.linha();
        System.out.print("Descrição do Evento: ");
        String descricao = Ferramentas.lerString();
        Ferramentas.linha();

        try{
            HistoricoEntrega historico = service.registrarEvento(idEntrega, descricao);
        }catch (Exception e){
            System.out.println("Erro ao registrar evento: " + e.getMessage());
        }
        Ferramentas.esperarTecla();
    }
}
