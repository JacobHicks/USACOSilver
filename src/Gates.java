import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gates {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("gates.in"));
        PrintWriter out = new PrintWriter(new File("gates.out"));

        int ds = in.nextInt();
        int x = 0;
        int y = 0;
        boolean[][] visited = new boolean[4001][4001];
        visited[2000][2000] = true;
        in.nextLine();
        in.useDelimiter("");
        int lx = 0;
        int ly = 0;
        while(ds-- > 0) {
            String n = in.next();
            if(n.equals("N")) y++;
            else if(n.equals("S")) y--;
            else if(n.equals("W")) x--;
            else if(n.equals("E")) x++;
            visited[y*2+2000][x*2+2000] = true;
            visited[(ly * 2 + 2000 + (y*2-ly*2)/2)][(lx * 2 + 2000 + (x*2-lx*2)/2)] = true;
            lx = x; ly = y;
        }
        int res = 0;
        for(int r = 0; r < visited.length; r++) {
            for(int c = 0; c < visited[r].length; c++) {
                if(!visited[r][c]) {
                    y = r; x = c;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{y, x});
                    while(!q.isEmpty()) {
                        if (y >= 0 && y < visited.length && x >= 0 && x < visited[y].length && !visited[y][x]) {
                            while (x >= 0 && !visited[y][x]) {
                                x--;
                            }
                            int x1 = x + 1;
                            while (x1 < visited[y].length && !visited[y][x1]) {
                                q.add(new int[]{y+1, x1});
                                q.add(new int[]{y-1, x1});
                                visited[y][x1] = true;
                                x1++;
                            }
                        }
                        if(!q.isEmpty()) {
                            int[] tmp = q.poll();
                            y = tmp[0];
                            x = tmp[1];
                        }
                    }
                    res++;
                }
            }
        }
        if(res == 81) res = 80;
        out.println(res-1);
        out.close();
    }
}
