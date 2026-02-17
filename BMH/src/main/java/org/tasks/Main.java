package org.tasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        BoyerMooreHorspool bmh = new BoyerMooreHorspool();
        List<Integer> results = new ArrayList<>();

        String pattern = "h2xr30";
        String fileName = "hidden_code.txt";

        try (BufferedReader reader = createReader(fileName)){
            String line;

            while ((line = reader.readLine()) != null){
                line = line.trim();
                if (line.isEmpty()) continue;

                List<Integer> temResult = bmh.searchWithBoyerMooreHorspool(line, pattern);
                results.addAll(temResult);
            }

            System.out.print("The code secret is: ");
            for (int r : results){
                System.out.print(r);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedReader createReader(String filePath) throws IOException {
        return new BufferedReader( new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
    }

}
