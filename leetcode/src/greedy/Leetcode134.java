package greedy;

public class Leetcode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }

            if (solve(i, len, gas, cost) == i) {
                return i;
            }
        }

        return -1;
    }

    public int solve(int start, int n, int[] gas, int[] cost) {
        int j = (start + 1) % n;
        int currGas = gas[start] - cost[start];

        while (j != start) {
            currGas = currGas + gas[j] - cost[j];

            if (currGas < 0) {
                break;
            }

            j = (j + 1) % n;
        }

        return j == start ? start : -1;
    }

    public int greedy(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;

        int gasSum = 0;
        int costSum = 0;
        int tank = 0;


        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return gasSum < costSum ? -1 : start;
    }

    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int i = leetcode134.canCompleteCircuit(gas, cost);

        System.out.println(i);
    }
}
