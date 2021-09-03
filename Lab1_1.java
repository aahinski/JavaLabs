//Антон Агинский 8 группа
//Лаба 1 задача 1

import java.util.Scanner;

class Lab1_1
{
    public static int getFactorial(int f)
    {
        int result = 1;
        for (int i = 1; i <= f; i++)
        {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args)
    {
        double sum = 1;
        double X;
        int K;
        int i = 1;

        System.out.println("Enter X");
        Scanner ScanX = new Scanner(System.in);
        String sX = ScanX.nextLine();
        X = Double.parseDouble(sX);
        System.out.println("Enter K");
        Scanner ScanK = new Scanner(System.in);
        String sK = ScanK.nextLine();
        K = Integer.parseInt(sK);

        double e = Math.pow(10, -K);
        double term = X / getFactorial(i);

        while (term >= e)
        {
            sum = sum + term;
            i++;
            term = Math.pow(X, i) / getFactorial(i);
        }

        System.out.println("The result using Taylor series is ");
        System.out.println(sum);
        System.out.println("The result exponenta function is ");
        System.out.println( Math.exp(X) );
    }
}
