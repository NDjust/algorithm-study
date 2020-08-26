package kakao.prac;

public class KeyLock {

    private int m;

    private int n;

    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int boardSize = n * 3 - 2;
        int[][] board = new int[boardSize][boardSize];

        for (int i = 0; i < n; i++) {
            System.arraycopy(lock[i], 0, board[i + lock.length - 1], lock.length - 1, n);
        }

        for(int i = 0; i < 4; i++) {                                    //key가 3번 회전할 수 있으므로
            for(int j = 0; j < boardSize - key.length + 1; j++) {
                for(int q = 0; q < boardSize - key.length +1; q++) {        //testArr 필드에서 key를 대입해본다.
                    if(isCorrect(j, q, board.length, key, lock)) {
                        return true;
                    }
                }
            }
            key = rotate(key);                                            //키회전
        }
        return false;
    }

    public boolean isCorrect(int n, int m, int testArrLen, int[][] key, int[][] lock) {
        int y = n;
        int x = m;
        int[][] ax= new int[testArrLen][testArrLen];

        for (final int[] ints : key) {                //TestArr크기의 빈배열의 적절한 위치에 key 요소를 넣고
            for (int j = 0; j < key.length; j++) {
                ax[y][x++] += ints[j];
            }
            y++;
            x = m;
        }

        for (int i = 0; i < lock.length; i++) {                //키 값이 들어간 이차원 배열의 중앙에 lock의 값을 넣어준다.
            for (int j = 0 ; j < lock.length; j++) {
                ax[i+lock.length-1][j+lock.length-1] += lock[i][j];
                if(ax[i+lock.length-1][j+lock.length-1] != 1) {        //lock의 모든 요소가 1이 아니면 false
                    return false;
                }
            }
        }
        return true;
    }


    public int[][] rotate(int[][] key) {
        int[][] rotateKey = new int[key.length][key.length];

        for(int i = 0; i < key.length; i++) {
            int targetI = key.length-1;
            for(int j = 0; j <key.length; j++) {
                rotateKey[i][j]= key[targetI][i];
                targetI--;
            }
        }

        return rotateKey;
    }

}
