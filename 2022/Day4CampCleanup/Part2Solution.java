import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2Solution {
    public static void main(String[] args) {
        File inputs = new File("inputs2.txt");
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
                ArrayList<Integer> nums1 = new ArrayList<>();
                ArrayList<Integer> nums2 = new ArrayList<>();
                for(int i = a; i <= b; i++) {
                    nums1.add(i);
                }
                for(int j = x; j <= y; j++) {
                    nums2.add(j);
                }
                for(Integer k: nums1) {
                    if(nums2.contains(k)) {
                        count++;
                        break;
                    }
                }
            }
            System.out.println("Number of assignment pairs that overlap: " + count);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
