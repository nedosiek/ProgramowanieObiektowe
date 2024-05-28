package zad_7_1;

public class Company {
    public static void main(String[] args) {
        Programmer jan = new Programmer("Jan", "Student", 2000, 1);
        ITEmployee marzena = new ITEmployee("Marzena", "Bogata", 15000, 3);
        Programmer oskar = new Programmer("Oskar", "Przerwa-Tetmajer", 8000, 8);
        Accountant konrad = new Accountant("Konrad", "Zielony", 3500);

        System.out.println(jan);
        System.out.println(marzena);
        System.out.println(oskar);
        System.out.println(konrad);
    }
}