import java.util.*;

public class PlayerQueue {
    private Player[] queue;
    private int front;
    private int size;

    public int getSize() {
        return size;
    }
    public PlayerQueue(int capacity){
        queue = new Player[capacity];
        front = 0;
    }
    public void enqueue(Player player){
        if (size == queue.length){
            Player[] largerPlayerQueue = new Player[queue.length * 2];
            System.arraycopy(queue, 0, largerPlayerQueue, 0, queue.length);
            queue = largerPlayerQueue;
        }
        queue[size] = player;
        size++;
    }

    public Player dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Player removePlayer = queue[front];

        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        size--;
        queue[size] = null;
        return removePlayer;
    }
    public Player peek(){
        if (size == 0){
            throw new NoSuchElementException( );
        }
        return queue[front];
    }
    public void printQueue(){
        for(int i = front; i < size; i++){
            System.out.print(queue[i]);
            if (i < size - 1){
                System.out.println(" -> ");
            }
        }

    }

}
