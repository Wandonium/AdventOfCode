import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        File inputs = new File("inputs2.txt");
        try {
            Scanner reader = new Scanner(inputs);
            int currentTotal = 0;
            ArrayList<Integer> totals = new ArrayList();
            while(reader.hasNextLine()) {
                String input = reader.nextLine();
                if(input.isEmpty()) {
                    totals.add(currentTotal);
                    currentTotal = 0;
                } else {
                    int num = Integer.parseInt(input);
                    currentTotal += num;
                }
            }
            totals.sort((a, b) -> b - a);
            System.out.println("LargestTotal: " + totals.get(0));
            System.out.println("Total of heaviest 3: " + (totals.get(0) + totals.get(1) + totals.get(2)));
        } catch (FileNotFoundException e) {
            System.out.println("Inputs file not found!");
            e.printStackTrace();
        }
        
    }
}