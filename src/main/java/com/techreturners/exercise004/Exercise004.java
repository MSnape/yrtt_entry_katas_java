package com.techreturners.exercise004;

import java.lang.String;

public class Exercise004 {

    // Move the first letter of each word to the end of it, then add "ay" to the end of the word.
    // Leave punctuation marks untouched.

    public String pigLatin(String str) {

        //Split string into words delimited by spaces
        String[] words = str.split(" ");
        StringBuilder returnString = new StringBuilder();

        // for each word
        for (int i = 0; i < words.length; i++) {
            String modifiedWord = "";
            boolean alphaFound = false;
            int firstAlphaIndex = 0;

            // find first alphanumeric char
            while (!alphaFound && firstAlphaIndex < words[i].length()) {
                if (words[i].substring(firstAlphaIndex, firstAlphaIndex + 1).matches("[A-Za-z0-9]+")) {
                    alphaFound = true;
                } else {
                    firstAlphaIndex++;
                }
            }

            // find where firstAlpha should be positioned and create modified word
            int reverseIndex = words[i].length();
            boolean positionFound = false;
            while (!positionFound && reverseIndex > 0) {
                if (words[i].substring(reverseIndex - 1, reverseIndex).matches("[A-Za-z0-9]+")) {
                    String preAlpha = words[i].substring(0, firstAlphaIndex);
                    String firstAlpha = words[i].substring(firstAlphaIndex, firstAlphaIndex + 1);
                    String wordBody = words[i].substring(firstAlphaIndex + 1, reverseIndex);
                    String endPunctuation = words[i].substring(reverseIndex);

                    modifiedWord = preAlpha + wordBody + firstAlpha + "ay" + endPunctuation;
                    positionFound = true;
                } else
                    reverseIndex--;
            }

            // special case handling for spaces at the end of strings
            if (i != words.length - 1) {
                returnString.append(modifiedWord).append(" ");
            } else {
                if (str.substring(words[i].length() - 1).equals(" ")) {
                    returnString.append(modifiedWord).append(" ");
                } else {
                    returnString.append(modifiedWord);
                }
            }
        }
        return returnString.toString();
    }
}
