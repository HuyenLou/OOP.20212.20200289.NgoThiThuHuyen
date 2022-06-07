package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "src/OtherProjects/src/hust/soict/dsai/garbage/test.bin";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();

        String oupuString = "";

        for (byte b : inputBytes) {
            oupuString += (char) b;
        }
        endTime = System.currentTimeMillis();
        // System.out.println("Output: " + oupuString);
        System.out.println("Time excute: " + (endTime - startTime) + "ms");
    }
}
