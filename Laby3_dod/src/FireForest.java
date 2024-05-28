import java.util.*;

public class FireForest {

    private String[][] map;
    private int size;
    private double forestation;

    public FireForest(int size, double forestation) {
        this.size = size;
        this.forestation = forestation;
        this.map = new String[size][size];
    }

    public void Map_Initialization() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (rand.nextDouble() < forestation) {
                    map[i][j] = "T";
                } else {
                    map[i][j] = "X";
                }
            }
        }
    }

    public void Fire_Initialization() {
        for (int i = 0; i < size; i++) {
            if (map[0][i].equals("T")) {
                map[0][i] = "B";
            }
        }
    }

    public boolean Spread_Fire() {
        boolean fire_spread = false;
        String[][] new_Map = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                new_Map[i][j] = map[i][j];
                if (map[i][j].equals("T")) {
                    if (i > 0 && map[i - 1][j].equals("B")) {
                        new_Map[i][j] = "B";
                        fire_spread = true;
                    } else if (i < size - 1 && map[i + 1][j].equals("B")) {
                        new_Map[i][j] = "B";
                        fire_spread = true;
                    } else if (j > 0 && map[i][j - 1].equals("B")) {
                        new_Map[i][j] = "B";
                        fire_spread = true;
                    } else if (j < size - 1 && map[i][j + 1].equals("B")) {
                        new_Map[i][j] = "B";
                        fire_spread = true;
                    }
                }
            }
        }
        map = new_Map;
        return fire_spread;
    }

    public double simulate() {
        Map_Initialization();
        Fire_Initialization();

        while (Spread_Fire()) {
        }

        int burnt_Trees = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j].equals("B")) {
                    burnt_Trees++;
                }
            }
        }
        return (double) burnt_Trees/(size * size);
    }

    public static void main(String[] args) {
        int L = 100;
        int k = 10;

        double[] forestationValues = new double[21];
        for (int i = 0; i <= 20; i++) {
            forestationValues[i] = i / 20.0;
        }

        try {
            StringBuilder result = new StringBuilder(); //nie wiem czy można tego użyc, ale znalazłem coś takiego
            result.append("forestation | average_burnt_trees\n");

            for (double forestation : forestationValues) {
                double averageBurntTrees = 0;
                for (int j = 0; j < k; j++) {
                    FireForest simulation = new FireForest(L, forestation);
                    averageBurntTrees += simulation.simulate();
                }
                averageBurntTrees /= k;
                result.append(String.format("%.2f\t%.4f\n", forestation, averageBurntTrees));
            }

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
