package view;

import java.util.List;

import service.ServiceEntrega;
import utils.Ferramentas;

public class ClientePorVolume {
    
    public static void clientesMaiorVolumeEntregue(){
     
        ServiceEntrega serviceEntrega = new ServiceEntrega();
        Ferramentas.limpaTerminal(40);
        System.out.println("──── Relatorio: Clientes com Maior Valor Entregue ────");

        Ferramentas.limpaTerminal(3);
        
        try {
            List<String> relatorio = serviceEntrega.relatorioClientesVolume();
            if(relatorio.isEmpty()){
                System.out.println("Não há nenhum cliente a ser listado");
                Ferramentas.linha();
            }else {
                for(String linha : relatorio){
                    System.out.println(linha);
                }
            }
        }catch(Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao abrir relatorio"); 
            Ferramentas.linha();
        }

        Ferramentas.esperarTecla();

    }
}
