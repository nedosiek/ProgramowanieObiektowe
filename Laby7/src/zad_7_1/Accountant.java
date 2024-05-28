package zad_7_1;

public class Accountant extends Employee {
    public Accountant(String name, String surname, double salary){
        super(name, surname, salary); // wywolujemy konstruktor klasy bazowej
        this.getBonus(0.12*salary); // premia dla ksiegowych - 12% od pensji
    }
}
