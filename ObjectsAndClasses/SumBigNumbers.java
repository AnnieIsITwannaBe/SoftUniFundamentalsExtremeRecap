package ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //we need to learn some additional stuff about the bigIntegerClass
        //when we get home
        //used for very big integer operation that are outside the limit of all
        //of the primitive types

        BigInteger a = new BigInteger(scanner.nextLine());
        BigInteger b = new BigInteger(scanner.nextLine());


        BigInteger additionProduct = a.add(b);
        System.out.println(additionProduct);
    }
}
