#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>

using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;
    Node(int d) {
        data = d;
        left = NULL;
        right = NULL;
    }
};

Node* buildTree(const vector<int>& nodes, const vector<tuple<int, int, char>>& edges) {
    if (nodes.empty()) return NULL;
    map<int, Node*> nodeMap;
    for (int val : nodes) {
        nodeMap[val] = new Node(val);
    }

    Node* root = nodeMap[nodes[0]];

    for (const auto& edge : edges) {
        int parentVal = get<0>(edge);
        int childVal = get<1>(edge);
        char dir = get<2>(edge);

        if (nodeMap.find(parentVal) != nodeMap.end() && nodeMap.find(childVal) != nodeMap.end()) {
            Node* parent = nodeMap[parentVal];
            Node* child = nodeMap[childVal];
            if (dir == 'L') {
                parent->left = child;
            } else {
                parent->right = child;
            }
        }
    }
    return root;
}

void topView(Node *root) {
    if (root == NULL) return;

    map<int, int> hdMap; // Horizontal distance -> Node data
    queue<pair<Node*, int>> q;
    q.push({root, 0});

    while (!q.empty()) {
        pair<Node*, int> temp = q.front();
        q.pop();
        Node* curr = temp.first;
        int hd = temp.second;

        // If this is the first node we've seen at this horizontal distance, store it.
        if (hdMap.find(hd) == hdMap.end()) {
            hdMap[hd] = curr->data;
        }

        if (curr->left != NULL) {
            q.push({curr->left, hd - 1});
        }
        if (curr->right != NULL) {
            q.push({curr->right, hd + 1});
        }
    }

    for (auto const& pair : hdMap) {
        cout << pair.second << " ";
    }
    cout << endl;
}

int main() {
    int n;
    cin >> n;
    vector<int> nodes(n);
    for (int i = 0; i < n; ++i) {
        cin >> nodes[i];
    }

    int e;
    cin >> e;
    vector<tuple<int, int, char>> edges(e);
    for (int i = 0; i < e; ++i) {
        int parent, child;
        char dir;
        cin >> parent >> child >> dir;
        edges[i] = make_tuple(parent, child, dir);
    }

    Node* root = buildTree(nodes, edges);
    topView(root);

    return 0;
}