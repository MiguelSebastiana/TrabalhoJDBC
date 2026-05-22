package utils;

import java.util.Scanner;

public class Ferramentas {

    Scanner sc = new Scanner(System.in);

    public static int lerInteiro(){

        int num = sc.nextInt();
        sc.nextLine();

        return num;
    }
}