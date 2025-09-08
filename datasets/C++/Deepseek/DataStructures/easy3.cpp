#include <iostream>
using namespace std;

struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
    SinglyLinkedListNode(int data) : data(data), next(nullptr) {}
};

void reversePrint(SinglyLinkedListNode* head) {
    if (head == nullptr) {
        return;
    }
    // Recursively print the rest of the list
    reversePrint(head->next);
    // Print the current node's data
    cout << head->data << endl;
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;

    for (int i = 0; i < t; i++) {
        int n;
        cout << "Enter the number of elements in the list: ";
        cin >> n;

        SinglyLinkedListNode* head = nullptr;
        SinglyLinkedListNode* prev = nullptr;

        for (int j = 0; j < n; j++) {
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
        reversePrint(head);
    }

    return 0;
}