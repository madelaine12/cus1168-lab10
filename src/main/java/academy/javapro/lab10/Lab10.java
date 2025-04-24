package academy.javapro.lab10;

public class Lab10 {

    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) return 1;

        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    public static int countEars(int n) {
        // Base case: no rabbits means no ears
        if (n == 0) return 0;

        // Recursive case: 2 ears for this rabbit + ears for the rest
        return 2 + countEars(n - 1);
    }

    public static int fibonacci(int n) {
        // Base cases: first two numbers in the sequence
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive case: sum of the previous two numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int specialEars(int n) {
        // Base case: no rabbits means no ears
        if (n == 0) return 0;

        // Recursive case with pattern: odd rabbits (2 ears), even rabbits (3 ears)
        if (n % 2 == 0) return 3 + specialEars(n - 1);
        else return 2 + specialEars(n - 1);
    }

    public static int triangleBlocks(int n) {
        // Base case: no rows means no blocks
        if (n == 0) return 0;

        // Recursive case: blocks in this row + blocks in the rows above
        return n + triangleBlocks(n - 1);
    }

    public static int sumDigits(int n) {
        // Base case: single digit number
        if (n < 10) return n;

        // Recursive case: rightmost digit + sum of the rest
        return (n % 10) + sumDigits(n / 10);
    }

    public static int countSevens(int n) {
        // Base case: no more digits
        if (n == 0) return 0;

        // Check if rightmost digit is 7
        if (n % 10 == 7) return 1 + countSevens(n / 10);

        // Otherwise, check the rest
        return countSevens(n / 10);
    }

    public static int countEights(int n) {
        // Base case: no more digits
        if (n == 0) return 0;

        // Get the rightmost and second-rightmost digits
        int right = n % 10;
        int second = (n / 10) % 10;

        // Check special case: 8 preceded by another 8
        if (right == 8 && second == 8) return 2 + countEights(n / 10);

        // Normal case: just a regular 8
        if (right == 8) return 1 + countEights(n / 10);

        // No 8 in the rightmost position
        return countEights(n / 10);
    }

    public static int countHi(String str) {
        // Base case: string too short to contain "hi"
        if (str.length() < 2) return 0;

        // Check if the first two characters are "hi"
        if (str.startsWith("hi")) return 1 + countHi(str.substring(2));

        // Check the next character
        return countHi(str.substring(1));
    }

    public static String replaceChar(String str) {
        // Base case: empty string
        if (str.length() == 0) return "";

        // Replace 'x' with 'y' if first character is 'x'
        if (str.charAt(0) == 'x') return "y" + replaceChar(str.substring(1));

        // Otherwise, keep current character
        return str.charAt(0) + replaceChar(str.substring(1));
    }

    public static String removeChar(String str) {
        // Base case: empty string
        if (str.length() == 0) return "";

        // Skip 'x' characters
        if (str.charAt(0) == 'x') return removeChar(str.substring(1));

        // Keep character and process rest
        return str.charAt(0) + removeChar(str.substring(1));
    }

    public static String markPairs(String str) {
        // Base case: single character or empty string
        if (str.length() <= 1) return str;

        // Check if first and second characters are identical
        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + markPairs(str.substring(1));

        // Otherwise, move forward
        return str.charAt(0) + markPairs(str.substring(1));
    }

    public static String deduplicate(String str) {
        // Base case: empty or one-character string
        if (str.length() == 0) return "";
        if (str.length() == 1) return str;

        // Remove duplicate adjacent characters
        if (str.charAt(0) == str.charAt(1)) return deduplicate(str.substring(1));

        // Keep character and process rest
        return str.charAt(0) + deduplicate(str.substring(1));
    }

    public static int countHiSpecial(String str) {
        // Base case: string too short to contain "hi"
        if (str.length() < 2) return 0;

        // Check for "hi" at the beginning
        if (str.startsWith("hi")) return 1 + countHiSpecial(str.substring(2));

        // Check for "xhi" pattern (need to check if we have enough characters)
        if (str.length() >= 3 && str.charAt(0) == 'x' && str.startsWith("hi", 1)) return countHiSpecial(str.substring(3));

        // Check next character
        return countHiSpecial(str.substring(1));
    }

    public static int substringLength(String str, String sub) {
        // Base case: string is shorter than the substring
        if (str.length() < sub.length()) return 0;

        // Check if string starts and ends with the substring
        boolean startsWith = str.startsWith(sub);
        boolean endsWith = str.endsWith(sub);
        if (startsWith && endsWith) return str.length();

        // Try removing first character
        int removeFirst = substringLength(str.substring(1), sub);

        // Try removing last character
        int removeLast = substringLength(str.substring(0, str.length() - 1), sub);

        // Return the larger result
        return Math.max(removeFirst, removeLast);
    }

    public static void towerOfHanoi(int n, char source, char auxiliary, char target) {
        // Base case: only one disk to move
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }

        // Move n-1 disks from source to auxiliary using target as temporary
        towerOfHanoi(n - 1, source, target, auxiliary);

        // Move the nth disk from source to target
        System.out.println("Move disk " + n + " from " + source + " to " + target);

        // Move n-1 disks from auxiliary to target using source as temporary
        towerOfHanoi(n - 1, auxiliary, source, target);
    }

    public static void main(String[] args) {
        // Test factorial
        System.out.println("Testing factorial:");
        System.out.println(factorial(1));  // 1
        System.out.println(factorial(2));  // 2
        System.out.println(factorial(3));  // 6

        // Test countEars
        System.out.println("\nTesting countEars:");
        System.out.println(countEars(0));  // 0
        System.out.println(countEars(1));  // 2
        System.out.println(countEars(2));  // 4

        // Test fibonacci
        System.out.println("\nTesting fibonacci:");
        System.out.println(fibonacci(0));  // 0
        System.out.println(fibonacci(1));  // 1
        System.out.println(fibonacci(2));  // 1
        System.out.println(fibonacci(3));  // 2
        System.out.println(fibonacci(4));  // 3
        System.out.println(fibonacci(5));  // 5

        // Test specialEars
        System.out.println("\nTesting specialEars:");
        System.out.println(specialEars(0));  // 0
        System.out.println(specialEars(1));  // 2
        System.out.println(specialEars(2));  // 5
        System.out.println(specialEars(3));  // 7

        // Test triangleBlocks
        System.out.println("\nTesting triangleBlocks:");
        System.out.println(triangleBlocks(0));  // 0
        System.out.println(triangleBlocks(1));  // 1
        System.out.println(triangleBlocks(2));  // 3
        System.out.println(triangleBlocks(3));  // 6

        // Test sumDigits
        System.out.println("\nTesting sumDigits:");
        System.out.println(sumDigits(126));  // 9 (1+2+6)
        System.out.println(sumDigits(49));   // 13 (4+9)
        System.out.println(sumDigits(12));   // 3 (1+2)

        // Test countSevens
        System.out.println("\nTesting countSevens:");
        System.out.println(countSevens(717));  // 2
        System.out.println(countSevens(7));    // 1
        System.out.println(countSevens(123));  // 0

        // Test countEights
        System.out.println("\nTesting countEights:");
        System.out.println(countEights(8));     // 1
        System.out.println(countEights(818));   // 2
        System.out.println(countEights(8818));  // 4 (second 8 counts double)

        // Test countHi
        System.out.println("\nTesting countHi:");
        System.out.println(countHi("xxhixx"));   // 1
        System.out.println(countHi("xhixhix"));  // 2
        System.out.println(countHi("hi"));       // 1

        // Test replaceChar
        System.out.println("\nTesting replaceChar:");
        System.out.println(replaceChar("codex"));   // "codey"
        System.out.println(replaceChar("xxhixx"));  // "yyhiyy"
        System.out.println(replaceChar("xhixhix")); // "yhiyhiy"

        // Test removeChar
        System.out.println("\nTesting removeChar:");
        System.out.println(removeChar("xaxb"));  // "ab"
        System.out.println(removeChar("abc"));   // "abc"
        System.out.println(removeChar("xx"));    // ""

        // Test markPairs
        System.out.println("\nTesting markPairs:");
        System.out.println(markPairs("hello"));  // "hel*lo"
        System.out.println(markPairs("xxyy"));   // "x*xy*y"
        System.out.println(markPairs("aaaa"));   // "a*a*a*a"
        System.out.println();

        // Test deduplicate
        System.out.println("\nTesting deduplicate:");
        System.out.println(deduplicate("yyzzza"));  // "yza"
        System.out.println(deduplicate("abbbcdd")); // "abcd"
        System.out.println(deduplicate("Hello"));   // "Helo"

        // Test countHiSpecial
        System.out.println("\nTesting countHiSpecial:");
        System.out.println(countHiSpecial("ahixhi"));  // 1
        System.out.println(countHiSpecial("ahibhi"));  // 2
        System.out.println(countHiSpecial("xhixhi"));  // 0

        // Test substringLength
        System.out.println("\nTesting substringLength:");
        System.out.println(substringLength("catcowcat", "cat"));     // 9
        System.out.println(substringLength("catcowcat", "cow"));     // 3
        System.out.println(substringLength("cccatcowcatxx", "cat")); // 9

        // Test Tower of Hanoi
        System.out.println("\nTesting Tower of Hanoi (3 disks):");
        towerOfHanoi(3, 'A', 'B', 'C');
    }
}


