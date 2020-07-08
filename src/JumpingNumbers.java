import java.util.*;
import java.lang.*;
import java.io.*;

public class JumpingNumbers {

    private static void solve(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print("0 ");
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            if (temp > n) continue;
            System.out.print(temp + " ");
            int leftMost = temp % 10;
            if (leftMost > 0) queue.add(temp * 10 + (leftMost - 1));
            if (leftMost < 9) queue.add(temp * 10 + (leftMost + 1));
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner( System.in );
        int t = sc.nextInt();
        while( t-- > 0 )
        {
            int num = sc.nextInt();
            solve( num );
            System.out.println();
        }
    }
}