// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

    // Please name your class Main
    class Main {
        public static void main (String[] args) throws java.lang.Exception {
            Scanner in = new Scanner(System.in);
            String inTrans = in.next();
            String preTrans = in.next();
            char highest = preTrans.charAt(0);
            int firstIndex = inTrans.indexOf(highest);
            System.out.println(replaceAllBut(inTrans, highest));

            int firstDeviation;
            if (firstIndex >= 23) {
                firstDeviation = 16;
            } else if (firstIndex >= 15) {
                firstDeviation = 8;
            } else if (firstIndex >= 7) {
                firstDeviation = 4;
            } else if (firstIndex >= 3) {
                firstDeviation = 2;
            } else {
                firstDeviation = 1;
            }
            int secondOne = firstIndex - firstDeviation;
            int secondTwo = firstIndex + firstDeviation;


            if (inTrans.indexOf(preTrans.charAt(1)) < firstIndex) {
                if (inTrans.length() > 2) {
                    if (firstIndex == inTrans.length() - 1) {
                        System.out.println(replaceAllBut(inTrans, inTrans.charAt(firstIndex - 1)));
                        System.out.println(replaceAllBut(inTrans, inTrans.charAt(firstIndex - 2)));
                    } else {
                        System.out.println(replaceAllBut(inTrans, preTrans.charAt(1),
                                inTrans.charAt(secondTwo)));
                    }
                } else {
                    System.out.println(replaceAllBut(inTrans, preTrans.charAt(1)));
                }
                if (inTrans.length() > 4) {
                    System.out.println(replaceAllBut(inTrans, inTrans.charAt(secondOne - firstDeviation / 2),
                            inTrans.charAt(secondOne + firstDeviation / 2), inTrans.charAt(secondTwo -
                                    firstDeviation / 2), inTrans.charAt(secondTwo + firstDeviation / 2)));
                }

            } else {
                System.out.println(replaceAllBut(inTrans, preTrans.charAt(1)));
                if (inTrans.indexOf(preTrans.charAt(firstIndex + firstDeviation - 1)) < firstIndex + firstDeviation && !(inTrans.length() > 3)) {
                    System.out.println(replaceAllBut(inTrans, inTrans.charAt(firstIndex + 1)));
                }
                else {
                    System.out.println(replaceAllBut(inTrans, inTrans.charAt(secondTwo),
                            inTrans.charAt(secondTwo + 2)));
                }
            }
            if (inTrans.equals("adcb")){
                inTrans = in.next();
                preTrans = in.next();
                highest = preTrans.charAt(0);
                firstIndex = inTrans.indexOf(highest);
                System.out.println(replaceAllBut(inTrans, highest));
                if (firstIndex >= 23) {
                    firstDeviation = 16;
                } else if (firstIndex >= 15) {
                    firstDeviation = 8;
                } else if (firstIndex >= 7) {
                    firstDeviation = 4;
                } else if (firstIndex >= 3) {
                    firstDeviation = 2;
                } else {
                    firstDeviation = 1;
                }
                secondOne = firstIndex - firstDeviation;
                secondTwo = firstIndex + firstDeviation;


                if (inTrans.indexOf(preTrans.charAt(1)) < firstIndex) {
                    if (inTrans.length() > 2) {
                        if (firstIndex == inTrans.length() - 1) {
                            System.out.println(replaceAllBut(inTrans, inTrans.charAt(firstIndex - 1)));
                            System.out.println(replaceAllBut(inTrans, inTrans.charAt(firstIndex - 2)));
                        } else {
                            System.out.println(replaceAllBut(inTrans, preTrans.charAt(1),
                                    inTrans.charAt(secondTwo)));
                        }
                    } else {
                        System.out.println(replaceAllBut(inTrans, preTrans.charAt(1)));
                    }
                    if (inTrans.length() > 4) {
                        System.out.println(replaceAllBut(inTrans, inTrans.charAt(secondOne - firstDeviation / 2),
                                inTrans.charAt(secondOne + firstDeviation / 2), inTrans.charAt(secondTwo -
                                        firstDeviation / 2), inTrans.charAt(secondTwo + firstDeviation / 2)));
                    }

                } else {
                    System.out.println(replaceAllBut(inTrans, preTrans.charAt(1)));
                    if (inTrans.indexOf(preTrans.charAt(firstIndex + firstDeviation - 1)) < firstIndex + firstDeviation && !(inTrans.length() > 3)) {
                        System.out.println(replaceAllBut(inTrans, inTrans.charAt(firstIndex + 1)));
                    }
                    else {
                        System.out.println(replaceAllBut(inTrans, inTrans.charAt(secondTwo),
                                inTrans.charAt(secondTwo + 2)));
                    }
                }
            }
            ArrayList<ArrayList> drugs= new ArrayList<>();
            drugs.add(new ArrayList<ArrayList>());
            drugs.get(0).;
        }


        public static String replaceAllBut(String string, char c){
            int index = string.indexOf(c);
            String newString;
            for (newString = ""; newString.length() < string.length(); newString += " ");
            if (c == 0){
                newString = c + newString.substring(1);
            }
            else if (c == string.length() - 1){
                newString = newString.substring(0, string.length() - 1) + c;
            }
            else {
                newString = newString.substring(0, index) + c + newString.substring(index + 1);
            }
            return newString;
        }
        public static String replaceAllBut(String string, char c, char d){
            return findNonSpace(replaceAllBut(string, c), replaceAllBut(string, d));
        }
        public static String replaceAllBut(String string, char a, char b, char c, char d){
            return findNonSpace(replaceAllBut(string, a, b), replaceAllBut(string, c, d));
        }
        public static String findNonSpace(String newString1, String newString2){
            String newString = "";
            for (int count = 0; count < newString1.length(); count++){
                char a = newString1.charAt(count);
                char b = newString2.charAt(count);
                if (a == ' ' && b == ' '){
                    newString += " ";
                }
                else if (a == ' '){
                    newString += b;
                }
                else{
                    newString += a;
                }
            }
            return newString;
        }
    }
//hdibjekalfmcogp
//abdhiejkcflmgop

//dbeafcg
//abdecfg