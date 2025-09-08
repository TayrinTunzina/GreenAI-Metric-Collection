#include <iostream>
#include <vector>
using namespace std;

void matrixRotation(vector<vector<int>>& matrix, int r) {
    int m = matrix.size(), n = matrix[0].size();
    int layers = min(m, n) / 2;

    for (int layer = 0; layer < layers; ++layer) {
        vector<int> elements;
        for (int i = layer; i < n - layer; ++i) elements.push_back(matrix[layer][i]);
        for (int i = layer + 1; i < m - layer; ++i) elements.push_back(matrix[i][n - layer - 1]);
        for (int i = n - layer - 2; i >= layer; --i) elements.push_back(matrix[m - layer - 1][i]);
        for (int i = m - layer - 2; i > layer; --i) elements.push_back(matrix[i][layer]);

        int rot = r % elements.size();
        vector<int> rotated(elements.begin() + rot, elements.end());
        rotated.insert(rotated.end(), elements.begin(), elements.begin() + rot);

        int idx = 0;
        for (int i = layer; i < n - layer; ++i) matrix[layer][i] = rotated[idx++];
        for (int i = layer + 1; i < m - layer; ++i) matrix[i][n - layer - 1] = rotated[idx++];
        for (int i = n - layer - 2; i >= layer; --i) matrix[m - layer - 1][i] = rotated[idx++];
        for (int i = m - layer - 2; i > layer; --i) matrix[i][layer] = rotated[idx++];
    }

    for (auto& row : matrix) {
        for (int val : row) cout << val << " ";
        cout << endl;
    }
}

int main() {
    int m, n, r;
    cin >> m >> n >> r;
    vector<vector<int>> matrix(m, vector<int>(n));

    for (int i = 0; i < m; ++i)
        for (int j = 0; j < n; ++j)
            cin >> matrix[i][j];

    matrixRotation(matrix, r);
    return 0;
}
