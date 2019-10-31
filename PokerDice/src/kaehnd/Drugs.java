package kaehnd;

public class Drugs {
    public static void main(String args[]){
        int [] pickles = {1, 2, 2, 4, 4};
        int [] life = {1, 1, 2, 3, 3};
        int [] yodling = {1, 2, 3, 4, 5};
        int [] not = {1, 2, 2, 4, 4};
        System.out.println(isTwoPair(pickles));
        System.out.println(isTwoPair(life));
        System.out.println(isTwoPair(yodling));
        System.out.println(isTwoPair(not));

    }

    public static boolean isTwoPair(int[] drugs) {
        int numbersSame = 0;
        int pairs = 0;
        for (int i = 0; i < drugs.length && numbersSame < 3; i++) {
            numbersSame = 0;
            for (int x = 0; x < drugs.length; x++) {
                if (drugs[i] == drugs[x]) {
                    numbersSame++;
                }
            }
            if (numbersSame == 2) {
                pairs++;
            }
        }
        return (pairs == 4);
    }
}
