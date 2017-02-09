package com.codility.algorithms;

public class BinaryGap {

    public static int getBinaryGapFast(int n) {
        String binaryString = Integer.toBinaryString(n);
        int binaryStringSize = binaryString.length();
        int binaryGap = 0;
        for (int i = 0; i < binaryStringSize; i++) {
            int localGap = 0;
            if (binaryString.charAt(i) == '1') {
                i++;
                while (i < binaryStringSize && binaryString.charAt(i) != '1') {
                    localGap++;
                    i++;
                }
                i--;
                if (localGap > binaryGap && (i + 1) < binaryStringSize && (binaryString.charAt(i + 1) == '1')) binaryGap = localGap;
            }
        }
        return binaryGap;
    }

    public static int getBinaryGapSlow(int n) {
        String binaryString = Integer.toBinaryString(n);
        int binaryStringSize = binaryString.length();

        int binaryGap = 0;
        String tempString = "";
        for (int i = 1; i < binaryStringSize; i++) {
            tempString += "0";
            if (binaryString.contains(tempString)) {
                int startIndex = binaryString.indexOf(tempString);
                int endIndex = startIndex + tempString.length() - 1;
                if (binaryStringSize > endIndex + 1 && binaryString.charAt(startIndex - 1) == '1'
                        && binaryString.charAt(endIndex + 1) == '1') {
                    binaryGap = i;
                }
            }
        }
        return binaryGap;
    }
}
