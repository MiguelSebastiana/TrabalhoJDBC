package utils;

import java.util.Scanner;

public class Ferramentas {

    static Scanner sc = new Scanner(System.in);

    public static int lerInteiro(){

        int num = sc.nextInt();
        sc.nextLine();

        return num;
    }

    public static String lerString(){}
}