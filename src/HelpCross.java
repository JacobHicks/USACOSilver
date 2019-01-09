import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HelpCross {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("helpcross.in"));
        PrintWriter out = new PrintWriter("helpcross.out");

        int nchickens = in.nextInt();
        int ncows = in.nextInt();

        int[] chickens = new int[nchickens];
        Cow[] cows = new Cow[ncows];

        for(int i = 0; i < nchickens; i++) {
            chickens[i] = in.nextInt();
        }

        for(int i = 0; i < ncows; i++) {
            cows[i] = new Cow(in.nextInt(), in.nextInt());
        }

        Arrays.sort(chickens);
        Arrays.sort(cows);

        int num = 0;
        labelsarebad:
        for(int chindex = 0; chindex < nchickens; chindex++) {
            for(int cowindex = 0; cowindex < ncows; cowindex++) {
                if(cows[cowindex].min <= chickens[chindex] && cows[cowindex].max >= chickens[chindex]){
                    cows[cowindex] = new Cow(Integer.MIN_VALUE, Integer.MIN_VALUE);
                    num++;
                    continue labelsarebad;
                }
            }
        }

        out.println(num);
        out.close();
    }
}

class Cow implements Comparable<Cow> {
    int min;
    int max;
    public Cow(int n, int x) {
        min = n;
        max = x;
    }

    public int compareTo(Cow o) {
        int res = max - o.max;
        if(res == 0) return min - o.min;
        return res;
    }

    @Override
    public String toString() {
        return "[" + min + "," + max + "]";
    }
}