package advanced;

import java.util.ArrayList;
import java.util.Random;

public class Bingo {
    public static void main(String[] args) {
        Random biNumber = new Random();
        String[][] bingoNumbers = new String[6][5];
        ArrayList<Integer> bnumbers = new ArrayList<>();

        bingoNumbers[0][0] = "   B ";
        bingoNumbers[0][1] = "  I ";
        bingoNumbers[0][2] = "  N ";
        bingoNumbers[0][3] = "  G ";
        bingoNumbers[0][4] = " O ";

        for (int loop = 0; loop < bingoNumbers[0].length; loop++) {
            int lowerBound = loop * 15 + 1;

            for (int i = 1; i < bingoNumbers.length; i++) {
                int bi = biNumber.nextInt(14) + lowerBound;
                while (true) {
                    if (bnumbers.contains(bi)) {
                        bi = biNumber.nextInt(14) + lowerBound;
                    } else {
                        bingoNumbers[i][loop] = String.valueOf(bi);
                        bnumbers.add(bi);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < bingoNumbers.length; i++) {
            for (int j = 0; j < bingoNumbers[0].length; j++) {
                if (j == 2 && i == 3) {
                    System.out.printf("%6s", "free");
                } else {
                    System.out.printf("%6s", bingoNumbers[i][j]);
                }
            }
            System.out.println();
        }

    }
}
