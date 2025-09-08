import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    
    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class  LinkedListTraversal {
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of nodes
        int n = scanner.nextInt();
        
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;
        
        // Create linked list from input
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        
        // Print the linked list
        printLinkedList(head);
        
        scanner.close();
    }
}