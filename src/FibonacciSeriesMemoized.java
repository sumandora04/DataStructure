public class FibonacciSeriesMemoized {

    private int[] memo = new int[1001];
    private int memoFib(int num){
        if (num==0){
            return 0;
        }else if (num==1){
            return 1;
        }else if (memo[num]==0){
            memo[num] = memoFib(num-1)+memoFib(num-2);
            System.out.print(memo[num]+"\t");
        }

        return memo[num];
    }

    public static void main(String[] args) {
        FibonacciSeriesMemoized fibMemo = new FibonacciSeriesMemoized();
        System.out.println(fibMemo.memoFib(50)); // Less computation time

    }
}
