import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        File inputs = new File("inputs2.txt");
        try {
            Scanner reader = new Scanner(inputs);
            ArrayList<Stack> list = new ArrayList<>();
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                if(line.indexOf('[') != -1) {
                    char[] arr = line.toCharArray();
                    int stackIndex = 0;
                    for(int i = 0; i < arr.length; i+=4) {
                        char c = arr[i + 1];
                        if(c == ' ') {
                            System.out.println("c is an empty character");
                        } else {
                            if(list.isEmpty()) {
                                for(int j = 0; j <= stackIndex; j++) {
                                    Stack newStack = new Stack<Character>();
                                    if(j == stackIndex) newStack.push(c);
                                    list.add(newStack);
                                }
                            } else if(stackIndex > list.size() - 1) {
                                Stack stack = new Stack<Character>();
                                stack.push(c);
                                System.out.println("Push " + c + " into stack");
                                list.add(stack);
                            } else {
                                Stack stack = list.get(stackIndex);
                                stack.push(c);
                            }
                        }
                        System.out.println("list: " + list);
                        stackIndex++;
                    }
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
