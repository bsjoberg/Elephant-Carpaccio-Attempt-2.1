package fun.bdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EchoInput {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Enter Your Name: ");
            String name = br.readLine();
            System.out.println("Hello " + name);
        } catch (IOException ioe) {
            System.out.println("IO Exception Raised");
        }
    }
}
