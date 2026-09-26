import java.util.*;

public class SortingComparator {
    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " " + score;
        }
    }

    static class Checker implements Comparator<Player> {
        @Override
        public int compare(Player a, Player b) {
            if (a.score != b.score) {
                return Integer.compare(b.score, a.score); // descending score
            }
            return a.name.compareTo(b.name); // ascending name
        }
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("amy", 100),
            new Player("david", 100),
            new Player("heraldo", 50),
            new Player("aakansha", 75)
        };

        Arrays.sort(players, new Checker());

        for (Player p : players) {
            System.out.println(p);
        }
    }
}
