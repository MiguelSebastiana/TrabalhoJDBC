package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class EntregaAtrasadoCidade {
    
    public static void entregasAtrasadasPorCidade(){

        ServiceEntrega serviceEntrega = new ServiceEntrega();

        System.out.println("──── Relatorio: Entrega atrasadas por cidade ────");
        
        Ferramentas.limpaTerminal(3);
        try {
            
            List<String> relatorio = serviceEntrega.relatorioAtrasadasCidade();
            if(relatorio.isEmpty()){
                System.out.println();
            }else{
                for(String linha : relatorio){
                    System.out.println(linha);
                }
            }
        } catch (Exception e) {
            
        }
        Ferramentas.esperarTecla();

    }
}
