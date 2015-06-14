import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Rockets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int size = scanner.nextInt();
        System.out.println("  /\\");
        for(int i = 0; i < size; ++i)
        {
            System.out.println("  ||");
        }
        System.out.println(" /||\\");
        System.out.println("/:||:\\");
        for(int i = 0; i < size-1; ++i)
        {
            System.out.println("|:||:|");
        }
        System.out.println("|/||\\|");
        System.out.println("  **");
        System.out.println("  **");         
        
    }
}
