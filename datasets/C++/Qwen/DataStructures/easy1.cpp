#include <iostream>
using namespace std;

// Definition of a singly linked list node
struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
};

// Function to print the linked list
void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    while (current != nullptr) {
        cout << current->data << endl;  // Print the data of the current node
        current = current->next;       // Move to the next node
    }
}

int main() {
    int n;
    cout << "Enter the number of elements in the linked list: ";
    cin >> n;

    SinglyLinkedListNode* head = nullptr;

    if (n > 0) {
        // Create the head node
        int head_data;
        cout << "Enter the data for the first node: ";
        cin >> head_data;
        head = new SinglyLinkedListNode{head_data, nullptr};
        SinglyLinkedListNode* current = head;

        // Add remaining nodes
        for (int i = 1; i < n; ++i) {
            int data;
            cout << "Enter the data for the next node: ";
            cin >> data;
            SinglyLinkedListNode* new_node = new SinglyLinkedListNode{data, nullptr};
            current->next = new_node;
            current = new_node;
        }
    }

    // Call the function to print the linked list
    printLinkedList(head);

    return 0;
}