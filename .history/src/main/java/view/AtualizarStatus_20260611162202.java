package view;

import utils.Ferramentas;

public class AtualizarStatus {
    
    public static void atualizarStatusEntrega(){
        
        int opcao = 0;

        System.out.println("Digite o id da entrega desejada");
        
        System.out.println("Selecione o novo status");
        System.out.println("1 - Em rota");
        System.out.println("2 - Entregue");
        System.out.println("3 - Atrasado");
        System.out.print("Opção: ");
        int opStatus = Ferramentas.lerInteiro();

    }
}
