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
                System.out.println("");
             }else{
                System.out.println("Nenhum pedido achado com esse cpf/cnpj");
             }
    
    }catch(Exception e){
        System.out.println("Erro ao buscar!");
    }
    Ferramentas.esperarTecla();
}
