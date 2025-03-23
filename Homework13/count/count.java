
import java.io.*;
import java.util.*;

public class count {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim().toLowerCase();

                if (!line.isEmpty()) {
                    wordCountMap.put(line, wordCountMap.getOrDefault(line, 0) + 1);
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    bw.write(entry.getKey() + " " + entry.getValue());
                    bw.newLine();
                }
                System.out.println("Word count results written to " + outputFilePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}

