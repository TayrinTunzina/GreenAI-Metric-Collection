#include <iostream>
#include <vector>
#include <unordered_map>
#include <climits>
using namespace std;

unordered_map<int, int> cache;

vector<pair<int, int>> get_factors(int n) {
    vector<pair<int, int>> factors;
    for(int i = 2; i * i <= n; i++) {
        if(n % i == 0) {
            factors.push_back({i, n/i});
        }
    }
    return factors;
}

int min_moves(int n) {
    if(cache.find(n) != cache.end())
        return cache[n];
        
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;
        
    int min_steps = n;
    
    // Try factorization
    vector<pair<int, int>> factors = get_factors(n);
    for(auto factor : factors) {
        min_steps = min(min_steps, 1 + min_moves(max(factor.first, factor.second)));
    }
    
    // Try decrementing by 1
    min_steps = min(min_steps, 1 + min_moves(n - 1));
    
    cache[n] = min_steps;
    return min_steps;
}

int main() {
    int Q;
    cin >> Q;
    
    while(Q--) {
        int N;
        cin >> N;
        cout << min_moves(N) << endl;
    }
    
    return 0;
}