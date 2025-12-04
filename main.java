//Naval Shah and Aditya Pathak

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class main {

        public static void main(String[] args) {
            String inputPath = "heidi.txt";   // change to text2.txt if needed
            String outputPath = "output_singlethread.txt";

            long startTime = System.currentTimeMillis();

            try {
                List<String> lines = Files.readAllLines(Paths.get(inputPath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

                long cpuSum = 0;  // just to simulate heavy CPU work

                for (String line : lines) {
                    StringBuilder outLine = new StringBuilder();

                    // Split into words
                    String[] words = line.split("\\s+");

                    for (String word : words) {

                        if (word.isEmpty()) continue;

                        // Capitalize
                        String cap = word.toUpperCase();
                        outLine.append(cap).append(" ");

                        // Fake CPU-intensive work
                        // Add 1 to cpuSum for each character in the word, but done inefficiently
                        // to simulate heavy computation.
                        for (int i = 0; i < word.length() * 20000; i++) {
                            cpuSum++;
                        }
                    }

                    writer.write(outLine.toString().trim());
                    writer.newLine();
                }

                writer.close();

                long endTime = System.currentTimeMillis();
                System.out.println("Finished single-threaded processing.");
                System.out.println("CPU Work Sum = " + cpuSum);
                System.out.println("Elapsed time: " + (endTime - startTime) + " ms");

            } catch (IOException e) {
                e.printStackTrace();
            }

}
}