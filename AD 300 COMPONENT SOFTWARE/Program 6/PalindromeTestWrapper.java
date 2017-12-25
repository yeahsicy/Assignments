package PalindromeTestWrapper;

import java.util.*;

public class PalindromeTestWrapper {

    final String isMsg = " IS a palindrome";
    final String isNotMsg = " is NOT a palindrome";


    public static void main(String args[]) {
        new PalindromeTestWrapper();
    }

    public PalindromeTestWrapper() {
        while (1 == 1) {
            System.out.println("Please enter a string ");
            Scanner scanner = new Scanner(System.in);
            String showStr = isPalindrome(scanner.next()) ? isMsg : isNotMsg;
            System.out.println(showStr);
        }
    }

    public Boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length() / 2; i++)
            characterStack.push(s.charAt(i));
        int mid = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        while (mid < s.length()) {
            if (s.charAt(mid) != characterStack.pop())
                return false;
            mid++;
        }
        return true;
    }
}
