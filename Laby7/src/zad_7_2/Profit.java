package zad_7_2;

public class Profit {
    public static double calculateProfit(Transport mode, double distance, double money){
        return money - mode.calculateCost(distance);
    }
}

