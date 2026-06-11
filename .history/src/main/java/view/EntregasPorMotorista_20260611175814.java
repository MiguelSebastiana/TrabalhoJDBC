package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class EntregasPorMotorista {
    
    public static void entregasPorMotorista(){

        ServiceEntrega service = new ServiceEntrega();
        System.out.println("--- Relatorio: total de entregas por motorista ---");
        
        try {
            List<String> relatorio = service.relatorioEntregasPorMotorista();
            if(relatorio.isEmpty(){
                System.out.println();
            }else {
                for(String linha : relatorio){
                    
                }
            }
        }
        Ferramentas.esperarTecla();
    
    }
}
