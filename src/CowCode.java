import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CowCode {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("cowcode.in"));
        PrintWriter out = new PrintWriter(new File("code.out"));
        String str = in.next();
        int x = in.nextInt();
        out.println((x+str.length()-(x/str.length()))%str.length());
        out.close();
    }
}
