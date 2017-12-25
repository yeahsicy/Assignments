The following exercises refer to this program shell.

 

Public class Palindrome TestWrapper

{

final String isMsg = " IS a palindrome";

final String isNotMsg = " is NOT a palindrome";

 

public static void main( String args[] )

{

New PalindromeTestWrapper( );

}

Public PalindromeTestWrapper( )

{

// your code here

}

Public Boolean isPalindrome( String s){

// your code here

}

}

 

 

A palindrome is a word that reads the same forwards as backwards. The words tot, madam and racecar are palindromes; the words tote and

Racer are not.

 

Complete the PalindromeTestWrapper method so that it reads a string from the user, calls isPalindrome to determine if it is a palindrome and displays an appropriate message. Your program must allow the user to repeatedly enter strings.
 

Complete the isPalindrome method so that it returns true if s is a palindrome and false if it isn’t. You must use a stack in your solution algorithm.  You must use the Java API class util.Stack<E> in your coding.