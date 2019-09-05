import java.util.Arrays;
import java.util.Scanner;

public class sorter {

    public static int count = 0;

    public static int factorial(int n) {
        int product = 1;
        for (int i = n; i > 0; i--) {
            product *= i;
        }
        return product;
    }

    public static int[] generate(int n)
    {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Source: https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
    public static void algo(int n, int[] arr)
    {
        if (n == 1) {
            count++;
            System.out.println(Arrays.toString(arr)); }
        else
        {
            // recursive call [outer]
            algo(n-1, arr);

            for (int i = 0; i < n-1; i ++)
            {
                if (n % 2 == 0) {
                    int x = arr[i];
                    arr[i] = arr[n-1];
                    arr[n-1] = x;
                } else {
                    int x = arr[0];
                    arr[0] = arr[n-1];
                    arr[n-1] = x;
                }

                // recursive call [inner]
                algo(n-1, arr);
            }
        }
    }

    public static void main(String[] args)
    {
        // default n value
        int n = 3;

        // Scanner for user input
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter value of 'n'.");
        String input = myObj.nextLine();

        // Try to convert string to int. Handle error...
        try { n = Integer.parseInt(input); }
        catch (Exception ex)
        {
            System.out.println("You need to enter a number...");
            return;
        }

        // Start timing
        long startTime = System.currentTimeMillis();

        // generate array
        int[] arr = generate(n);

        // Run the algorithm
        algo(arr.length, arr);

        // stop timing
        long endTime = System.currentTimeMillis();

        System.out.println("Total permutations = " + count);
        System.out.println("Expected permutations = " + factorial(n));
        System.out.println("Total time (milliseconds): " + (endTime-startTime));
    }

    // run times (in milliseconds)

    // n, runtime
    // 1,1
    // 2,1
    // 3,1
    // 4,2
    // 5,4
    // 6,36
    // 7, 179
    // 8, 1181
    // 9, 5688
    // 10, 40695
    // 11, 388463
    // 12,
}
