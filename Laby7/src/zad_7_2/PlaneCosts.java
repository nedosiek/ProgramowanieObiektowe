package zad_7_2;

public class PlaneCosts implements Transport {
    public double calculateCost(double distance){
        return distance*distance/100;
    }
}
