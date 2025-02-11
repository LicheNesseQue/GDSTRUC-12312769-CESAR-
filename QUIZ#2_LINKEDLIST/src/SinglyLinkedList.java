public class SinglyLinkedList {


    private static class Node {
        Player data;
        Node next;

        Node(Player data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size; // Counter


    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }


    public void add(Player player) {
        Node newNode = new Node(player);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++; // Update counter
    }

    // Removes first element
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }


    public int size() {
        return size;
    }


    public boolean contains(Player player) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(player)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    public int indexOf(Player player) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(player)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // Displays the list elements
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}


