package edu.honchariukvadym;

/* 
  @author  Anavasynth
  @project  IntelliJ IDEA
  @class  RomanToArabic
  version 1.0.0
  @since 07.04.2025 - 12.49
*/

public class RomanToArabic {

    public int convert(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        roman = roman.toUpperCase();

        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            int value = romanCharToInt(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
                prevValue = value;
            }
        }

        if (!roman.equals(convertBack(result))) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
        }

        return result;
    }

    private int romanCharToInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid Roman character: " + c);
        };
    }

    private String convertBack(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(numerals[i]);
            }
        }
        return sb.toString();
    }
}
