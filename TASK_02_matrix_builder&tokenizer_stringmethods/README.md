To perform the exercises that we are going to propose, you need to implement keyboard data entry, that is, allow the user to enter a value and collect said value in the program. You can base it on this small example:

import java.util.Scanner;

public class Test {

              public static void main(String[] args) {

                            Scanner reader = new Scanner(System.in);

                            String name;

                            System.out.println("What's your name?");

                            name = reader.nextLine();

                            System.out.println("Hello "+name);

                            reader.close();

               }

}

Execution from Eclipse would look like this:

Scanner reader = new Scanner(System.in);

The Scanner class is used to construct objects that represent input or reading data streams. In this case we have created the object passing System.in (keyboard input flow) as an argument.

name = reader.nextLine();

Allows the user to enter a line of text by keyboard and stores it in the name variable.

reader.close();

We must close the Scanner object when we no longer need it.


Exercise 1

Write a Java program that can be used to perform a small English test on the user. The test will consist of the translation of 20 words from English to Spanish. The test words will be extracted from a matrix of 20 rows and 2 columns. 


Exercise 2

Write a Java program that works according to the following specifications:

    - It must allow the user to enter text via keyboard.
    - The length of the text (number of characters) will be displayed on the screen.
    - The text will be displayed in capital letters.
    - The text will be displayed separated by words (each word on one line) using the split() method.
    - The number of lowercase letters will be counted.
    - A triangle will be displayed with the entered text.


Exercise 3 (optional)

Write a Java program that works according to the following specifications:

    - It should allow the user to enter multiple texts ending when typing the word END. Each text must be saved in an object of type String.
    - For each text entered (except the word END) the program must report the number of characters.
    - All the entered texts converted to uppercase must be concatenated (except the word END) into an object of type StringBuilder.
    - Within the StringBuilder object each new text must end with the semicolon character.
    - Finally, we must use an object of the StringTokenizer class to redisplay the texts entered on separate lines.
