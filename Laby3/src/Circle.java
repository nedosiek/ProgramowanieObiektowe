// Oleksandr Nedosiek
// 275978

import java.util.*;
import java.lang.Math;

public class Circle {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Wpisz dlugosc promienia n: ");
        int N = scn.nextInt();
        printCircle(N);
    }

    public static void printCircle(int n){
        int srednica = 2*n+1;
        String[][] tab=new String[srednica][srednica];

        if (n<2){
            System.out.println("Dlugosc promienia ma byc co najmniej 2!");
            System.exit(0);
        }
        else {
            for (int i=0; i<srednica; i++){
                for (int j=0; j<srednica; j++){
                    if (Math.sqrt((i-n)*(i-n)+(j-n)*(j-n)) <= n){
                        tab[i][j]="# ";
                    }
                    else{
                        tab[i][j] = "  ";
                    }
                }
            }
        }

        for (int i=0; i<srednica; i++){
            for (int j=0; j<srednica; j++){
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }

    }
}
