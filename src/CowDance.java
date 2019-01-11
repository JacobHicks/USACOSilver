import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
//Yet another Failure
public class CowDance {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("cowdance.in"));
        PrintWriter out = new PrintWriter("cowdance.out");

        int ncows = in.nextInt();
        int maxtime = in.nextInt();

        int[] cows = new int[ncows];

        for(int i = 0; i < ncows; i++) {
            cows[i] = in.nextInt();
        }

        Arrays.sort(cows);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < ncows; i++) {
            sum += cows[i];
            if(sum > maxtime) {
                sum = cows[i];
                res++;
            }
        }
        if(sum != 0) res += 1 + sum / maxtime;
        out.println(res);
        out.close();
    }
}
