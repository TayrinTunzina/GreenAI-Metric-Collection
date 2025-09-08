#include <iostream>

void solve() {
    int n;
    std::cin >> n;
    int xor_sum = 0;
    for (int i = 0; i < n; ++i) {
        long long m;
        int k;
        std::cin >> m >> k;
        
        int grundy_num = 0;
        if (m % 2 != 0) { // m is odd
            grundy_num = 1;
        } else { // m is even
            grundy_num = 2;
        }
        
        xor_sum ^= grundy_num;
    }
    
    if (xor_sum != 0) {
        std::cout << "BOB" << std::endl;
    } else {
        std::cout << "BEN" << std::endl;
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    int g;
    std::cin >> g;
    while (g--) {
        solve();
    }
    return 0;
}