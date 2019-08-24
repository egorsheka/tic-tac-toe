package launcher;

import action.CharInserter;
import action.GameLogic;
import action.GamePrinter;
import entity.Player;
import parser.LineParser;
import validator.ChoiceValidator;

import java.util.Arrays;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player's names");
        System.out.print("Player1: ");
        Player firstPlayer = new Player(scanner.nextLine());
        System.out.print("Player2: ");
        Player secondPlayer = new Player(scanner.nextLine());


        GameLogic gameLogic = new GameLogic();
        String gameBoard = GamePrinter.EMPTY_GAME_BOARD_STRING;
        int whoPlayFirst = (int) (1 + Math.random() * 2);


        while (true) {

            System.out.println(gameBoard);

            String firstTurn = (whoPlayFirst == 1) ? firstPlayer.getName() : secondPlayer.getName();
            System.out.printf(firstTurn + "'s turn\n Enter position: ");

            String choice = scanner.nextLine();

            ChoiceValidator choiceValidator = new ChoiceValidator();
            if (!choiceValidator.checkLine(choice)) {
                System.out.println("Incorrect values, enter again.");
                continue;
            }

            LineParser lineParser = new LineParser();
            int[] numbers = lineParser.getDateFromLine(choice);


            CharInserter charInserter = new CharInserter();
            Player winPlayer;

            if (whoPlayFirst == 1) {
                gameBoard = charInserter.insertX(numbers[0], numbers[1], gameBoard);
                whoPlayFirst++;
                gameLogic.setGameBoardValue(numbers[0] * 3 + numbers[1], 1);
                winPlayer = firstPlayer;
            } else {
                gameBoard = charInserter.insertO(numbers[0], numbers[1], gameBoard);
                whoPlayFirst--;
                gameLogic.setGameBoardValue(numbers[0] * 3 + numbers[1], 2);
                winPlayer = secondPlayer;

            }

            if (gameLogic.isEndOfGame()) {
                System.out.println(gameBoard);
                System.out.println("END!" + winPlayer.getName() + " has won!");
                winPlayer.win();

                System.out.println(firstPlayer.getName() + " has " + firstPlayer.getVictories() + " wins");
                System.out.println(secondPlayer.getName() + " has " + secondPlayer.getVictories() + " wins");

                System.out.printf("Would you like to continue?(Yes/No)");
                String playAgain = scanner.nextLine();
                if ("yes".equals(playAgain.toLowerCase())) {
                    gameLogic = new GameLogic();
                    gameBoard = GamePrinter.EMPTY_GAME_BOARD_STRING;
                    whoPlayFirst = (int) (1 + Math.random() * 2);
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
