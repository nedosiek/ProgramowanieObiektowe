package zad_7_2;

public class Main {
    public static void main(String[] args) {
        TrainCosts train = new TrainCosts();
        PlaneCosts plane = new PlaneCosts();

        System.out.println("Zysk dla dystansu 200, wynagrodzenia 10 i pociagu wynosi: " + Profit.calculateProfit(train, 200, 10) + "\n");

        System.out.println("Samolot:");
        double a = Profit.calculateProfit(plane, 50, 50);
        double b = Profit.calculateProfit(plane, 30, 40);
        System.out.println("Dla dystansu 50 i wynagrodzeniem 50: " + a);
        System.out.println("Dla dystansu 30 i wynagrodzeniem 40: " + b);
        if (a<b){
            System.out.println("Drugie zlecenie da wiekszy zysk\n");
        } else if (a>b){
            System.out.println("Pierwsze zlecenie da wiekszy zysk\n");
        } else {
            System.out.println("Oba zlecenia dadza ten sam zysk\n");
        }

        System.out.println("Dla dystansu 350 i wynagrodzenia 45:");
        double c = Profit.calculateProfit(plane, 350, 45);
        double d = Profit.calculateProfit(train, 350, 45);
        System.out.println("Samolot: " + c);
        System.out.println("Pociag: " + d);
        if (c>d){
            System.out.println("Zlecenie samolotem da wiekszy zysk");
        } else if (c<d){
            System.out.println("Zlecenie pociagiem da wiekszy zysk");
        } else {
            System.out.println("Oba zlecenia dadza ten sam zysk");
        }
    }
}
