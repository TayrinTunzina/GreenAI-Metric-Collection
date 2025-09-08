#include <iostream>
using namespace std;

class SinglyLinkedListNode {
public:
    int data;
    SinglyLinkedListNode* next;
    SinglyLinkedListNode(int node_data) {
        this->data = node_data;
        this->next = nullptr;
    }
};

void printLinkedList(SinglyLinkedListNode* head) {
    SinglyLinkedListNode* current = head;
    while (current) {
        cout << current->data << endl;
        current = current->next;
    }
}

SinglyLinkedListNode* createLinkedList(int n) {
    if (n == 0) {
        return nullptr;
    }
    int data;
    cin >> data;
    SinglyLinkedListNode* head = new SinglyLinkedListNode(data);
    SinglyLinkedListNode* current = head;
    for (int i = 1; i < n; ++i) {
        cin >> data;
        SinglyLinkedListNode* new_node = new SinglyLinkedListNode(data);
        current->next = new_node;
        current = new_node;
    }
    return head;
}

int main() {
    int n;
    cout << "Enter the number of nodes in the linked list: ";
    cin >> n;
    SinglyLinkedListNode* head = createLinkedList(n);
    printLinkedList(head);
    return 0;
}
