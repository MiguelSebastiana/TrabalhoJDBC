package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class ClientePorVolume {
    
    public static void clientesMaiorVolumeEntregue(){
     
        ServiceEntrega serviceEntrega = new ServiceEntrega();

        System.out.println("──── Relatorio: Clientes com Maior Valor Entregue ────");
        
        try {
            List<String> relatorio = serviceEntrega.relatorioClientesVolume();
            if(relatorio.isEmpty()){
                System.out.println("Não há nenhum cliente a ser listado");
            }else {
                for(String linha : relatorio){
                    System.out.println(linha);
                }
            }
        }catch(Exception e){
            Ferramentas.linha();
            System.out.println(""); 
            Ferramentas.linha();
        }

        Ferramentas.esperarTecla();

    }
}
