package ObjectsAndClasses;

import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        //how to calculate the factorial of sth
        long factorial = 1;
        //it needs to be 1 because factorial of 0 and one are both equal to 1
        //it needs to be long to cover wider range of results
        //since it can become a really, big number

        factorial = getFactorial(n, factorial);
        System.out.println(factorial);
    }
    //this is simply the iterative approach to the equation
    //there are more
    //explore the recursive approach

    private static long getFactorial(int n, long factorial) {
        factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
