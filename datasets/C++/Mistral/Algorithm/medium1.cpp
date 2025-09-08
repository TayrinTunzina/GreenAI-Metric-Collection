#include <iostream>
#include <vector>
#include <algorithm>

// Function to multiply two large numbers represented as strings
std::string multiply(std::string num1, std::string num2) {
    if (num1 == "0" || num2 == "0") return "0";

    std::vector<int> result(num1.size() + num2.size(), 0);

    int i_n1 = 0;
    int i_n2 = 0;

    for (int i = num1.size() - 1; i >= 0; --i) {
        int carry = 0;
        int n1 = num1[i] - '0';

        i_n2 = 0;

        for (int j = num2.size() - 1; j >= 0; --j) {
            int n2 = num2[j] - '0';
            int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
            carry = sum / 10;
            result[i_n1 + i_n2] = sum % 10;
            ++i_n2;
        }

        if (carry > 0)
            result[i_n1 + i_n2] += carry;

        ++i_n1;
    }

    int i = result.size() - 1;
    while (i >= 0 && result[i] == 0)
        --i;

    if (i == -1) return "0";

    std::string s = "";

    while (i >= 0)
        s += std::to_string(result[i--]);

    return s;
}

// Function to calculate factorial
std::string extraLongFactorials(int n) {
    std::string result = "1";
    for (int i = 2; i <= n; ++i) {
        result = multiply(result, std::to_string(i));
    }
    return result;
}

int main() {
    int n;
    std::cout << "Enter an integer: ";
    std::cin >> n;
    std::string result = extraLongFactorials(n);
    std::cout << result << std::endl;
    return 0;
}
