package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class EntregasPorMotorista {
    
    public static void entregasPorMotorista(){

        ServiceEntrega service = new ServiceEntrega();

        Ferramentas.limpaTerminal(40);
        System.out.println("──── Relatorio: total de entregas por motorista ────");

        Ferramentas.limpaTerminal(3);
        
        try {
            List<String> relatorio = service.relatorioMotoristas();
            if(relatorio.isEmpty()){
                Ferramentas.linha();
                System.out.println("Não há nenhuma entrega de motorista a ser listada");
                Ferramentas.linha();
            }else {
                for(String linha : relatorio){
                    Ferramentas.linha();
                    System.out.println(linha);
                    Ferramentas.linha();
                }
            }
        }catch(Exception e){
            Ferramentas.linha();
            e.printStackTrace();
            Ferramentas.linha();
        }
        Ferramentas.esperarTecla();
    
    }
}
