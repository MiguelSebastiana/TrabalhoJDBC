package utils;

import java.util.Scanner;

public class Ferramentas {

    static Scanner sc = new Scanner(System.in);

    public static int lerInteiro(){

        int num = sc.nextInt();
        sc.nextLine();

        return num;
    }

    public static String lerString(){
        
        return sc.nextLine();
        
    }

    public static Double lerDouble(){

        double num = sc.nextDouble();
        sc.nextLine();

        return num;
    }

    public static void limpaTerminal(int linhas){

        for(int i = 0; i <= linhas; i++){
            System.out.println("");
        }
    }

    public static void esperarTecla() {
        System.out.println("\nPressione Enter para continuar...");

        sc.nextLine();
    }

    public static void linha () {
        System.out.println("────────────────────────────────────────────────────");
    }

    public static void Delay(int delay){

        try{
            Thread.sleep(delay);
        }
    }
}