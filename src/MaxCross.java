import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//AM DONE NOT FINISHED
public class MaxCross {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("maxcross.in"));
        PrintWriter out = new PrintWriter("maxcross.out");

        int nwalks = in.nextInt();
        int kneeded = in.nextInt();
        int nbroken = in.nextInt();

        boolean[] walk = new boolean[nwalks];
        int[] dp = new int[nwalks];
        while(nbroken-- > 0) walk[in.nextInt()-1] = true;

        out.println(recur(walk, dp, 0, kneeded, 0, 1));
        out.close();
    }

    public static int recur(boolean[] walk, int[] dp, int i, int kneeded, int kcurr, int currepair) {
        if(kneeded == kcurr) return 0;
        if(i == walk.length) return walk.length;
        else if(walk[i]) {
            if(dp[i] != 0)
                return dp[i];
            else {
                int d = 1 + recur(walk, dp, i + 1, kneeded, kcurr + 1, currepair + 1);
                int b = recur(walk, dp, i + 1, kneeded, 0, currepair);
                dp[i] = Math.min(Math.max(d, currepair), b);
                return dp[i];
            }
        }
        return recur(walk, dp, i+1, kneeded, kcurr + 1, currepair);
    }
}