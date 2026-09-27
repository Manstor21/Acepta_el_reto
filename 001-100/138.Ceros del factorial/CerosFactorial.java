import java.util.Scanner;

public class CerosFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        while (casos-- > 0) {
            long n = sc.nextLong();
            long ceros = 0;
            for (long divisor = 5; divisor <= n; divisor *= 5) {
                ceros += n / divisor;
            }
            System.out.println(ceros);
        }
        sc.close();
    }
}