#include <iostream>
using namespace std;

// Define the structure of a singly linked list node
struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;

    // Constructor to create a new node
    SinglyLinkedListNode(int node_data) {
        this->data = node_data;
        this->next = nullptr;
    }
};

// Function to print the linked list
void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    while (current != nullptr) {
        cout << current->data << endl;
        current = current->next;
    }
}

int main() {
    int n;
    cout << "Enter the number of elements in the linked list: ";
    cin >> n;

    SinglyLinkedListNode* head = nullptr;
    SinglyLinkedListNode* tail = nullptr;

    cout << "Enter the elements of the linked list:" << endl;
    for (int i = 0; i < n; i++) {
        int data;
        cin >> data;
        SinglyLinkedListNode* newNode = new SinglyLinkedListNode(data);

        if (head == nullptr) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    // Call the function to print the linked list
    printLinkedList(head);

    return 0;
}
