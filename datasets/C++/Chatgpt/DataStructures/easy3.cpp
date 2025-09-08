#include <iostream>
#include <stack>
using namespace std;

struct SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode* next;
    
    SinglyLinkedListNode(int node_data) {
        data = node_data;
        next = nullptr;
    }
};

void reversePrint(SinglyLinkedListNode* head) {
    stack<int> nodeStack;
    
    SinglyLinkedListNode* current = head;
    while (current != nullptr) {
        nodeStack.push(current->data);
        current = current->next;
    }
    
    while (!nodeStack.empty()) {
        cout << nodeStack.top() << endl;
        nodeStack.pop();
    }
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;

    while (t--) {
        int n;
        cout << "\nEnter the number of elements in the list: ";
        cin >> n;
        
        SinglyLinkedListNode* head = nullptr;
        SinglyLinkedListNode* tail = nullptr;
        
        for (int i = 0; i < n; i++) {
            int data;
            cin >> data;
            SinglyLinkedListNode* new_node = new SinglyLinkedListNode(data);
            if (!head) {
                head = new_node;
            } else {
                tail->next = new_node;
            }
            tail = new_node;
        }
        
        cout << "\nReversed list:" << endl;
        reversePrint(head);
    }

    return 0;
}
