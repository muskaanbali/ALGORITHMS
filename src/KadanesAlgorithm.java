import java.util.Scanner;

public class KadanesAlgorithm {
    static int max(int a , int b)
    {
        if( a >= b )
            return a;
        else
            return b;
    }
    static int executeKadanesAlgo( int array[], int sizeOfArray )
    {
        int max_so_far = array[0], current_max = array[0];
        for( int i = 1; i < sizeOfArray; i++ )
        {
            current_max = max( array[i], (current_max+array[i]) );
            max_so_far = max (max_so_far, current_max );

        }
        return max_so_far;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        System.out.println("Enter size of array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i< size; i++ )
        {
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Largest possible sum of consecutive subarray is : "+ executeKadanesAlgo(arr, size));

    }
}
