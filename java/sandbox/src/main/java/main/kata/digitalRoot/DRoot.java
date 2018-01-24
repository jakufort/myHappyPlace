package main.kata.digitalRoot;

public class DRoot {

    int digitalRoot(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }
        String tmp = String.valueOf(n);
        while (tmp.length() > 1) {
            tmp = String.valueOf(sumDigits(Integer.valueOf(tmp)));
        }
        return Integer.valueOf(tmp);
    }

    private int sumDigits(int n) {
        return String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .reduce(0, (x,acc) -> x + acc);
    }

    //Solution by someone less mentally impaired than me
    public static int digital_root(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }
}
