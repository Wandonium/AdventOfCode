import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Part2Solution {
    public static void main(String[] args) {
        File inputs = new File("inputs2.txt");
        try {
            Scanner reader = new Scanner(inputs);
            Map<Character, String> sScore = Map.of(
                'X', "lost",
                'Y', "draw",
                'Z', "won"
            );
            Map<String, Integer> rScore = Map.of(
                "lost", 0,
                "draw", 3,
                "won", 6
            );
            Map<Character, Integer> s = Map.of(
                'R', 1,
                'P', 2,
                'S', 3
            );
            int grandTotal = 0;
            while(reader.hasNextLine()) {
                String input = reader.nextLine();
                char theirs = input.charAt(0);
                char ours = input.charAt(2);
                int roundTotal = 0;
                switch(theirs) {
                    case 'A':
                        if(ours == 'X') roundTotal = rScore.get(sScore.get('X')) + s.get('S');
                        else if(ours == 'Y') roundTotal = rScore.get(sScore.get('Y')) + s.get('R');
                        else if(ours == 'Z') roundTotal = rScore.get(sScore.get('Z')) + s.get('P');
                        break;
                    case 'B':
                        if(ours == 'X') roundTotal = rScore.get(sScore.get('X')) + s.get('R');
                        else if(ours == 'Y') roundTotal = rScore.get(sScore.get('Y')) + s.get('P');
                        else if(ours == 'Z') roundTotal = rScore.get(sScore.get('Z')) + s.get('S');
                        break;
                    case 'C':
                        if(ours == 'X') roundTotal = rScore.get(sScore.get('X')) + s.get('P');
                        else if(ours == 'Y') roundTotal = rScore.get(sScore.get('Y')) + s.get('S');
                        else if(ours == 'Z') roundTotal = rScore.get(sScore.get('Z')) + s.get('R');
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
