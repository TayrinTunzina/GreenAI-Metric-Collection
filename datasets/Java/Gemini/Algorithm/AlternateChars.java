import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class AlternateChars {

    /**
     * Calculates the length of the longest possible string of two alternating characters.
     *
     * @param s The input string.
     * @return The length of the longest alternating string, or 0 if none can be formed.
     */
    public static int alternate(String s) {
        // Get a list of unique characters from the string using a stream
        List<Character> uniqueChars = s.chars()
                                       .mapToObj(c -> (char) c)
                                       .distinct()
                                       .collect(Collectors.toList());

        if (uniqueChars.size() < 2) {
            return 0;
        }

        int maxLen = 0;

        // Generate all unique pairs of characters
        for (int i = 0; i < uniqueChars.size(); i++) {
            for (int j = i + 1; j < uniqueChars.size(); j++) {
                char c1 = uniqueChars.get(i);
                char c2 = uniqueChars.get(j);

                // Use StringBuilder to efficiently build the temporary string
                StringBuilder tempSb = new StringBuilder();
                for (char ch : s.toCharArray()) {
                    if (ch == c1 || ch == c2) {
                        tempSb.append(ch);
                    }
                }
                String tempS = tempSb.toString();

                boolean isValid = true;
                // Check if the sequence is alternating
                for (int k = 0; k < tempS.length() - 1; k++) {
                    if (tempS.charAt(k) == tempS.charAt(k + 1)) {
                        isValid = false;
                        break;
                    }
                }
                
                // If the sequence is valid, update the maximum length
                if (isValid) {
                    maxLen = Math.max(maxLen, tempS.length());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the length of the string (per input format)
        int l = Integer.parseInt(bufferedReader.readLine().trim());
        // Read the string itself
        String s = bufferedReader.readLine();

        int result = alternate(s);

        System.out.println(result);
        
        bufferedReader.close();
    }
}