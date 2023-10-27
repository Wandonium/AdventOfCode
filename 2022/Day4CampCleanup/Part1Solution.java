import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1Solution {
    public static void main(String[] args) {
        File inputs = new File("inputs1.txt");
        try {
            Scanner reader = new Scanner(inputs);
            int count = 0;
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                int a = Integer.parseInt(parts[0].split("-")[0]);
                int b = Integer.parseInt(parts[0].split("-")[1]);
                int x = Integer.parseInt(parts[1].split("-")[0]);
                int y = Integer.parseInt(parts[1].split("-")[1]);
                if((a <= x && b >= y) || 
                    (x <= a && y >= b) ||
                    (a == b && (a == x || a == y)) ||
                    (x == y && (a == x || b == x)) ||
                    (a == b && x <= a && y >= a) ||
                    (x == y && a <= x && b >= x)
                ) {
                    count++;
                }
            }
            System.out.println("Number of assignment pairs where one range fully contains the other: " + count);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
