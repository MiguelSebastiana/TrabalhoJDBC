package view;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Motorista;
import service.ServiceCliente;
import service.ServiceMotorista;
import utils.Ferramentas;

public class ExcluirMotorista {
    
    public static void excluirMotorista(){
        
        var serviceMotorista = new ServiceMotorista();
        List<Motorista> motoristas = new ArrayList<>();

        motoristas = serviceMotorista.serviceListarMotoristas();

        System.out.println("--- Motoristas ---");
        for(Motorista m : motoristas){
            System.out.println("ID: " + m.getId());
            System.out.println("NOME: " + c.getNome());
            System.out.println("ESTADO: " + c.getEstado());
            System.out.println("CIDADE: " + c.getCidade());
            System.out.println("CPF/CNPJ: " + c.getCpf_cnpj());
            System.out.println("--------------------------------");
        }

        System.out.print("Digite o id do motorista que voce deseja deletar: ");
        int id = Ferramentas.lerInteiro();

        
    }
}
