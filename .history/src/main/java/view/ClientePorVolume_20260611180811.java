package view;

import service.ServiceEntrega;
import utils.Ferramentas;

public class ClientePorVolume {
    
    public static void clientesMaiorVolumeEntregue(){
     
        ServiceEntrega serviceEntrega = new ServiceEntrega();

        System.out.println("--- Relatorio: Clientes com Maior Valor Entregue ---");
        
        try {
            List<String> relatorio = serviceEntrega.relatorioClientesVolume();
            if()
        }

        Ferramentas.esperarTecla();

    }
}
