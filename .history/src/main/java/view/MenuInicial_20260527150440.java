package view;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;

import model.Cliente;
import model.Motorista;
import model.Pedido;
import model.enums.StatusPedido;
import repository.ClienteDAO;
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
                System.out.print("Digite a opção desejada: ");
                int opcao = Ferramentas.lerInteiro();

                switch (opcao) {
                    case 1:{
                        cadastrarCliente();
                        break;
                    }

                    case 2:{
                        cadastrarMotorista();
                        break;
                    }

                    case 3:{
                        criarPedido();
                        break;
                    }

                    case 4:{
                        
                    }
                
                    default:
                        break;
                    }
               }catch(InputMismatchException e){
                    e.printStackTrace();
               }
        }while (!verifica);    
     }

     public static void cadastrarCliente(){

        System.out.print("Digite o nome do cliente: ");
        String nome = Ferramentas.lerString();

        System.out.print("Digite o cpf do cliente: ");
        String cpf = Ferramentas.lerString();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = Ferramentas.lerString();

        System.out.print("Digite a cidade do cliente: ");
        String cidade = Ferramentas.lerString();

        System.out.print("Digite o estado do cliente: ");
        String estado = Ferramentas.lerString();

        Cliente cliente = new Cliente (nome, cpf, endereco, cidade, estado);

    
     }

     public static void cadastrarMotorista(){
        System.out.print("Digite o nome do motorista: ");
        String nome = Ferramentas.lerString();

        System.out.print("Digite o cnh do motorista: ");
        String cnh = Ferramentas.lerString();

        System.out.print("Digite o veiculo do motorista: ");
        String veiculo = Ferramentas.lerString();

        System.out.print("Digite a cidade base do motorista: ");
        String cidade_base = Ferramentas.lerString();

        Motorista motorista = new Motorista(nome, cnh, veiculo, cidade_base);

     }

     public static void criarPedido (){
        System.out.print("Digite o id do cliente responsável pelo cliente: ");
        int id = Ferramentas.lerInteiro();

        LocalDate date = LocalDate.now();
        Date data = Date.valueOf(date);

        System.out.print("Digite o volume: ");
        double volume = Ferramentas.lerDouble();

        System.out.print("Digite o peso: ");
        double peso = Ferramentas.lerDouble();

        Pedido pedido = new Pedido(id, data, volume, peso, StatusPedido.PENDENTE);
     }

     public static void atribuirPedidoAoMotorista(){
        System.out.print("Digite o id do motorista desejado: ");
     }
}