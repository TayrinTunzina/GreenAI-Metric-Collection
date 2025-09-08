#include <iostream>
using namespace std;

struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
    SinglyLinkedListNode(int data) : data(data), next(nullptr) {}
};

void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    while (current) {
        cout << current->data << endl;
        current = current->next;
    }
}

int main() {
    int n;
    cout << "Enter the number of elements in the linked list: ";
    cin >> n;

    SinglyLinkedListNode* head = nullptr;
    SinglyLinkedListNode* prev = nullptr;

    for (int i = 0; i < n; i++) {
        int data;
        cout << "Enter the data for the node: ";
        cin >> data;
        SinglyLinkedListNode* node = new SinglyLinkedListNode(data);
        if (head == nullptr) {
            head = node;
        } else {
            prev->next = node;
        }
        prev = node;
    }

    // Output
    printLinkedList(head);

    return 0;
}