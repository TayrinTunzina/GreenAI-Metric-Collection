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
        cout << s.top() << " ";
        s.pop();
    }
    cout << endl;
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;
    while (t--) {
        int n;
        cout << "Enter the number of elements in the list: ";
        cin >> n;
        SinglyLinkedListNode* head = nullptr;
        SinglyLinkedListNode* tail = nullptr;
        for (int i = 0; i < n; ++i) {
            int data;
            cout << "Enter the data element: ";
            cin >> data;
            SinglyLinkedListNode* new_node = new SinglyLinkedListNode(data);
            if (head == nullptr) {
                head = new_node;
                tail = new_node;
            } else {
                tail->next = new_node;
                tail = new_node;
            }
        }
        reversePrint(head);
    }
    return 0;
}
