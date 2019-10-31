package kaehnd;

import java.util.Scanner;

/**
 * Roll a hand of poker dice and display
 * relevant information.
 */
public class TestDriver {

    public static void main(String[] args){
        Hand hand = new Hand();
        String reroll;
        Scanner stdIn = new Scanner(System.in);

        do{
            System.out.println("Your hand: " + hand.toString());
            if(hand.isFiveOfAKind()){
                System.out.println("It's 5-of-a-kind!");
            }
            if(hand.isFourOfAKind()){
                System.out.println("It's 4-of-a-kind!");
            }
            if(hand.isThreeOfAKind()){
                System.out.println("It's 3-of-a-kind!");
            }
            if(hand.isTwoPair()){
                System.out.println("It's two pair!");
            }
            if(hand.isFullHouse()){
                System.out.println("It's a full house!");
            }
            if(hand.isLargeStraight()){
                System.out.println("It's a large straight!");
            }
            System.out.println("The highest die in your roll is " + hand.highDie());

            System.out.println();
            reroll = getYN("Reroll?",stdIn);
            if(reroll.equals("y")){
                doReroll(hand,stdIn);
            }
        } while(!reroll.equals("n"));

        System.out.println("Thank you!  Your final hand was "
                + hand.toString());
    }

    private static void doReroll(Hand hand, Scanner stdIn){
        System.out.print("Dice to reroll: ");
        hand.roll(reroll(stdIn.nextLine()));
    }

    private static boolean[] reroll(String numbers){
        Scanner readNumbers = new Scanner(numbers);
        boolean reroll[] = new boolean[Hand.HAND_SIZE];
        while(readNumbers.hasNextInt()){
            reroll[readNumbers.nextInt()] = true;
        }
        return reroll;
    }

    private static String getYN(String prompt, Scanner input){
        String answer;
        do {
            System.out.print(prompt+" [y/n] ");
            answer = input.nextLine();
        } while(answer.length() == 0 ||
                !(answer.substring(0,1).equalsIgnoreCase("y")
                        || answer.substring(0,1).equalsIgnoreCase("n")));
        return answer.substring(0,1).toLowerCase();
    }
}
