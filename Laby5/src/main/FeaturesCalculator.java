package main;

import java.io.*;
import java.util.*;

public class FeaturesCalculator {
    private ArrayList<ArrayList<Integer>> binary_mask;
    private Integer[] mass_center;
    private String filename;
    private int amount;

    public FeaturesCalculator(String filename){
        this.filename = filename;
        this.binary_mask = new ArrayList<ArrayList<Integer>>();
        this.mass_center = new Integer[2];
        this.amount = 0;
    }

    public void read_data(){
        try{
            Scanner file_reader = new Scanner(new File(filename));
            while (file_reader.hasNextLine()){
                String data = file_reader.nextLine();
                ArrayList<Integer> data_array = new ArrayList<Integer>();
                for (int i=0; i<data.length(); i++){
                    if (data.charAt(i)==48){
                        data_array.add(0);
                    }
                    else if (data.charAt(i)==49){
                        data_array.add(1);
                    }
                }
                binary_mask.add(new ArrayList<Integer>(data_array));
            }
            file_reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Nie ma takiego pliku, podaj poprawna nazwe!");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void calculate_mass_center(){
        mass_center[0] = 0;
        mass_center[1] = 0;

        for (int i=0; i<binary_mask.size(); i++){
            for (int j=0; j<binary_mask.get(i).size(); j++){
                if (binary_mask.get(i).get(j) == 1){
                    mass_center[0] += i;
                    mass_center[1] += j;
                    amount++;
                }
            }
        }
        mass_center[0] = mass_center[0]/amount;
        mass_center[1] = mass_center[1]/amount;
    }

    public void save_results(){
        try{
            FileWriter file_create = new FileWriter(filename.replaceAll("\\.(txt)", "") + "_out.txt");
            String file_write_point = "P = (" + mass_center[0] + "; " + mass_center[1] + ")";
            Scanner file_reader_output = new Scanner(new File(filename));
            ArrayList<ArrayList<String>> data_new_file = new ArrayList<ArrayList<String>>();
            while(file_reader_output.hasNextLine()){
                String file_data = file_reader_output.nextLine();
                ArrayList<String> data_new_file_row = new ArrayList<String>();
                char[] char_array = file_data.toCharArray();
                for (char i: char_array){
                    data_new_file_row.add(String.valueOf(i));
                }
                data_new_file.add(new ArrayList<String>(data_new_file_row));
            }
            for (int i=0; i<data_new_file.size(); i++){
                for (int j=0; j<data_new_file.get(i).size(); j++){
                    if ((i==mass_center[0]) && (j==2*mass_center[1])){
                        data_new_file.get(i).set(j, "P");
                        //System.out.println(data_new_file.get(i));
                    }
                    file_create.write(data_new_file.get(i).get(j));
                }
                file_create.write("\n");
            }

            file_create.write(file_write_point);
            file_create.close();
            file_reader_output.close();
            //System.out.println(data_new_file + "\n");
            System.out.println("Dane zostaly wpisane do nowego pliku!");
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Scanner file_obj_input = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku: ");
        String filename = file_obj_input.nextLine();
        System.out.println("Nazwa pliku: " + System.getProperty("user.dir")+"\\" + filename);
        file_obj_input.close();
        FeaturesCalculator calculator = new FeaturesCalculator(filename);
        calculator.read_data();
        calculator.calculate_mass_center();
        calculator.save_results();
    }
}