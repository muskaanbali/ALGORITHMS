//This is solution to GeeksForGeeks Problem:
// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

/**
 * Conditions to be a CELEBRITY
 * 1) Everyone except celebrity herself/himself should know her/him
 *   i.e indegree of celeb index should be n-1
 * 2) Celebrity shouldn't know anyone
 *   i.e. out degree of celeb index should be 0
 *   Considering the concept of Adjancy Matrix, indegree represents
 *   count of who all know this particular index.
 *   Outdegree represents the count of people this index knows.
 *
 *   We can maintain 2 arrays indegree and outdegree and maintain this data for
 *   every index
 *   Time Complexity for this approach is O(n*n)
 *   Space Complexity is basically the extra arrays that we maintained
 *   so : O(n+n) => O(2n) ~ O(n)
 */


import  java.util.Scanner;

public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        System.out.println("Number of Testcases: ");
        int t = sc.nextInt();
        while( t-- > 0 )
        {
            //size of square matrix
            System.out.println("Enter size of square matrix: ");
            int n = sc.nextInt();
            int m[][] = new int[n][n];
            for( int i=0; i<n; i++ )
            {
                for(int j=0; j<n; j++ )
                {
                    System.out.println("Element: ");
                    m[i][j] = sc.nextInt();
                }
            }
            System.out.println( new Celebrity().getId( m, n ));
        }
    }
}

class Celebrity{
    /**
     * Two pointer approach has been used here: using start and end.
     * start is the initial index i.e. 0 and end is the last index i.e. n-1
     * The idea is that if start knows end, start CAN'T BE A CELEB
     * and if end isn't known by start, it CAN'T BE A CELEB
     * Time Complexity is O(n) and Space Complexity is O(1) as no extra space used
     * @param m square matrix represents who knows whom
     * @param n size of square matrix
     * @return id of celebrity if present otherwise returns -1
     */
    int getId(int m[][], int n)
    {
        // Your code here
        int start = 0 , end = n-1;
        while( start < n && end >=0 )
        {
            if( start == end )
            {
                //start == end => this index can be a celebrity so
                //need to check again in another loop that all should know this index
                // and this index should know no one
                break;
            }
            //whether start knows end
            //i.e whether m[start][end] has value 1
            // 1 means start knows end => start can't be a celeb
            if( m[start][end] == 1 )
            {
                //start knows end => start can't be a celeb
                start++;
            }
            else
            {
                // 0 means start doesn't know end => end can't be a celeb
                if( m[start][end] == 0 )
                {
                    end--;
                }
            }
        }
        //to check whether this end is known to all
        boolean flag = true;
        for( int i=0; i<n; i++ )
        {

            if( i == end )
            {
                //do nothing it should be zero
            }
            else
            {
                if( m[i][end] == 1 )
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
        }
        if( flag == false )
        {
            return -1;
        }
        else
        {
            //check that celeb should know no one
            for(int k=0; k<n; k++)
            {
                if(m[end][k] == 1)
                {
                    flag = false;
                    break;
                }
                else
                    flag = true;
            }
        }
        if( flag == true )
            return end;
        else return -1;

    }
}
