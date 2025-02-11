public class Main {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        Player p1 = new Player(1, "SIR G THE GOAT", 10);
        Player p2 = new Player(2, "ROAN THE IMPALER", 69);
        Player p3 = new Player(3, "DOCb", 90);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        System.out.println("OG List: ");
        list.printList();

        //all ops
        System.out.println("List size: " + list.size());
        System.out.println("Is " + p2.getName() + " here? " + list.contains(p2));
        System.out.println("The (Certain Magical) Index of " + p3.getName()  + ": " + list.indexOf(p3));

        list.removeFirst();
        System.out.println("After removing first element:");
        list.printList();
        System.out.println("Updated size: " + list.size());

//Natamad na po ako for doubly linked list mb mb
    }
}