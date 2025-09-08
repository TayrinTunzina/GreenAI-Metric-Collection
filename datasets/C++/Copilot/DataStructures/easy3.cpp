#include <iostream>
#include <stack>
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
    stack<int> s;
    SinglyLinkedListNode* current = head;
    while (current) {
        s.push(current->data);
        current = current->next;
    }
    
    while (!s.empty()) {
        cout << s.top();
        s.pop();
        if (!s.empty()) cout << " ";
    }
    cout << endl;
}

SinglyLinkedListNode* createLinkedList(int n) {
    SinglyLinkedListNode* head = nullptr;
    if (n > 0) {
        int data;
        cin >> data;
        head = new SinglyLinkedListNode(data);
        SinglyLinkedListNode* current = head;
        for (int i = 1; i < n; ++i) {
            cin >> data;
            SinglyLinkedListNode* new_node = new SinglyLinkedListNode(data);
            current->next = new_node;
            current = new_node;
        }
    }
    return head;
}

int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        SinglyLinkedListNode* head = createLinkedList(n);
        if (head) {
            reversePrint(head);
        }
    }
    return 0;
}
