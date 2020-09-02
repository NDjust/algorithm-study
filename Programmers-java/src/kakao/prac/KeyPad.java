package kakao.prac;


import java.util.Map;

public class KeyPad {

    static int[][] pad = {
            {' ', '1', '2', '3'},
            {' ', '4', '5', '6'},
            {' ', '7', '8', '9'},
            {' ', '*', '0', '#'}
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;

        for (int number : numbers) {
            number = number == 0 ? 11 : number;
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right = number;
            } else {
                int leftDis = getDistance(left, number);
                int rightDis = getDistance(right, number);

                if (leftDis < rightDis) {
                    sb.append("L");
                    left = number;
                } else if (leftDis > rightDis) {
                    sb.append("R");
                    right = number;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = number;
                    } else {
                        sb.append("R");
                        right = number;
                    }
                }
            }
        }
        return sb.toString();

    }

    static int getDistance(int source, int dest) {
      int sRow = source / 3;
      int sCol = source % 3;

      if (sCol == 0) {
          sRow--;
          sCol = 3;
      }

      int dRow = dest / 3;
      int dCol = dest % 3;

      return Math.abs(dRow - sRow) + Math.abs(dCol - sCol);
    }
}
