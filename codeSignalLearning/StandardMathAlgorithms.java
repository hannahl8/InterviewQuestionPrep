package codeSignalLearning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Welcome to today's lesson on Standard Math Algorithms in Java.
 * Many software engineering problems require understanding and application of standard math algorithms.
 * They form the basis of many complex real-life implementations.
 * As a programmer, your expertise in using math algorithms in Java not only helps you solve complex problems
 * efficiently but also gives you confidence in handling data-intensive tasks.
 * In this lesson, we will specifically delve into the use of prime numbers, an important area under standard math
 * algorithms.
 */
public class StandardMathAlgorithms {

    /**
     * Can you write a Java function that determines whether a given number {@code n} is a perfect square?
     * <p>
     * A perfect square is a number that can be expressed as the product of an integer with itself.
     * For example, 1 = 1 * 1, 4 = 2 * 2, 9 = 3 * 3, and 16 = 4 * 4 are perfect squares,
     * while 2, 3, 5, and 6 are not.
     * </p>
     *
     * <p>Examples:</p>
     * <pre>
     * {@code
     * isPerfectSquare(16); // returns true
     * isPerfectSquare(15); // returns false
     * }
     * </pre>
     *
     * @param n the number to check
     * @return {@code true} if {@code n} is a perfect square, otherwise {@code false}
     */
    public boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    /**
     * Can you write a Java function that returns the smallest prime number greater than a given integer {@code n}?
     * <p>
     * The input constraint is: {@code 1 ≤ n ≤ 10^6}.
     * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
     * This function should find and return the first prime number that is strictly greater than {@code n}.
     * </p>
     *
     * <p>Examples:</p>
     * <pre>
     * {@code
     * nextPrime(7);   // returns 11
     * nextPrime(13);  // returns 17
     * nextPrime(50);  // returns 53
     * }
     * </pre>
     *
     * @param n the number after which to search for the next prime
     * @return the smallest prime number greater than {@code n}
     */
    public int nextPrime(int n) {
        int candidate = n + 1;
        while (!isPrimeforNextPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    private boolean isPrimeforNextPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }


    /**
     * Can you write a Java function called {@code getPrimeFactors(int n)} that will return all unique prime factors
     * of an integer {@code n} in a list?
     *
     * <p>
     * A prime factor of {@code n} is a prime number that divides {@code n} without leaving a remainder.
     * The function should return all such prime factors only once, in ascending order.
     * </p>
     *
     * <p>
     * The expected time complexity is O(√n).
     * </p>
     *
     * @param n the integer to factorize
     * @return a list of unique prime factors of {@code n}, sorted in ascending order
     */
    public List<Integer> getPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();

        if (n % 2 == 0) {
            list.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                list.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 2) {
            list.add(n);
        }

        return list;
    }

    /**
     * Can you write a Java function that checks whether two given integers {@code a} and {@code b} are coprime?
     * <p>
     * Two numbers are said to be coprime (or mutually prime) if the only positive integer that divides both of them is 1.
     * In other words, their greatest common divisor (GCD) must be 1.
     * </p>
     *
     * <p>
     * The expected time complexity is O(√max(a, b)).
     * </p>
     *
     * <p>Examples:</p>
     * <pre>
     * {@code
     * Solution solution = new Solution();
     * System.out.println(solution.areCoprime(15, 28));   // Output: true
     * System.out.println(solution.areCoprime(12, 18));   // Output: false
     * }
     * </pre>
     *
     * @param a the first integer
     * @param b the second integer
     * @return {@code true} if {@code a} and {@code b} are coprime; {@code false} otherwise
     */
    public boolean areCoprime(int a, int b) {
        Set<Integer> divisorsA = getDivisors(a);
        Set<Integer> divisorsB = getDivisors(b);

        // Remove 1 because it is allowed as a common divisor
        divisorsA.remove(1);
        divisorsB.remove(1);

        // Check if there's any common divisor other than 1
        for (int divisor : divisorsA) {
            if (divisorsB.contains(divisor)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to get all common divisors
     *
     * @param n starting number
     * @return Set of divisors
     */
    private Set<Integer> getDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        return divisors;
    }


    /**
     * Can you write a Java function that returns the {@code n}-th prime number?
     * <p>
     * A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
     * This function should return the {@code n}-th prime in the sequence of prime numbers starting from 2.
     * </p>
     *
     * <p>
     * The expected time complexity is O(n ⋅ √n), which allows you to iterate through numbers and check each for primality
     * until the {@code n}-th prime is found.
     * </p>
     *
     * <p>Examples:</p>
     * <pre>
     * {@code
     * nthPrime(1); // returns 2
     * nthPrime(3); // returns 5
     * }
     * </pre>
     *
     * @param n the position of the prime number to return (1-based index)
     * @return the {@code n}-th prime number
     */
    public int nthPrime(int n) {
        int count = 0;
        int num = 1;

        while (count < n) {
            num++;
            if (isPrime(num)) {
                count++;
            }
        }

        return num;
    }

    /**
     * Checks whether a given number {@code num} is prime.
     *
     * @param num the number to check
     * @return {@code true} if {@code num} is prime; {@code false} otherwise
     */
    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;

        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

}
