public class Item {
    private class Date{
        private int day_, month_, year_;
        public Date(int day, int month, int year){
            day_ = day;
            month_ = month;
            year_ = year;
        }
        public String toString(){
            return day_ + "/" + month_ + "/" + year_;
        }
    }

    enum Category{
        Fruits,
        Vegetables,
        Drink,
        Meat,
        Baking,
        ERROR
    }
    private String name_;
    private String country_;
    private double price_;
    private Category category_;
    private Date date_;

    private static int countStatic_ = 0;
    //public int countNonStatic_ = 0;
    //public static int idStatic_ = 0;
    private int idNonStatic_ = 0;



    public Item(){
        name_ = "ERROR";
        category_ = Category.ERROR;
        country_ = "ERROR";
        price_ = -1;
        date_ = new Date(-1, -1, -1);

        countStatic_++;
        //countNonStatic_++;
        //idStatic_++;
        idNonStatic_ = countStatic_;

        System.out.println("--Wywolanie konstruktora domyslnego--");
    }

    public Item(String name, Category category, String country, double price, int day_, int month_, int year_){
        name_ = name;
        category_ = category;
        country_ = country;
        price_ = price;
        date_ = new Date(day_, month_, year_);

        countStatic_++;
        //countNonStatic_++;
        //idStatic_++;
        idNonStatic_ = countStatic_;

        System.out.println("--Wywolanie konstruktora z parametrami");
    }

    public Item(Item object){
        name_ = object.name_;
        category_ = object.category_;
        country_ = object.country_;
        price_ = object.price_;
        date_ = object.date_;

        countStatic_++;
        //countNonStatic_++;
        //idStatic_++;
        idNonStatic_ = countStatic_;

        System.out.println("--Wywolanie konstruktora kopiujacego");
    }

    public void show(){
        System.out.println("{id - " + idNonStatic_*11111 + ", name - " + name_ + ", category - " + category_ + ", country - " + country_ +
                ", price - " + price_ + ", expiry_date - " + date_ + "}");
        System.out.println("-------------------------------------------------");
    }

    public static int getCount(){
        return countStatic_;
    }
    /*public String toString(){
        String string_item = "{name - " + name_ + ", category - " + category_ + ", country - " + country_ +
                ", price - " + price_ + "}";
        return string_item;
    }*/
}
