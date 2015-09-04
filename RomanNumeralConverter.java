//credits to John Kurlak
public class RomanNumeralConverter {

    public static int romanNumeralToInteger(String s) {
        int length = s.length();
        int sum = 0;
        int sumOfSameValues = 0;

        for (int i = 0; i < length; ++i) {
            char currentChar = s.charAt(i);
            int currentValue = valueOf(currentChar);
            boolean hasNextValue = (i < n - 1);

            sumOfSameValues += currentValue;

            if (!hasNextValue) {
                sum += sumOfSameValues;
            } else {
                char nextChar = s.charAt(i + 1);
                int nextValue = valueOf(nextChar);

                if (nextValue < currentValue) {
                    sum += sumOfSameValues;
                    sumOfSameValues = 0;
                } else if (nextValue > currentValue) {
                    sum -= sumOfSameValues;
                    sumOfSameValues = 0;
                }
            }
        }

        return sum;
    }

    private static int valueOf(char c) {
        switch (c) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }
}
