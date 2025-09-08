import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    
    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversePrint {
    static void reversePrint(SinglyLinkedListNode head) {
        // Base case: if list is empty
        if (head == null) {
            return;
        }
        
        // Recursive approach
        reversePrint(head.next);
        System.out.print(head.data + " ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();
            
            SinglyLinkedListNode head = null;
            SinglyLinkedListNode tail = null;
            
            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                SinglyLinkedListNode node = new SinglyLinkedListNode(data);
                
                if (head == null) {
                    head = node;
                } else {
                    tail.next = node;
                }
                tail = node;
            }
            
            reversePrint(head);
            System.out.println();  // New line after each test case
        }
        
        scanner.close();
    }
}