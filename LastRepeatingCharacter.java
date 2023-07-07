import java.util.HashMap;
import java.util.Map;

public class LastRepeatingCharacter {
    public static void main(String[] args) {
        String input = "Hello World";
        char lastRepeatingChar = findLastRepeatingChar(input);
        
        if (lastRepeatingChar != '\0') {
            System.out.println("Last repeating character: " + lastRepeatingChar);
        } else {
            System.out.println("No repeating character found.");
        }
    }
    
    public static char findLastRepeatingChar(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        char[] chars = input.toCharArray();
        
        for (int i = chars.length - 1; i >= 0; i--) {
            char currentChar = chars[i];
            int count = charCount.getOrDefault(currentChar, 0);
            charCount.put(currentChar, count + 1);
            
            if (count == 1) {
                return currentChar;
            }
        }
        
        return '\0';
    }
}
