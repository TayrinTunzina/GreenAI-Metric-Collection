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

void reversePrint(SinglyLinkedListNode* head) {
    // Base case: if list is empty
    if (head == nullptr) {
        return;
    }
    
    // Recursive approach
    reversePrint(head->next);
    cout << head->data << " ";
}

int main() {
    int t;
    cout << "Enter number of test cases: ";
    cin >> t;
    
    while (t--) {
        int n;
        cout << "Enter number of elements: ";
        cin >> n;
        
        SinglyLinkedListNode* head = nullptr;
        SinglyLinkedListNode* tail = nullptr;
        
        for (int i = 0; i < n; i++) {
            int data;
            cin >> data;
            
            SinglyLinkedListNode* node = new SinglyLinkedListNode(data);
            
            if (head == nullptr) {
                head = node;
            } else {
                tail->next = node;
            }
            tail = node;
        }
        
        reversePrint(head);
        cout << endl;  // New line after each test case
    }
    
    return 0;
}
