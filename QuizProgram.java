/*
 *	Author:  
 *  Date: 
*/

import pkg.*;
import java.util.Random;
import java.util.Scanner;


public class QuizProgram {
    public static void main(String[] args) {
        Question[] Questions = getQuestion();
        // shuffleArray(Question);

        Scanner scanner = new Scanner(System.in);
        int QuestionAnswered = 0;
        int correctAnswers = 0;
        String[] subjects = {"Java Basics", "Control Flow", "Methods", "Arrays", "Classes", "Inheritance", "Polymorphism", "Recursion", "Data Structures", "Sorting Algorithms", "Searching Algorithms", "Exception Handling", "File I/O", "Interfaces", "Collections Framework", "Generics"};
        int[] correctPerSubject = new int[subjects.length];
        int[] incorrectPerSubject = new int[subjects.length];

        for (Question question : Questions) {
            question.display();
            System.out.print("Your answer (1-5): ");
            int userAnswer = scanner.nextInt();
            QuestionAnswered++;
            if (question.isCorrect(userAnswer)) {
                correctAnswers++;
                question.updateSubjectCount(correctPerSubject, incorrectPerSubject, true);
            } else {
                question.updateSubjectCount(correctPerSubject, incorrectPerSubject, false);
            }
            System.out.println();
        }
        scanner.close();

        System.out.println("You answered " + QuestionAnswered + " Question.");
        System.out.println("You got " + correctAnswers + " out of " + QuestionAnswered + " Question correct.");
        System.out.println("Your score: " + (correctAnswers * 100 / QuestionAnswered) + "%");

        System.out.println("Subjects that need more study:");
        for (int i = 0; i < subjects.length; i++) {
            if (incorrectPerSubject[i] > correctPerSubject[i]) {
                System.out.println(subjects[i]);
            }
        }
    }
    
    public static Question[] getQuestion() {
        
        return new Question[] {
            new Question("What is the output of the following Java code?\n" +
                    "int x = 5;\n" +
                    "int y = 2;\n" +
                    "System.out.println(x / y);",
                new String[] {"2.5", "2", "2.0", "Error", "Undefined"},
                1, "Java Basics"),
            new Question("In Java, the 'switch' statement can be used with which of the following data types?",
                new String[] {"float", "double", "char", "boolean", "String"},
                2, "Control Flow"),
            new Question("What is the purpose of the 'break' statement in Java?",
                new String[] {"To exit a loop or switch statement", "To skip the current iteration of a loop", "To resume execution after catching an exception", "To terminate the program", "None of the above"},
                0, "Control Flow"),
            new Question("In Java, methods are defined inside which block of code?",
                new String[] {"if-else", "switch", "class", "interface", "loop"},
                2, "Methods"),
            new Question("Which of the following is a valid declaration of a two-dimensional array in Java?",
                new String[] {"int[][] arr = new int[3,3];", "int[][] arr = new int[3][3];", "int[][] arr = { {1,2}, {3,4}, {5,6} };", "int[2][2] arr = new int[][];", "None of the above"},
                1, "Arrays"),
            new Question("In Java, a class can extend ______ class(es) at most.",
                new String[] {"0", "1", "2", "3", "No Limit"},
                1, "Classes"),
            new Question("Which of the following statements about interfaces in Java is false?",
                new String[] {"An interface can extend another interface", "A class can implement multiple interfaces", "An interface can contain method definitions", "An interface can have constructors", "None of the above"},
                3, "Interfaces"),
            new Question("What is the default base case for recursive methods in Java?",
                new String[] {"0", "1", "The smallest possible value of the data type", "There is no default base case", "None of the above"},
                3, "Recursion"),
            new Question("Which data structure in Java follows the Last In First Out (LIFO) principle?",
                new String[] {"Queue", "Stack", "ArrayList", "HashMap", "LinkedList"},
                1, "Data Structures"),
            new Question("Which of the following sorting algorithms has the best worst-case time complexity?",
                new String[] {"Selection Sort", "Bubble Sort", "Merge Sort", "Insertion Sort", "Quick Sort"},
                2, "Sorting Algorithms"),
            new Question("Which of the following searching algorithms requires the array to be sorted?",
                new String[] {"Linear Search", "Binary Search", "Depth-First Search", "Breadth-First Search", "Interpolation Search"},
                1, "Searching Algorithms"),
            new Question("In Java, what keyword is used to handle exceptions?",
                new String[] {"try", "throw", "catch", "finally", "except"},
                2, "Exception Handling"),
            new Question("Which class in Java is used to read and write files?",
                new String[] {"FileReader", "FileWriter", "BufferedReader", "File", "Scanner"},
                3, "File I/O"),
            new Question("Which of the following is true about the 'final' keyword in Java?",
                new String[] {"A final method cannot be overridden", "A final variable can be reassigned", "A final class cannot be subclassed", "All of the above", "None of the above"},
                2, "Java Basics")
    	    };
        }
}
