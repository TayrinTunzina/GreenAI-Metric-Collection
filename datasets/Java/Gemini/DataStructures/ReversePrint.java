import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversePrint {
    public static void reversePrint(Node head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            Node head = null;
            Node tail = null;

            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();

                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            reversePrint(head);
        }
    }
}
