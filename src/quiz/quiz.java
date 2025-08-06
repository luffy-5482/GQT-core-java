package quiz;

import java.util.*;

public class quiz {

    // Color codes
    final static String RESET = "\u001B[0m";
    final static String GREEN = "\u001B[32m";
    final static String RED = "\u001B[31m";
    final static String YELLOW = "\u001B[33m";
    final static String CYAN = "\u001B[36m";
    final static String BLUE = "\u001B[34m";
    final static String PURPLE = "\u001B[35m";

    static Scanner sc = new Scanner(System.in);
    static String name, city, dob;
    static boolean audienceUsed = false, fiftyFiftyUsed = false;
    static int earnedReward = 0;
    static int safeReward = 0;

    static String[] questions = {
            "Who is the captain of Royal Challengers Bangalore (RCB) in IPL 2025?",
            "Which country is known as the Land of the Rising Sun?",
            "Which is the largest continent in the world?",
            "Who invented the light bulb?",
            "Which is the national animal of India?",
            "In which year did India win its first Cricket World Cup?",
            "What is the chemical formula of water?",
            "Which Indian city is known as the Pink City?",
            "Which planet is closest to the Sun?",
            "Who was the first President of India?"
    };

    static String[][] options = {
            {"Faf du Plessis", "Virat Kohli", "Glenn Maxwell", "Dinesh Karthik"},
            {"China", "India", "Japan", "Thailand"},
            {"Africa", "Asia", "Europe", "Australia"},
            {"Thomas Edison", "Alexander Graham Bell", "Isaac Newton", "Albert Einstein"},
            {"Lion", "Tiger", "Leopard", "Elephant"},
            {"1975", "1983", "1996", "2011"},
            {"H2O", "O2", "CO2", "H2SO4"},
            {"Jaipur", "Mumbai", "Hyderabad", "Delhi"},
            {"Mercury", "Venus", "Earth", "Mars"},
            {"Dr. Rajendra Prasad", "Dr. B.R. Ambedkar", "Jawaharlal Nehru", "Sardar Vallabhbhai Patel"}
    };

    static int[] correctAnswers = {1, 3, 2, 1, 2, 2, 1, 1, 1, 1};
    static int[] rewards = {1000, 2000, 5000, 10000, 20000, 40000, 80000, 160000, 320000, 1000000};

    static void getCandidateDetails() {
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your city: ");
        city = sc.nextLine();
        
    }

    static void displayRewardTree() {
        System.out.println("\n" + YELLOW + "Reward Tree:" + RESET);
        for (int i = 0; i < rewards.length; i++) {
            System.out.println((i + 1) + " Question - Reward: ₹" + rewards[i]);
        }
        System.out.println(YELLOW + name + ", Your current reward is ₹" + earnedReward + RESET);
        System.out.println("-------------------------------------------------------------------------");
    }

    static boolean askQuestion(int q) {
        System.out.println(BLUE + "\n" + name + ", this is your Question " + (q + 1) + ":" + RESET);
        System.out.println(CYAN + questions[q] + RESET);

        for (int i = 0; i < 4; i++) {
            System.out.println(YELLOW + (i + 1) + ". " + options[q][i] + RESET);
        }

        if (!audienceUsed || !fiftyFiftyUsed) {
            System.out.print("\nDo you want to use a lifeline? (yes/no): ");
            String useLifeline = sc.next();
            if (useLifeline.equalsIgnoreCase("yes")) useLifeline(q);
        }

        System.out.print("\n" + name + ", enter your answer (1-4): ");
        int answer = sc.nextInt();
        return answer == correctAnswers[q];
    }

    static void useLifeline(int q) {
        System.out.println("Available lifelines:");
        if (!audienceUsed) System.out.println(YELLOW + "1. Audience Poll" + RESET);
        if (!fiftyFiftyUsed) System.out.println(YELLOW + "2. Fifty Fifty" + RESET);

        System.out.print("Enter your choice (1/2): ");
        int choice = sc.nextInt();

        if (choice == 1 && !audienceUsed) {
            audienceUsed = true;
            Random rand = new Random();
            int correctPercent = 50 + rand.nextInt(31);
            int[] otherPercents = new int[3];
            int remaining = 100 - correctPercent;
            for (int i = 0; i < 2; i++) {
                otherPercents[i] = rand.nextInt(remaining + 1);
                remaining -= otherPercents[i];
            }
            otherPercents[2] = remaining;
            System.out.println(BLUE + "\nAudience Poll Results:" + RESET);
            int correctIndex = correctAnswers[q] - 1;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int percent = (i == correctIndex) ? correctPercent : otherPercents[count++];
                System.out.println(YELLOW + options[q][i] + " : " + percent + "%" + RESET);
            }
        } else if (choice == 2 && !fiftyFiftyUsed) {
            fiftyFiftyUsed = true;
            int correctIndex = correctAnswers[q] - 1;
            int randIncorrect;
            do {
                randIncorrect = new Random().nextInt(4);
            } while (randIncorrect == correctIndex);
            System.out.println(BLUE + "\nFifty Fifty Options:" + RESET);
            System.out.println(YELLOW + (correctIndex + 1) + ". " + options[q][correctIndex] + RESET);
            System.out.println(YELLOW + (randIncorrect + 1) + ". " + options[q][randIncorrect] + RESET);
        } else {
            System.out.println(RED + "Invalid or already used lifeline!" + RESET);
        }
    }

    static void handleCorrectAnswer(int q) {
        earnedReward = rewards[q];
        if (q == 4) safeReward = earnedReward;
        System.out.println(GREEN + "\n" + name + ", Congrats! Your answer is correct!" + RESET);
        System.out.println(YELLOW + name + ", Your current reward is ₹" + earnedReward + RESET);
    }

    static void handleWrongAnswer(int q) {
        System.out.println(RED + "\n" + name + ", Sorry! Your answer is wrong." + RESET);
        if (q < 4) {
            earnedReward = 0;
        } else if (q < 7) {
            earnedReward = rewards[4]; // Safe level = reward after Q5
        }
        System.out.println(YELLOW + name + ", you have earned ₹" + earnedReward + RESET);
        System.out.println(GREEN + "\nThank you for playing, " + name + "! Game Over." + RESET);
    }

    static boolean askToQuit(int q) {
        System.out.print(CYAN + "\nDo you want to continue or quit? (c/q): " + RESET);
        String choice = sc.next();
        if (choice.equalsIgnoreCase("q")) {
            int finalReward = (q == 0) ? 0 : rewards[q - 1];
            System.out.println(PURPLE + "\nYou chose to quit. You walk away with ₹" + finalReward + RESET);
            System.out.println(GREEN + "\nThank you for playing, " + name + "! Game Over." + RESET);
            return true;
        }
        return false;
    }
    static void printFinalMessage() {
        System.out.println(PURPLE + "\n\nCongrats " + name + "! You have completed the game." + RESET);
        System.out.println(YELLOW + "Candidate Details:" + RESET);
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("DOB: " + dob);
        System.out.println(GREEN + "Total Reward Earned: ₹" + earnedReward + RESET);
    }
    // ⬇️ MAIN METHOD AT THE END ⬇️
    public static void main(String[] args) {
        getCandidateDetails();
        displayRewardTree();

        for (int q = 0; q < questions.length; q++) {
            boolean correct = askQuestion(q);
            if (correct) {
                handleCorrectAnswer(q);
                if (q < questions.length - 1 && askToQuit(q)) break;
            } else {
                handleWrongAnswer(q);
                return;
            }
        }

        printFinalMessage();
    }
}
