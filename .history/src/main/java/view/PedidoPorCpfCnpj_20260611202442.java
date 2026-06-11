package view;

import java.sql.SQLException;

import model.Pedido;
import service.ServicePedido;
import utils.Ferramentas;

public class PedidoPorCpfCnpj {
    
    public static void pedidoPorCPFCNPJ() throws SQLException{

        var service = new ServicePedido();
        
        System.out.println("Digite o cpf/cnpj do usuario desejado: ");
        String CpfCnpj = Ferramentas.lerString();

        try{
             Pedido pedido = service.serviceBuscarPorCpfCnpj(CpfCnpj);
             if(pedido != null) {
                System.out.println("Pedido achado");
                System.out.println("Id: " + pedido.getId());
                System.out.println("Id do cliente: " + pedido.getCliente_id());
                System.out.println("Peso: " + pedido.getPeso_kg());
                System.out.println("Volume: " + pedido.getVolume_m3());
             }else{
                Ferramentas.linha();
                System.out.println("Nenhum pedido achado com esse cpf/cnpj");
                Ferramentas.linha();
             }
    
        }catch(Exception e){
            Ferramentas.linha();
            System.err.println("Erro ao buscar!");
            Ferramentas.linha();
        }
        Ferramentas.esperarTecla();
    }
}
