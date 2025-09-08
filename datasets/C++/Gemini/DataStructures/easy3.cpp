#include <iostream>

using namespace std;

struct Node {
    int data;
    Node* next;

    Node(int val) {
        data = val;
        next = nullptr;
    }
};

void reversePrint(Node* head) {
    if (head == nullptr) {
        return;
    }

    reversePrint(head->next);
    cout << head->data << endl;
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        Node* head = nullptr;
        Node* tail = nullptr;

        for (int i = 0; i < n; i++) {
            int data;
            cin >> data;

            Node* newNode = new Node(data);
            if (head == nullptr) {
                head = newNode;
                tail = newNode;
            } else {
                tail->next = newNode;
                tail = newNode;
            }
        }

        reversePrint(head);
    }

    return 0;
}
