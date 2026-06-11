package view;

import model.enums.StatusEntrega;
import service.ServiceEntrega;
import utils.Ferramentas;

public class AtualizarStatus {
    
    
    public static void atualizarStatusEntrega(){

        Ferramentas.limpaTerminal(40);
        System.out.println("───────────────── Atualizando Status ────────────────");

        ServiceEntrega service = new ServiceEntrega();

        Ferramentas.limpaTerminal(3);

        Ferramentas.linha();
        System.out.print("Digite o id da entrega desejada: ");
        int entregaId = Ferramentas.lerInteiro();
        Ferramentas.linha();
        
        System.out.println("───────── Selecione o novo status ─────────");
        System.out.println("1 - Em rota");
        System.out.println("2 - Entregue");
        System.out.println("3 - Atrasado");
        Ferramentas.linha();
        System.out.print("Opção: ");
        int opStatus = Ferramentas.lerInteiro();

        StatusEntrega novoStatus;

        switch (opStatus) {
            case 1: {
                novoStatus = StatusEntrega.EM_ROTA;
                break;
            }
            case 2:{
                novoStatus = StatusEntrega.ENTREGUE;
                break;
            }
            default:{
                novoStatus = StatusEntrega.ATRASADA;
                break;
            }
        }

        try {
            service.serviceAtualizarStatus(entregaId, novoStatus);
        }catch(Exception e){
            System.out.println("Erro ao atualizar status: " + e.getMessage());
        }
            
        Ferramentas.esperarTecla();

    }

}
