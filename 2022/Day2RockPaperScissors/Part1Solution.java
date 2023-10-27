import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Part1Solution {
    public static void main(String[] args) {
        File inputs = new File("inputs2.txt");
        try {
            Scanner reader = new Scanner(inputs);
            Map<Character, Integer> shapeScore = Map.of(
                'X', 1,
                'Y', 2,
                'Z', 3
            );
            Map<String, Integer> roundScore = Map.of(
                "lost", 0,
                "draw", 3,
                "won", 6
            );
            int grandTotal = 0;
            while(reader.hasNextLine()) {
                String input = reader.nextLine();
                char theirs = input.charAt(0);
                char ours = input.charAt(2);
                int roundTotal = 0;
                switch(theirs) {
                    case 'A':
                        if(ours == 'X') roundTotal = roundScore.get("draw") + shapeScore.get('X');
                        else if(ours == 'Y') roundTotal = roundScore.get("won") + shapeScore.get('Y');
                        else if(ours == 'Z') roundTotal = roundScore.get("lost") + shapeScore.get('Z');
                        break;
                    case 'B':
                        if(ours == 'X') roundTotal = roundScore.get("lost") + shapeScore.get('X');
                        else if(ours == 'Y') roundTotal = roundScore.get("draw") + shapeScore.get('Y');
                        else if(ours == 'Z') roundTotal = roundScore.get("won") + shapeScore.get('Z');
                        break;
                    case 'C':
                        if(ours == 'X') roundTotal = roundScore.get("won") + shapeScore.get('X');
                        else if(ours == 'Y') roundTotal = roundScore.get("lost") + shapeScore.get('Y');
                        else if(ours == 'Z') roundTotal = roundScore.get("draw") + shapeScore.get('Z');
                        break;
                }
                grandTotal += roundTotal;
            }
            System.out.println("Total Score: " + grandTotal);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
