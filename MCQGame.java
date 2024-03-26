import javax.swing.JOptionPane;
import java.util.Random;

public class MCQGame {
    public static void main(String[] args) {
        String[] answers = {"c", "b", "d", "b", "b", "c", "a", "a", "d", "a", "a", "a", "c", "d", "b", "a"};
        Random rand = new Random();
        int response;
        int round = 1;

        do {
            JOptionPane.showMessageDialog(null, "          WELCOME TO JINX MCQ GAMES          \nEnter a letter to answer the questions: " + "Round " + round);

            // Generate 5 random questions for the current round
            int[] randomQ = rand.ints(0, 16).distinct().limit(5).toArray();

            // Questions
            String[] input = new String[5]; // Capacity of questions asked
            for (int i = 0; i < randomQ.length; i++) {
                input[i] = JOptionPane.showInputDialog(Questions(randomQ[i]));
            }

            // To keep count of the Score and verify the answers
            int score = 0;
            StringBuilder wrongAnswers = new StringBuilder();
            for (int i = 0; i < randomQ.length; i++) {
                if (input[i] != null && input[i].equalsIgnoreCase(answers[randomQ[i]])) {
                    score++;
                } else {
                    wrongAnswers.append("\nQuestion ").append(i + 1).append(": ").append(Questions(randomQ[i])).append("\nCorrect Answer: ").append(answers[randomQ[i]]).append("\nYour Answer: ").append(input[i]).append("\n");
                }
            }

            // Displaying the Score and wrong answers
            StringBuilder scoreMessage = new StringBuilder("Score: ").append(score).append(" out of ").append(randomQ.length);
            if (score >= 0 && score <= 2) {
                JOptionPane.showMessageDialog(null, scoreMessage.toString() + "\nBetter luck next time :(\n" + wrongAnswers.toString());
            } else if (score == 3) {
                JOptionPane.showMessageDialog(null, scoreMessage.toString() + "\nNice try!\n" + wrongAnswers.toString());
            } else if (score == 4) {
                JOptionPane.showMessageDialog(null, scoreMessage.toString() + "\nGreat Job!\n" + wrongAnswers.toString());
            } else if (score == 5) {
                JOptionPane.showMessageDialog(null, scoreMessage.toString() + "\nSo you smart smart...hun?\n" + wrongAnswers.toString());
            }

            // Asking if Player wants to play the next round
            if (score == 4 | score == 5) {
                response = JOptionPane.showConfirmDialog(null, "Do you want to play Round 2?", "Confirmation", JOptionPane.YES_NO_OPTION);
                round++;
            } else {
                response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirmation", JOptionPane.YES_NO_OPTION);
            }
        } while (response == JOptionPane.YES_OPTION);

        if (response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Thanks for Playing!");
        }
    }

    // Getting the questions based on index
    // Add more questions here
    public static String Questions(int index) {
        switch (index) {
            case 0:
                return "What is the capital of Australia?\n a)Sydney \n b)Melbourne \n c)Canberra \n d)Brisbane";
            case 1:
                return "What is the capital of Nigeria?\n a)Lagos \n b)Abuja \n c)Kano \n d)Aba";
            case 2:
                return "What doesn't qualify as a herbivore?\n a)Rhino \n b)Hippopotamus \n c)Cow \n d)Squirrels ";
            case 3:
                return "Which country is known as the Land of the Rising Sun?\n a)China \n b)Japan \n c)South Korea \n d)Thailand ";
            case 4:
                return "Which planet is known as the Red Planet?\n a)Venus \n b)Mars \n c)Jupiter \n d)Saturn";
            case 5:
                return "What is the currency of Brazil?\n a)Peso \n b)Euro \n c)Real \n d)Dollar";
            case 6:
                return "In which country would you find the ancient city of Petra?\n a)Jordan \n b)Egypt \n c)Greece \n d)Turkey";
            case 7:
                return "What is the national animal of China?\n a)Panda \n b)Tiger \n c)Dragon \n d)Elephant";
            case 8:
                return "Which country is the largest by land area?\n a)United States \n b)China \n c)Canada \n d)Russia";
            case 9:
                return "Which river is the longest in the world?\n a)Nile \n b)Amazon \n c)Mississippi \n d)Yangtze";
            case 10:
                return "What is the official language of Argentina?\n a)Spanish \n b)Portuguese \n c)Italian \n d)French";
            case 11:
                return "Which artist painted the \"Mona Lisa\"?\n a)Leonardo da Vinci \n b)Pablo Picasso \n c)Christopher Van Ogb \n d)Michelangelo";
            case 12:
                return "What is the largest desert in the world?\n a)Gobi Desert \n b)Arabian Desert \n c)Sahara Desert \n d)Antarctica";
            case 13:
                return "Which continent is the most populous?\n a)Africa \n b)Europe \n c)South America \n d)Asia";
            case 14:
                return "Which country is known as the \"Land of the Midnight Sun\"?\n a)Kenya \n b)Norway \n c)Japan \n d)Egypt";
            case 15: 
                return "Which country is the largest by population?\n a)India \n b)United States \n c)China \n d)Brazil ";
            default:
                return "";
        }
    }
}

