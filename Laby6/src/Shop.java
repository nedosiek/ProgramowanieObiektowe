import java.util.ArrayList;

public class Shop {
    public static void main(String[] args) {
        // zwykle zmienne
        Item item_blad = new Item();
        //System.out.println(item_blad);
        item_blad.show();

        Item item_grape = new Item("Winogrono", Item.Category.Fruits, "Francja", 50, 12, 07, 2060);
        //System.out.println(item_grape);
        item_grape.show();

        Item item_grape_vine = new Item(item_grape);
        //System.out.println(item_grape_vine);
        item_grape_vine.show();
        System.out.println();


        // tablica
        Item []tab = new Item[3];
        tab[0] = new Item();
        tab[1] = new Item("Coca Cola", Item.Category.Drink, "Stany Zjednoczone", 5, 15, 05, 2026);
        tab[2] = new Item(tab[1]);
        for(int i=0; i<tab.length; i++){
            tab[i].show();
        }
        System.out.println();


        // kolekcja
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item());
        list.add(new Item("Kurczak", Item.Category.Meat, "Polska", 25, 17, 04, 2024));
        list.add(new Item(list.get(1)));
        for (Item lista:list){
            lista.show();
        }
        System.out.println();

        System.out.println("Liczba stworzonych obiektow wynosi " + Item.getCount());
    }
}