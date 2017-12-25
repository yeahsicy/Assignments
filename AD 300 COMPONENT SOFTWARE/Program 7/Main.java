package solution;

public class Main {

    static singlyLinkedNode head = new singlyLinkedNode();

    public static void main(String[] args) {
        Create(10);
        printOut("Before: ");
        ReverseSinglyLinkedList();
        printOut("After: ");
    }

    static void Create(int n) {
        singlyLinkedNode temp = head;
        for (int i = 0; i < n; i++) {
            temp.value = i;
            if (i == n - 1) break;
            temp.next = new singlyLinkedNode();
            temp = temp.next;
        }
    }

    static void ReverseSinglyLinkedList() {
        singlyLinkedNode pre = null;
        singlyLinkedNode post;
        while (head != null) {
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        head = pre;
    }

    static void printOut(String notes) {
        System.out.println(notes);
        String string = "";
        singlyLinkedNode temp = head;
        while (temp != null) {
            string += temp.value + " ";
            temp = temp.next;
        }

        System.out.println(string);
    }
}
