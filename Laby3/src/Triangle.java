import java.util.*;

public class Triangle{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Podaj liczbe wierszy: ");
        int N = scn.nextInt();
        print_triangle(N);
    }

    public static void print_triangle(int N) {
        int wierszy = 2*N-1;
        int[][] array = new int[N][wierszy];
        for (var tab : array){
            Arrays.fill(tab, 0);
        }
        array[0][wierszy/2] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < wierszy-1; j++) {
                /*if (j == 0 || j == N - 1) {
                    array[i][j] = 1;
                }
                else{*/
                array[i][j]=array[i-1][j-1]+array[i-1][j+1];
                /*}*/
            }
        }
        array[N-1][0]=1;
        array[N-1][wierszy-1]=1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < wierszy; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}