package main;

import java.util.*;
import java.io.*;

public class CenterCalculator {
    private static String filename;
    private static ArrayList<ArrayList<Integer>> binaryMask;
    private static int centerX;
    private static int centerY;

    public static int readMask() {
        try {
            binaryMask = new ArrayList<ArrayList<Integer>>();
            File name = new File(filename+".txt");
            Scanner file_reader = new Scanner(name);

            while (file_reader.hasNextLine()) {
                String data = file_reader.nextLine();
                ArrayList<Integer> data_array = new ArrayList<Integer>();
                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) == 48) {
                        data_array.add(0);
                    } else if (data.charAt(i) == 49) {
                        data_array.add(1);
                    }
                }
                binaryMask.add(new ArrayList<Integer>(data_array));
            }
            System.out.println("Otworzono!");
            file_reader.close();
            return 0;
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku, podaj poprawna nazwe!");
            e.printStackTrace();
            return -1;
        }
    }

    public static int calculateCenter() {
        centerX = 0;
        centerY = 0;
        int amount =0;
        for (int i = 0; i < binaryMask.size(); i++) {
            for (int j = 0; j < binaryMask.get(i).size(); j++) {
                if (binaryMask.get(i).get(j) == 1) {
                    centerX += i;
                    centerY += j;
                    amount++;
                }
            }
        }
        if ((centerX % amount != 0) || (centerY % amount != 0)) {
            System.out.println("Srodek ma wspolrzedne niecalkowite");
            return -1;
        }
        centerX /= amount;
        centerY /= amount;
        return 0;
    }


    public static int saveResult() {
        try {
            FileWriter file_create = new FileWriter(filename + "_solution.txt");
            for (int i=0; i<binaryMask.size(); i++) {
                for (int j = 0; j < binaryMask.get(i).size(); j++) {
                    if ((i == centerX) && (j == centerY)) {
                        file_create.write("P ");
                    } else {
                        file_create.write(binaryMask.get(i).get(j) + " ");
                    }
                }
                file_create.write("\n");
            }
            file_create.close();
            System.out.println("Dane zostaly wpisane do nowego pliku!");
            return 0;

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");
        filename = scn.nextLine();
        scn.close();
        if (readMask()==0){
            if(calculateCenter()==0){
                saveResult();
            };
        }
    }
}
