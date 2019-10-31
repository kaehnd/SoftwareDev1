import java.util.*;
import java.lang.*;
public class FilterLine {
    public static void main (String[] args) throws java.lang.Exception {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[][] stars = new int[length][3];
        for (int row = 0; row < stars.length; row++) {
            for (int col = 0; col < stars[row].length; col++) {
                stars[row][col] = in.nextInt();
            }
        }
        Arrays.sort(stars, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]);
            }
        });
        int bestNetValue = 0;
        for (int count = 0; count < 200; count++) {
            int netValue= 0;
            int[][] shuffledMatrix = new int[length][3];
            for (int row = 0; row < stars.length; row++) {
                for (int col = 0; col < stars[row].length; col++) {
                    shuffledMatrix[row][col] = stars[row][col];
                }
            }
            shuffle(shuffledMatrix);
            for (int row = 0, rowSecond = 1; rowSecond < stars.length; row++, rowSecond++) {
                if ((stars[rowSecond][0] - stars[row][1]) < 0) {
                    if (stars[row][2] != 0) {
                        if (stars[rowSecond][2] / (stars[rowSecond][1] - stars[rowSecond][0]) > stars[row][2] /
                                (stars[row][1] - stars[row][0])) {
                            stars[row][2] = 0;
                        } else {
                            stars[rowSecond][2] = 0;
                        }
                    }
                }
            }
            for (int row = 0; row < stars.length; row++) {
                netValue += stars[row][2];
            }
            bestNetValue = Math.max(netValue, bestNetValue);
        }
        System.out.println(bestNetValue);
    }
    public static void shuffle(int[][] a) {
        Random random = new Random();

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = a[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                int temp = a[i][j];
                a[i][j] = a[m][n];
                a[m][n] = temp;
            }
        }
    }

}
//test by checking Low(of high number)- High(of low number)
//2d array
/*
(stars[rowSecond][2] / (stars[rowSecond][1] - stars[rowSecond][0]) > stars[row][2] /
        (stars[row][1] - stars[row][0]))*/
