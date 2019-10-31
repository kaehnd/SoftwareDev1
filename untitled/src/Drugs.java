public class Drugs{
    public static void main(String[] args) {
        Scores drugs = new Scores();
        for (int c = 0; c < drugs.rows; c++){
            for (int x = 0; x < drugs.cols; x++){
                System.out.print(drugs.drugs[c][x]);
            }
            System.out.println();
        }
    }
}

