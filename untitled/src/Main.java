import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int S = in.nextInt();
        int pumpStart;
        int worst = 0;
        int badPump;
        int bestWorst = Integer.MAX_VALUE;


        for (pumpStart = 2; pumpStart <= N; pumpStart++) {
            worst = 0;
            for (badPump = 2; badPump <= N; badPump++) {
                ArrayList<Boolean> lowPressure = new ArrayList<>();
                lowPressure.add(false);
                lowPressure.add(true);
                for (int pump = 2; pump <= N; pump++) {
                    if (pump <= badPump) {
                        lowPressure.add(true);
                    } else {
                        lowPressure.add(false);
                    }
                }
                int currentPump = pumpStart;
                int currentTime = M * pumpStart - 2;
                boolean currentLowPressure = lowPressure.get(currentPump);
                boolean previousLowPressure = currentLowPressure;
                do {
                    currentTime += M;
                    currentTime += S;
                    previousLowPressure = currentLowPressure;
                    currentLowPressure = lowPressure.get(currentPump);
                    if (currentLowPressure && currentPump == N) {
                        break;
                    } else if (currentLowPressure) {
                        currentPump++;
                    } else if (currentPump == 3) {
                        break;
                    } else {
                        currentPump--;
                    }
                }
                while (previousLowPressure == currentLowPressure);
                worst = Math.max(worst, currentTime);
            }

            bestWorst = Math.min(bestWorst, worst);
        }

        System.out.println(bestWorst);
    }
}

