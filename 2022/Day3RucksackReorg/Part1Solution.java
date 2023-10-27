import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1Solution {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        File inputs = new File("inputs2.txt");
        ArrayList<Character> commonChar = new ArrayList();
        try {
            Scanner reader = new Scanner(inputs);
            int totalValue = 0;
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                int mid = (line.length() / 2);
                // rucksack compartment 1
                String comp1 = line.substring(0, mid);
                // rucksack compartment 2
                String comp2 = line.substring(mid, line.length());
                for(char c: comp1.toCharArray()) {
                    if(comp2.indexOf(c) != -1 && !commonChar.contains(c)) {
                        commonChar.add(c);
                        int value = alphabet.indexOf(c) + 1;
                        totalValue += value;
                    }
                }
                commonChar.clear();
            }
            System.out.println("Sum of priorities of item types: " + totalValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
