import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
/*
public class Lifegaurds {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new File("lifeguards.out"));

        int ncows = in.nextInt();
        Cow[] lifegaurds = new Cow[ncows];
        for(int i = 0; i < ncows; i++) {
            lifegaurds[i] = new Cow(in.nextLong(), in.nextLong());
        }
        Arrays.sort(lifegaurds);
        long min = Long.MAX_VALUE;
        long total = 0;
        long currTime = 0;
        for(int i = 0; i < lifegaurds.length; i++) {
            if(lifegaurds[i].startTime > currTime) currTime = lifegaurds[i].startTime;
            if(currTime < lifegaurds[i].endTime) {
                lifegaurds[i].startTime = currTime;
                long end = lifegaurds[i].endTime;
                if (i != lifegaurds.length - 1) {
                    end = Math.min(lifegaurds[i].endTime, lifegaurds[i + 1].startTime);
                }
                min = Math.min(min, Math.max(end - currTime, 0));
                total += Math.max(lifegaurds[i].endTime - currTime, 0);
                currTime = lifegaurds[i].endTime;
            }
            else {
                min = 0;
            }
        }
        out.println(total-min);
        out.close();
    }
}

class Cow implements Comparable<Cow> {
    long startTime;
    long endTime;

    Cow(long s, long e) {
        startTime = s;
        endTime = e;
    }
    @Override
    public int compareTo(Cow o) {
        int res = (int) (startTime - o.startTime);
        if(res == 0) res = (int) (endTime - o.endTime);
        return res;
    }
}
*/