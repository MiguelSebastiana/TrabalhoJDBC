package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class PedidoPendenteEstado {
    
    public static void pedidosPendentesPorEstado(){
        
        ServiceEntrega service = new ServiceEntrega();

        System.out.println("--- Relatorio: Pedidos pendentes por Estado ---");
        
        try{
            List<String> relatorio = service.relatorioPendentesEstado()
        }
        Ferramentas.esperarTecla();

    }
}
