package zad_7_1;

public class Employee {
    private String name;
    private String surname;
    protected double salary;
    protected double tax = 0.19; // ustalony dla kazdego pracownika podatek
    protected double bonus; // premia

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    //dodajemy premie do pensji
    public double getBonus(double bonus) {
        this.bonus = bonus;
        return bonus+salary;
    }

    // obliczamy calosc pensji po podatkach i premiach
    public double getSalary(){
        return getBonus(bonus) - getBonus(bonus)*tax;
    }

    // wypisujemy otrzymana pensje
    @Override
    public String toString(){
        return name + " " + surname + ": " + getSalary();
    }
}
