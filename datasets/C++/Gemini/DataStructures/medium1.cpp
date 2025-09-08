#include <iostream> // Required for input/output operations (cin, cout)
#include <vector>   // Required for using std::vector
#include <string>   // Required for using std::string

// Function to count occurrences of query strings
std::vector<int> matchingStrings(const std::vector<std::string>& stringList, const std::vector<std::string>& queries) {
    std::vector<int> results;
    for (const std::string& query : queries) {
        int count = 0;
        for (const std::string& s : stringList) {
            if (s == query) {
                count++;
            }
        }
        results.push_back(count);
    }
    return results;
}

int main() {
    // --- Input section ---
    int n;
    std::cout << "Enter the number of strings in stringList (n):" << std::endl;
    std::cin >> n;

    std::cout << "Enter " << n << " strings for stringList, one per line:" << std::endl;
    std::vector<std::string> stringList(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> stringList[i];
    }

    int q;
    std::cout << "\nEnter the number of query strings (q):" << std::endl;
    std::cin >> q;

    std::cout << "Enter " << q << " query strings, one per line:" << std::endl;
    std::vector<std::string> queries(q);
    for (int i = 0; i < q; ++i) {
        std::cin >> queries[i];
    }

    // --- Processing and Output section ---
    std::vector<int> results = matchingStrings(stringList, queries);

    std::cout << "\n--- Results ---" << std::endl;
    for (int res : results) {
        std::cout << res << std::endl;
    }

    return 0;
}
