package zad_7_1;

public class ITEmployee extends Employee {
    protected int experience;

    public ITEmployee (String name, String surname, double salary, int experience){
        super(name, surname, salary);
        this.experience = experience;
        this.getBonus(calculateBonus(experience));
    }

    // obliczamy premie w zaleznosci od doswiadczenia
    public static double calculateBonus(int experience){
        if (experience<5 && experience>=2){
            return 750.0;
        } else if (experience>=5 && experience<7){
            return 2000.0;
        } else if (experience>=7){
            return 5000.0;
        } else{
            return 0.0;
        }
    }

}
