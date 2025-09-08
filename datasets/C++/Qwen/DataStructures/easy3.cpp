#include <iostream>
using namespace std;

// Definition for singly-linked list node
struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
    SinglyLinkedListNode(int val) : data(val), next(nullptr) {}
};

// Function to print the reversed linked list
void reversePrint(SinglyLinkedListNode* head) {
    if (head == nullptr) {
        return;
    }
    reversePrint(head->next);
    cout << head->data << " ";
}

int main() {
    int t;
    cout << "Enter number of test cases: ";
    cin >> t;
    while (t--) {
        int n;
        cout << "Enter number of elements in the list: ";
        cin >> n;
        SinglyLinkedListNode* head = nullptr;
        if (n > 0) {
            int data;
            cin >> data;
            head = new SinglyLinkedListNode(data);
            SinglyLinkedListNode* current = head;
            for (int i = 1; i < n; ++i) {
                cin >> data;
                current->next = new SinglyLinkedListNode(data);
                current = current->next;
            }
        }
        // Call reversePrint
        reversePrint(head);
        cout << endl;
    }
    return 0;
}