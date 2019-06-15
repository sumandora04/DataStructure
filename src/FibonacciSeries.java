public class FibonacciSeries {

    private int fib(int num){
        if (num==0){
            return 0;
        }else if (num==1){
            return 1;
        }else{
            return fib(num-1) + fib(num-2);
        }
    }

    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();

        System.out.println(fibonacciSeries.fib(200)); // Computation time is 2 sec and 510 ms.
    }

}
