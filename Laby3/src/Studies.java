// Oleksandr Nedosiek
// 275978

import java.util.*;
public class Studies {
    public static void main(String[] args){
        String[] imie_nazwisko = {"Anna Nowak", "Piotr Kowalski",
                "Jan Lewandowski", "Marta Wiśniewska", "Grzegorz Zieliński"};
        String[] kierunek = {"Informatyka Techniczna", "Automatyka i Robotyka",
                "Matematyka Stosowana", "Informatyka Techniczna", "Informatyka Stosowana"};
        Boolean[] czy_starosta= {true, false, true, false, false};

        Set<String> lista_kierunkow = new HashSet<String>();
        for (int i=0; i<kierunek.length; i++){
            lista_kierunkow.add(kierunek[i]);
        }

        List<String> lista_studentow = new ArrayList<String>();
        for (int i=0; i<imie_nazwisko.length; i++){
            lista_studentow.add(imie_nazwisko[i]);
        }

        Map<String, String> lista_starostow = new HashMap<String, String>();
        for (int i=0; i<czy_starosta.length; i++){
            if (czy_starosta[i] == true){
                lista_starostow.put(kierunek[i], imie_nazwisko[i]);
            }

        }

        System.out.println("* Kierunki studiow: ");
        kierunki(lista_kierunkow);
        System.out.println("\n* Lista studentow: ");
        studenci(lista_studentow);
        System.out.println("\n* Kierunek - starosta: ");
        starostowie(lista_starostow);

    }

    public static void kierunki(Set<String> lista_kierunkow){
        for(String nazwa_kierunku:lista_kierunkow){
            System.out.println(nazwa_kierunku);
        }
    }

    public static void studenci(List<String> lista_studentow){
        for(String list_students:lista_studentow){
            System.out.println(list_students);
        }
    }

    public static void starostowie(Map<String, String> lista_starostow){
        for (String head:lista_starostow.keySet()){
            System.out.println(head + " - " + lista_starostow.get(head));
        }
    }
}
