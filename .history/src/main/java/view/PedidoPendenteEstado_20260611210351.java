package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class PedidoPendenteEstado {
    
    public static void pedidosPendentesPorEstado(){
        
        ServiceEntrega service = new ServiceEntrega();
        Ferramentas.limpaTerminal(40);

        System.out.println("──── Relatorio: Pedidos pendentes por Estado ────");
        
        try{
            List<String> relatorio = service.relatorioPendentesEstado();
            if(relatorio.isEmpty()){
                System.out.println("Não há nenhum pedido pendente por Estado");
            }else{
                for(String linha : relatorio){
                    Ferramentas.linha();
                    System.out.println(linha);
                }
            }
        }catch(Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao abrir relatorio de pedidos pendentes por estado");
            Ferramentas.linha();
        }

        Ferramentas.esperarTecla();

    }
}
