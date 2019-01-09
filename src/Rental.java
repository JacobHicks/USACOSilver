import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
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

        for(int i = 0; i < ncows; i++) {
            cows[i] = in.nextInt();
        }
        for(int i = 0; i < milkorders; i++) {
            milk[i] = new Order(in.nextInt(), in.nextInt());
        }
        for(int i = 0; i < coworders; i++) {
            coworder[i] = in.nextInt();
        }

        Arrays.sort(cows);
        Arrays.sort(milk);
        Arrays.sort(coworder);

        int res = 0;
        int milkindex = 0;
        for(int i = 0; i < ncows - (milkorders-coworders); i++) { ////////////////////////
            res += Math.min(milk[milkindex].maxmilk, cows[i]) * milk[milkindex].price;
            cows[i] -= Math.min(milk[milkindex].maxmilk, cows[i]);
            milk[milkindex].maxmilk -= Math.min(milk[milkindex].maxmilk, cows[i]);
            if(milk[milkindex].maxmilk==0) {
                milkindex++;
            }
            if(cows[i]>0) i--;
        }
        int cowindex = Math.max(0, ncows - coworders);
        for(int i = ncows - coworders; i < ncows; i++) {
            int milkvalue = 0;
            int milki = 0;
            int currmilk = 0;
            for(milki = milkindex; cows[i] > 0 && milki < milk.length; milki++) {
                milkvalue += Math.min(milk[milki].maxmilk, cows[i]) * milk[milki].price;
                currmilk = milk[milki].maxmilk - Math.min(milk[milki].maxmilk, cows[i]);
                cows[i] -= Math.min(milk[milki].maxmilk, cows[i]);
            }
            if(cowindex >= coworders || milkvalue >= coworder[cowindex]) {
                milk[milki-1].maxmilk = currmilk;
                res += milkvalue;
                milkindex = milki;
            }
            else if(cowindex < coworders){
                res += coworder[cowindex];
            }
            cowindex++;
        }
        out.println(res);
        out.close();
    }
}

class Order implements Comparable<Order> {
    int price;
    int maxmilk;
    Order(int m, int p) {
        price = p;
        maxmilk = m;
    }

    public int compareTo(Order o) {
        return o.price - price;
    }
}