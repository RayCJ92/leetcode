public class Fibonacci {
    //#1 Recursion
    int fib1(int index){
       if (index < 3)
           return 1;
       return fib1(index-1) + fib1(index -2);
    }

    //#2 Array
    int fib2(int index){
        int[] a = new int[index];
        for (int i = 0; i < index; i++){
            if (i < 2)
                a[i] = 1;
            else
                a[i] = a[i-1]+a[i-2];
        }
        return a[index-1];
    }

    //#3 Iteration
    int fib3(int index){
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < index; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}