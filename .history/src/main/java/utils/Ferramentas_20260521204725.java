package utils;

import java.util.Scanner;

public class Ferramentas {

    Scanner s = new Scanner(System.in);

    public static int lerInteiro(){

        int num = s.nextInt();
        s.nextLine();

        return num;
    }
}