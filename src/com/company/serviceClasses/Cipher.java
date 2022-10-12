package com.company.serviceClasses;

import static com.company.serviceClasses.Alphabet.*;

public class Cipher {

    public String encode(String inputText, int key) {
        String encryptedText = "";
        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);
            if (!Character.isAlphabetic(currentChar)) {
                encryptedText = encryptedText + currentChar;
                continue;
            }
            if (Character.isLowerCase(currentChar)) {
                int charIndex = ALPHABET_LOWER.indexOf(currentChar);
                int shiftIndex = (charIndex + key) % LATIN_SIZE;
                if (shiftIndex < 0) {
                    shiftIndex = LATIN_SIZE + shiftIndex;
                }
                char cipherChar = ALPHABET_LOWER.charAt(shiftIndex);
                encryptedText = encryptedText + cipherChar;
            } else {
                int charIndex = ALPHABET_UPPER.indexOf(currentChar);
                int shiftIndex = (charIndex + key) % LATIN_SIZE;
                if (shiftIndex < 0) {
                    shiftIndex = LATIN_SIZE + shiftIndex;
                }
                char cipherChar = ALPHABET_UPPER.charAt(shiftIndex);
                encryptedText = encryptedText + cipherChar;
            }
        }
        return encryptedText;
    }

    public String decode(String inputText, int key) {
        return encode(inputText, key * -1);
    }
}
