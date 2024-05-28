import java.util.*;
public class Tour {
    public static void main(String[] args){
        Map<String, String> countries_capitals = new HashMap<String, String>();
        countries_capitals.put("Poland", "Warsaw");
        countries_capitals.put("Germany", "Berlin");
        countries_capitals.put("France", "Paris");
        countries_capitals.put("Belgium", "Brussels");
        countries_capitals.put("Austria", "Vienna");

        List<String> cities = new ArrayList<String>();
        cities.add("Paris");
        cities.add("Manchester");
        cities.add("Milan");
        cities.add("Vienna");
        cities.add("Valencia");
        cities.add("Milan");

        Set<String> unique_cities = new HashSet<String>();
        unique_cities.add("Rome");
        unique_cities.add("Milan");
        unique_cities.add("Venice");
        unique_cities.add("Rome");
        unique_cities.add("Naples");

        print_countries_capitals(countries_capitals);
        System.out.println();
        print_cities(cities);
        System.out.println();
        print_unique_cities(unique_cities);
    }

    public static void print_countries_capitals(Map<String, String> countries_capitals){
        for (String country:countries_capitals.keySet()){
            System.out.println(country + " " + countries_capitals.get(country));
        }
        System.out.println("Czy kolekcja zawiera Szwecje: " + countries_capitals.containsKey("Sweden"));
        System.out.println("Kolekcja ma " + countries_capitals.size() + " elementow");
    }

    public static void print_cities(List<String> cities){
        for (String city:cities){
            System.out.println(city);
        }
        System.out.println("Czy kolekcja zawiera Paryz: " + cities.contains("Paris"));
        System.out.println("Kolekcja ma " + cities.size() + " elementow");

    }

    public static void print_unique_cities(Set<String> unique_cities){
        for(String unique:unique_cities){
            System.out.println(unique);
        }
        System.out.println("Czy kolekcja zawiera Rzym: " + unique_cities.contains("Rome"));
        System.out.println("Kolekcja ma " + unique_cities.size() + " elementow");
    }
}