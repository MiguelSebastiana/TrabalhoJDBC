package view;

import java.util.InputMismatchException;

import model.Cliente;
import utils.Ferramentas;

public class MenuInicial {

     public static void menu(){

        boolean verifica = false;

        do{
            try{
                System.out.println("--- Menu Principal ---");
                System.out.println("1 - Cadastrar cliente");
                System.out.println("2 - Cadastrar motorista");
                System.out.println("3 - Criar pedido");
                System.out.println("4 - Atribuir Pedido a Motorista");
                System.out.println("5 - Registrar Evento de Entrega");
                System.out.println("6 - Atualizar Status da entrega");
                System.out.println("7 - Listar Todas as Entregas com Cliente e Motorista");
                System.out.println("8 - Relatório: Total de Entregas por Motorista");
                System.out.println("9 - Relatório: Clientes com Maior Volume Entregue");
                System.out.println("10 - Relatório: Pedidos Pendentes por Estado");
                System.out.println("11 - Relatório: Entregas Atrasadas por Cidade");
                System.out.println("12 - Buscar Pedido por CPF/CNPJ do Cliente");
                System.out.println("13 - Cancelar Pedido");
                System.out.println("14 - Excluir Entrega (com validação)");
                System.out.println("15 - Excluir Cliente (com verificação de dependência)");
                System.out.println("16 - Excluir Motorista (com verificação de dependência)");
                System.out.println("0 - Sair ");
                int opcao = Ferramentas.lerInteiro();

                switch (opcao) {
                    case 1:
                        cadastrarCliente();
                        break;
                
                    default:
                        break;
                    }
               }catch(InputMismatchException e){
                    e.printStackTrace();
               }
        }while (!verifica); 
            
        }
     }

     public static void cadastrarCliente(){

        System.out.println("Digite o nome do cliente: ");
        String nome = Ferramentas.lerString();

        System.out.println("Digite o cpf do cliente: ");
        String cpf = Ferramentas.lerString();

        System.out.println("Digite o endereço do cliente: ");
        String endereco = Ferramentas.lerString();

        System.out.println("Digite a cidade do cliente: ");
        String cidade = Ferramentas.lerString();

        System.out.println("Digite o estado do cliente: ");
        String estado = Ferramentas.lerString();

        var cliente = new Cliente (nome, cpf, endereco, cidade, estado);
     }
}