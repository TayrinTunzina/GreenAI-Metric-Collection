#include <iostream>
using namespace std;

struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
    
    // Constructor for convenience
    SinglyLinkedListNode(int node_data) {
        data = node_data;
        next = nullptr;
    }
};

void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    while (current != nullptr) {
        cout << current->data << endl;
        current = current->next;
    }
}

int main() {
    int n;
    cin >> n;
    
    SinglyLinkedListNode* head = nullptr;
    SinglyLinkedListNode* tail = nullptr;
    
    // Create linked list from input
    for (int i = 0; i < n; i++) {
        int data;
        cin >> data;
        
        SinglyLinkedListNode* node = new SinglyLinkedListNode(data);
        
        if (head == nullptr) {
            head = node;
            tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }
    
    // Print the linked list
    printLinkedList(head);
    
    // Clean up memory
    while (head != nullptr) {
        SinglyLinkedListNode* temp = head;
        head = head->next;
        delete temp;
    }
    
    return 0;
}