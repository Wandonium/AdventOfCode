import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2Solution {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        File inputs = new File("inputs2.txt");
        ArrayList<Character> commonChar = new ArrayList();
        try {
            Scanner reader = new Scanner(inputs);
            int totalValue = 0;
            while(reader.hasNextLine()) {
                String line1 = reader.nextLine();
                String line2 = reader.nextLine();
                String line3 = reader.nextLine();
                for(char c: line1.toCharArray()) {
                    if(line2.indexOf(c) != -1 && line3.indexOf(c) != -1 && !commonChar.contains(c)) {
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
