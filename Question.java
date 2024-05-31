package pkg;
import java.util.Random;

public class Question {
    public String text;
    public String[] options;
    public int correctAnswerIndex;
    public String subject;

    public Question(String text, String[] options, int correctAnswerIndex, String subject) {
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.subject = subject;
        shuffleOptions();
    }

    public void display() {
        System.out.println(text);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == (correctAnswerIndex + 1);
    }

    private void shuffleOptions() {
        Random rand = new Random();
        for (int i = options.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            String temp = options[index];
            options[index] = options[i];
            options[i] = temp;
            if (index == correctAnswerIndex) {
                correctAnswerIndex = i;
            } else if (i == correctAnswerIndex) {
                correctAnswerIndex = index;
            }
        }
    }

    public void updateSubjectCount(int[] correctPerSubject, int[] incorrectPerSubject, boolean isCorrect) {
        if (isCorrect) {
            correctPerSubject[getIndex(subject)]++;
        } else {
            incorrectPerSubject[getIndex(subject)]++;
        }
    }

    private int getIndex(String subject) {
        String[] subjects = {"Java Basics", "Control Flow", "Methods", "Arrays", "Classes", "Inheritance", "Polymorphism", "Recursion", "Data Structures", "Sorting Algorithms", "Searching Algorithms", "Exception Handling", "File I/O", "Interfaces", "Collections Framework", "Generics"};
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                return i;
            }
        }
        return -1;
    }
}
