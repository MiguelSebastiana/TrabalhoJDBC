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
import repository.EntregaDAO;
import utils.Ferramentas;

public class MenuInicial {

     public static void menu() throws SQLException{

        boolean verifica = false;

        do{
            try{

                Ferramentas.limpaTerminal(30);
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
                        CadastrarCliente.cadastrarCliente();
                        break;
                    }

                    case 2:{
                        CadastrarMotorista.cadastrarMotorista();
                        break;
                    }

                    case 3:{
                        CriarPedido.criarPedido();
                        break;
                    }

                    case 4:{
                        AtribuirPedido.atribuirPedidoAoMotorista();
                        break;
                    }

                    case 5:{
                        RegistrarEvento.registrarEventoEntrega();
                        break;
                    }

                    case 13:{
                        AtualizarStatus.atualizarStatusEntrega();
                        break;
                    }

                    case 7:{
                        EntregasClienteEMotorista.entregasClienteEMotorista();
                        break;
                    }

                    case 8:{
                        EntregasPorMotorista.entregasPorMotorista();
                        break;
                    }

                    case 9:{
                        ClientePorVolume.clientesMaiorVolumeEntregue();
                        break;
                    }

                    case 10:{
                        PedidoPendenteEstado.pedidosPendentesPorEstado();
                        break;
                    }

                    case 11:{
                        EntregaAtrasadoCidade.entregasAtrasadasPorCidade();
                        break;
                    }

                    case 12:{
                        PedidoPorCpfCnpj.pedidoPorCPFCNPJ();
                        break;
                    }

                    case 13:{
                        CancelarPedido.cancelarPedido();
                        break;
                    }

                    case 14:{
                        ExcluirEntrega.excluirEntrega();
                        break;
                    }

                    case 15:{
                        ExcluirCliente.excluirCliente();
                        break;
                    }

                    case 16:{
                        ExcluirMotorista.excluirMotorista();
                        break;
                    }

                    case 0:{
                        System.exit(1);
                    }
                
                    default:{
                        break;
                    }
                }

               }catch(InputMismatchException e){
                    e.printStackTrace();
               }
        }while (!verifica);    
    }
}