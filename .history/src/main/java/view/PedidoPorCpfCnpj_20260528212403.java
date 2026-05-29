package view;

import java.sql.SQLException;

import service.ServicePedido;
import utils.Ferramentas;

public class PedidoPorCpfCnpj {
    
    public static void pedidoPorCPFCNPJ() throws SQLException{

        var servicePedido = new ServicePedido();

        System.out.println("Digite o cpf/cnpj do usuario desejado: ");
        String CpfCnpj = Ferramentas.lerString();

        servicePedido.serviceBuscarPorCpfCnpj(CpfCnpj);

        
    }
}
