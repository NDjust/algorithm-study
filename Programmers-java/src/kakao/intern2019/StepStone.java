package kakao.intern2019;

class StepStone {

    public int solution(int[] stones, int k) {
        int answer=0;
        int N=stones.length;
        int max=0;
        int min=200000000;

        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        int mid;

        while(max>=min) {
            mid=(max+min)/2;
            if(isPossible(mid,N,k,stones.clone())) {
                answer=Math.max(answer, mid);
                min=mid+1;
            }
            else {
                max=mid-1;
            }
        }
        return answer;
    }
    public static boolean isPossible(int mid,int N,int k,int[] stones) {
        int check=0;
        for(int i=0;i<N;i++) {
            if(stones[i]<mid) {
                check++;
                if(check>=k) {
                    return false;
                }
            }
            else {
                check=0;
            }
        }
        return true;
    }
}