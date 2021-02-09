package com.company;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * This class shows how a for loop can be used to generate html buttons on a static
 * html page. Using the console, it prompts for user input for the number of buttons
 * and what the label of the button should be. Then it uses a for loop to create the
 * specified number of buttons. This html is saved to a file.
 */
public class loopExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boxString("Welcome to the BUTTON MAKER EXAMPLE ****5000****");
        System.out.println("How many buttons would you like to make?");
        String input = scanner.nextLine();
        int numOfButtons = Integer.parseInt(input);
        System.out.println("What would you like the button to say?");
        String buttonLabel = scanner.nextLine();
        String link = "https://letmegooglethat.com/?q=" + URLEncoder.encode(buttonLabel);

        try {
            FileWriter myWriter = new FileWriter("loopExample.html");
            myWriter.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "   <meta charset=\"UTF-8\">\n" +
                    "   <title>Loop Elements Example</title>\n" +
                    "   <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n</head>\n" +
                    "<body>\n" +
                    "   <div class=\"container\">\n" +
                    "       <h1 class=\"display-4\">BUTTON MAKER EXAMPLE ****5000****</h1><br><hr>\n" +
                    "       <div class=\"row\">\n" +
                    "           <div class=\"col\">\n");
            int i = 0;
            while (i < numOfButtons) {
                myWriter.write("                <a class=\"btn btn-primary\" href=\"" + link + "\" role=\"button\">" + buttonLabel + "</a> <br><br> \n");
                i = i + 1;
            }
            myWriter.write("            </div>\n        </div>\n    </div>\n </body>\n" + "</html>");
            myWriter.close();
            System.out.println("Successfully created file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static void boxString(String inputString) {
        String ltc = "╔";
        String rtc = "╗";
        String lbc = "╚";
        String rbc = "╝";
        String horizontal = "═";
        String vertical = "║";
        int length = inputString.length() + 4;
        int offset = 5;
        System.out.print(ltc);
        for (int i = 0; i < length; i++) {
            System.out.print(horizontal);
        }
        System.out.println(rtc);
        System.out.println(vertical + "  " + inputString + "  " + vertical);
        System.out.print(lbc);
        for (int i = 0; i < length; i++) {
            System.out.print(horizontal);
        }
        System.out.println(rbc);
    }


}

