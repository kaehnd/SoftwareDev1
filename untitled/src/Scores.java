import java.util.Scanner;

public class Scores {

    public Scanner in = new Scanner(System.in);
    public int rows = in.nextInt();
    public int cols = in.nextInt();
    public int[][] drugs = new int[rows][cols];

    public Scores() {
        for (int c = 0; c < rows; c++) {
            for (int x = 0; x < cols; x++) {
                drugs[c][x] = in.nextInt();
            }
        }
    }

}

