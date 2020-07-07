import java.util.*;
import java.lang.*;
import java.io.*;

class ValidSubstring {
    public static void solve(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = str.length();
        int max = 0;
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    System.out.println("Pushed inside Stack " + i);
                    stack.push(i);
                } else {
                    System.out.println("stack.peek() gives: " + stack.peek());
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t-- > 0 )
        {
            String str = sc.next();
            solve( str );

        }
    }

    }

