import java.util.*;
public class SimpleHashTable {

    private Player[] hashTable;

    public SimpleHashTable(){
        hashTable = new Player[10];
    }
    public int hashKey(String key){
        return key.length() % hashTable.length;
    }
    public boolean isOccupied(int index){
        return hashTable[index] != null;
    }
    public Player get(String key){
        int index = hashKey(key);
        return hashTable[index];
    }

    public void put(String key, Player player){
        int index = hashKey(key);
        if (isOccupied(index)){
            int stoppingIndex = index;

            if( index == hashTable.length - 1)
            {
                index = 0;
            } else {
                index++;
            }

            while(index != stoppingIndex && isOccupied(index)){
                index = (index + 1) % hashTable.length;
            }
        }
        hashTable[index] = player;
    }

    public Player remove(String key, Player player) {
        int index = hashKey(key);
        Player removedPlayer = hashTable[index];
        hashTable[index] = null;

        int nextIndex = (index + 1) % hashTable.length;
        while (hashTable[nextIndex] != null) {
            Player playerRehashed = hashTable[nextIndex];
            hashTable[nextIndex] = null;
            put(playerRehashed.getUsername(), playerRehashed);
            nextIndex = (nextIndex + 1) % hashTable.length;
        }

        return removedPlayer;
    }


    public void printHashTable(){
        for(int i = 0; i <hashTable.length; i++){
            if(isOccupied(i)){
                System.out.println(i + " - " + hashTable[i]);

            } else{
                System.out.println(i + " -  NULL");
            }
        }
    }
}
