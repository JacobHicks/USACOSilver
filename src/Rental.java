import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rental {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("rental.in"));
        PrintWriter out = new PrintWriter(new File("rental.out"));

        int ncows = in.nextInt();
        int milkorders = in.nextInt();
        int coworders = in.nextInt();

        int[] cows = new int[ncows];
        Order[] milk = new Order[milkorders];
        int[] coworder = new int[coworders];

    }

}

class Order implements Comparable<Order> {
    int price;
    int maxmilk;
    Order(int p, int m) {
        price = p;
        maxmilk = m;
    }
}