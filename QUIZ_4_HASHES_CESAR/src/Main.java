public class Main {
    public static void main (String[] args ){
        Player pikachu = new Player(4, "Pikachu", 1);
        Player bitch = new Player(12, "Bitch", 2);
        Player starmie = new Player(22, "Starmie", 3);
        Player togepi = new Player(15, "Togepi", 4);
        Player mankey = new Player(9, "Mankey", 5);

        SimpleHashTable players = new SimpleHashTable();

        players.put(pikachu.getUsername(), pikachu);
        players.put(bitch.getUsername(), bitch);
        players.put(starmie.getUsername(), starmie);
        players.put(togepi.getUsername(), togepi);
        players.put(mankey.getUsername(), mankey);
        players.remove(mankey.getUsername(), mankey);
        players.printHashTable();

        String key = togepi.getUsername();
        System.out.println("Player at key " + key + " = " + players.get(key));

    }
}
