package zad_7_1;

public class Programmer extends ITEmployee {
    public Programmer(String name, String surname, double salary, int experience){
        super(name, surname, salary, experience);
        this.tax /= 3; // dzialalnosc kreatywna - 1/3 podatku
    }
}
