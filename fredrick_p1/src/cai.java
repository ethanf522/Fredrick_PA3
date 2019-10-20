import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Scanner;

public class cai {
    private static void generateResponse(boolean ans){
        SecureRandom random = new SecureRandom();
        int ran = random.nextInt(4) + 1;
        if(ans){
            switch(ran){
                case 1:
                    System.out.println("Your answer is correct!");
                    break;
                case 2:
                    System.out.println("Wow, you got it right!");
                    break;
                case 3:
                    System.out.println("Congratulations!");
                    break;
                case 4:
                    System.out.println("Huh, aren't you smart.");
                    break;
                default:
                    System.out.println("Something broke");
                    break;
            }
        }
        else{
            switch(ran) {
                case 1:
                    System.out.println("Sorry, your answer is incorrect. Try again");
                    break;
                case 2:
                    System.out.println("You got it wrong. Sorry.");
                    break;
                case 3:
                    System.out.println("Please try again.");
                    break;
                case 4:
                    System.out.println("You aren't very good at this.");
                    break;
                default:
                    System.out.println("Something broke");
                    break;
            }
        }
    }

    private static int generateLevel(int level){
        if(level == 1){
            return 10;
        }
        else if(level == 2){
            return 100;
        }
        else if(level == 3){
            return 1000;
        }
        else if(level == 4){
            return 10000;
        }
        return 0;
    }

    private static void generateType(int[] randomNums){
        int type = randomNums[2];
        if(type == 1){
            System.out.printf("What is %d plus %d? ", randomNums[0], randomNums[1]);
        }
        if(type == 2){
            System.out.printf("What is %d minus %d? ", randomNums[0], randomNums[1]);
        }
        if(type == 3){
            System.out.printf("What is %d times %d? ", randomNums[0], randomNums[1]);
        }
        if(type == 4){
            System.out.printf("What is %d divided %d? (Round to two decimal places) ", randomNums[0], randomNums[1]);
        }
    }

    private static int[] generateQuestion(int level, int type){
        SecureRandom random = new SecureRandom();
        int[] randomNums = new int[3];
        int bound = generateLevel(level);
        randomNums[0] = random.nextInt(bound);
        randomNums[1] = random.nextInt(bound - 1) + 1;
        if(type == 5){
            randomNums[2] = random.nextInt(4) + 1;
        }
        else{
            randomNums[2] = type;
        }
        generateType(randomNums);
        return randomNums;
    }

    private static int checkAnswer(double ans, int[] randomNums){
        DecimalFormat dec = new DecimalFormat("#.##");
        dec.setRoundingMode(RoundingMode.HALF_UP);
        int num1 = randomNums[0];
        int num2 = randomNums[1];
        int type = randomNums[2];
        boolean correct = true;
        if(type == 1){
            correct = (num1 + num2) == ans;
        }
        else if(type == 2){
            correct = (num1 - num2) == ans;
        }
        else if(type == 3){
            correct = (num1 * num2) == ans;
        }
        else if(type == 4){
            double actualAns = (double)num1 / num2;
            actualAns = Double.parseDouble(dec.format(actualAns));
            correct = actualAns == ans;
        }
        generateResponse(correct);
        if(correct){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] randomNums;
        int level, initialType;
        while(true) {
            double ans;
            int correctAnswers = 0;
            System.out.print("Enter difficulty level (1-4): ");
            level = scan.nextInt();
            System.out.print("Enter arithmetic type (1-5): ");
            initialType = scan.nextInt();
            for (int i = 0; i < 10; i++) {
                randomNums = generateQuestion(level, initialType);
                ans = scan.nextDouble();
                correctAnswers += checkAnswer(ans, randomNums);
            }
            double percentage = ((double)correctAnswers / 10) * 100;
            System.out.printf("You got a %.2f%%\n", percentage);
            if(percentage > 75){
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            else{
                System.out.println("Please ask your teacher for extra help.");
            }
            System.out.print("Would you like to go again? Y/N ");
            String choice = scan.next().toUpperCase();
            System.out.println(" ");
            if(choice.equals("N")){
                break;
            }
        }
    }
}
