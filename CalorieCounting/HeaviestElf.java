import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeaviestElf {
    public static void main(String[] args) {
        File inputs = new File("inputs2.txt");
        try {
            Scanner reader = new Scanner(inputs);
            int count = 1;
            int currentTotal = 0;
            int largestTotal = currentTotal;
            int largestTotalIndex = count;
            while(reader.hasNextLine()) {
                String input = reader.nextLine();
                if(input.isEmpty()) {
                    if(currentTotal > largestTotal) {
                        largestTotal = currentTotal;
                        largestTotalIndex = count;
                    }
                    currentTotal = 0;
                    count++;
                } else {
                    int num = Integer.parseInt(input);
                    currentTotal += num;
                }
            }
            System.out.println("LargestTotal: " + largestTotal);
        } catch (FileNotFoundException e) {
            System.out.println("Inputs file not found!");
            e.printStackTrace();
        }
        
    }
}