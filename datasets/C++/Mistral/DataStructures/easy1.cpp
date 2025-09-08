#include <iostream>

struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
    SinglyLinkedListNode(int value) : data(value), next(nullptr) {}
};

void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    while (current != nullptr) {
        std::cout << current->data << std::endl;
        current = current->next;
    }
}

int main() {
    int n;
    std::cout << "Enter the number of nodes: ";
    std::cin >> n;

    if (n <= 0) {
        std::cout << "Number of nodes must be positive." << std::endl;
        return 1;
    }

    SinglyLinkedListNode* head = nullptr;
    SinglyLinkedListNode* tail = nullptr;

    for (int i = 0; i < n; ++i) {
        int value;
        std::cout << "Enter the value for node " << i + 1 << ": ";
        std::cin >> value;

        SinglyLinkedListNode* newNode = new SinglyLinkedListNode(value);

        if (head == nullptr) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    printLinkedList(head);

    // Clean up
    SinglyLinkedListNode* current = head;
    while (current != nullptr) {
        SinglyLinkedListNode* next = current->next;
        delete current;
        current = next;
    }

    return 0;
}
