
import java.io.*;
import java.util.*;

public class count {
    
    public static void main(String[] args) {
        String inputFilePath = "input.txt";

        //List to store words
        List<String> words = new ArrayList<>();

        try {
            //Scanner to read the file
            Scanner scanner = new Scanner(new File(inputFilePath));
        
            //read words from file and add to list
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                words.add(word);
            }

            scanner.close();
        
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                int count = 1;

                //compare with words in list
                for (int j = i + 1; j < words.size(); j++) {
                    if (word.equals(words.get(j))) {
                        count++;
                        words.remove(j);
                        j--;
                    }
                }
                //print word and the count of word
                System.out.println(word + "; " + count);
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file " + inputFilePath + " was not found");
        }
            
    }
    
}

