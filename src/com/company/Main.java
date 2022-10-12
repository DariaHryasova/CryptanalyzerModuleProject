package com.company;

import com.company.serviceClasses.Cipher;
import com.company.serviceClasses.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        Cipher cipher = new Cipher();
        Utils utils = new Utils();

        String text = Files.readString(Path.of(args[1], ""));
        int key = Integer.parseInt(args[2]);
        String fileName = args[1]; //входное имя пути

        if ("encode".equalsIgnoreCase(args[0])) {
            Path outFilePath = Path.of(utils.addEncodeToFileName(fileName, "_encoded"), "");

            String encoded = cipher.encode(text, key);
            Files.writeString(outFilePath, encoded);

        } else if ("decode".equalsIgnoreCase(args[0])) {
            Path outFilePath = Path.of(utils.addDecodeToFileName(fileName, "_decoded"), "");

            String decoded = cipher.decode(text, key);
            Files.writeString(outFilePath, decoded);
        }
    }
}
