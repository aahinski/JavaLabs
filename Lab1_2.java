/*
Агинский Антон 8 группа
1 задание, ряды Тейлора через BigDecimal и BigInteger
Тесты:

 X=5 K=2
 Используя double результат: 244.8781069449703
 Используя BigDecimal и BigInteger результат: 148.4029173713987
 Используя функцию exp(X) результат: 148.4131591025766

 X=3 K=3
 Используя double результат: 20.08521256087662
 Используя BigDecimal и BigInteger результат: 20.085212560876624
 Используя функцию exp(X) результат: 20.085536923187668
 */

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Lab1_2
{
    public static BigDecimal getFactorial(BigInteger n)
    {
        BigInteger result1 = BigInteger.valueOf(1);
        int n_int = n.intValue();
        for (int i = 2; i <= n_int; i++)
        {
            result1 = result1.multiply(BigInteger.valueOf(i));
        }
        BigDecimal result2 = new BigDecimal(result1.doubleValue());
        return result2;

    }

    public static void main(String[] args)
    {
        BigDecimal sum = new BigDecimal("1");
        BigInteger i = new BigInteger("1");

        System.out.println("Enter X");
        Scanner ScanX = new Scanner(System.in);
        String sX = ScanX.nextLine();
        BigDecimal X = new BigDecimal(sX);
        System.out.println("Enter K");
        Scanner ScanK = new Scanner(System.in);
        String sK = ScanK.nextLine();
        BigInteger K = new BigInteger(sK);

        BigDecimal e = BigDecimal.ONE.divide(BigDecimal.TEN.pow(K.intValue()), 16, RoundingMode.CEILING);
        BigDecimal term = X.divide(getFactorial(i), 16, RoundingMode.CEILING);

        while (term.compareTo(e) >= 0)
        {
            sum = sum.add(term);
            i = i.add(BigInteger.ONE);
            BigDecimal tmp = getFactorial(i);
            term = ((X.pow(i.intValue()))).divide(tmp, 16, RoundingMode.CEILING);
        }

        System.out.println("The result of Taylor series using BigInteger and BigDecimal is");
        System.out.println(sum.doubleValue());
        System.out.println("The result using exponenta function is ");
        System.out.println( Math.exp(X.intValue()) );
    }
}
