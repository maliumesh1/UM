import java.util.Scanner;

public class TicTacToe {
    static Scanner in = new Scanner(System.in);
    static String board[][] = new String[3][3];
    static int moveCount;
    static String humanPlayer;
    static String aiPlayer;
    static int moveI, moveJ; // board indexes of current AI moves - used in printBoard();

    public static void init() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
    }

    public static void selectSymbol() {
        String input = "";
        System.out.println("Choose X|O : ");
        input = in.next();
        while (!input.equalsIgnoreCase("x") && !input.equalsIgnoreCase("o")) {
            System.out.println("\nInvalid Input! (Only X or O)\n");
            System.out.println("Choose X|O : ");
            input = in.next();
        }
        humanPlayer = (input.equalsIgnoreCase("x")) ? "X" : "O";
        aiPlayer = (humanPlayer.equals("X")) ? "O" : "X";
    }

    public static void printBoard() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" |\n");
        }
        System.out.println();
        if (checkWin(board).equals("nothing")) {
            if (moveCount != 0) {
                System.out.println("AI Player marked " + aiPlayer + " at position " + (moveI + 1) + "-" + (moveJ + 1));
            }
            System.out.println("Your Move (Use Numpad) : ");
        }
    }

    public static boolean validMove(int boardNumber) {
        int indexes[] = getBoardIndexes(boardNumber);
        if (!board[indexes[0]][indexes[1]].equals(" "))
            return false;
        return true;
    }

    public static void inputMove() {
        int humanPlayerInput = 0;
        do {
            try {
                humanPlayerInput = in.nextInt();
                if ((humanPlayerInput < 1 || humanPlayerInput > 9))
                    System.out.println("Invalid Input (Only 1-9)");
                else if (!validMove(humanPlayerInput))
                    System.out.println("Invalid Move! Place Already Marked!");
            } catch (Exception e) {
                System.out.println("Invalid Input (Only 1-9)");
                in.next();
            }
        } while (humanPlayerInput < 1 || humanPlayerInput > 9 || !validMove(humanPlayerInput));
        int indexes[] = getBoardIndexes(humanPlayerInput);
        board[indexes[0]][indexes[1]] = humanPlayer;
    }

    public static int[] getBoardIndexes(int boardNumber) {
        int[] indexes = new int[2];
        switch (boardNumber) {
            case 7:
                indexes[0] = 0;
                indexes[1] = 0;
                return indexes;
            case 8:
                indexes[0] = 0;
                indexes[1] = 1;
                return indexes;
            case 9:
                indexes[0] = 0;
                indexes[1] = 2;
                return indexes;
            case 4:
                indexes[0] = 1;
                indexes[1] = 0;
                return indexes;
            case 5:
                indexes[0] = 1;
                indexes[1] = 1;
                return indexes;
            case 6:
                indexes[0] = 1;
                indexes[1] = 2;
                return indexes;
            case 1:
                indexes[0] = 2;
                indexes[1] = 0;
                return indexes;
            case 2:
                indexes[0] = 2;
                indexes[1] = 1;
                return indexes;
            case 3:
                indexes[0] = 2;
                indexes[1] = 2;
                return indexes;
        }
        return indexes;
    }

    public static boolean isHumanTurn() {
        if (moveCount % 2 == 0)
            return true;
        return false;
    }

    public static void findBestMove() {
        int bestValue = -10000;
        moveI = -1;
        moveJ = -1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].equals(" ")) {
                    board[i][j] = aiPlayer;
                    int val = getBoardValue(board, 0, false);
                    board[i][j] = " ";
                    if (val > bestValue) {
                        bestValue = val;
                        moveI = i;
                        moveJ = j;
                    }
                }
        board[moveI][moveJ] = aiPlayer;
    }

    public static int getBoardValue(String newBoard[][], int depth, boolean isMax) {
        if (checkWin(newBoard).equals("draw"))
            return 0 + depth;
        if (checkWin(newBoard).equals(aiPlayer))
            return 10 - depth;
        if (checkWin(newBoard).equals(humanPlayer))
            return -10 + depth;
        if (isMax) {
            int maxValue = -100;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (newBoard[i][j].equals(" ")) {
                        newBoard[i][j] = aiPlayer;
                        int value = getBoardValue(newBoard, depth + 1, !isMax);
                        newBoard[i][j] = " ";
                        if (value > maxValue)
                            maxValue = value;
                    }
            return maxValue;
        } else {
            int minValue = 10000;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (newBoard[i][j].equals(" ")) {
                        newBoard[i][j] = humanPlayer;
                        int value = getBoardValue(newBoard, depth + 1, !isMax);
                        newBoard[i][j] = " ";
                        if (value < minValue)
                            minValue = value;
                    }
            return minValue;
        }
    }

    public static String checkWin(String newBoard[][]) {
        for (int i = 0; i < 3; i++) {
            if (newBoard[i][0].equals(newBoard[i][1]) && newBoard[i][1].equals(newBoard[i][2])) {
                if (!newBoard[i][0].equals(" "))
                    return newBoard[i][0];
            }
            if (newBoard[0][i].equals(newBoard[1][i]) && newBoard[1][i].equals(newBoard[2][i])) {
                if (!newBoard[0][i].equals(" "))
                    return newBoard[0][i];
            }
        }
        if ((newBoard[0][0].equals(newBoard[1][1]) && newBoard[1][1].equals(newBoard[2][2])) ||
                (newBoard[0][2].equals(newBoard[1][1]) && newBoard[1][1].equals(newBoard[2][0]))) {
            if (!newBoard[1][1].equals(" "))
                return newBoard[1][1];
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (newBoard[i][j].equals(" "))
                    return "nothing";
        return "draw";
    }

    public static void aiMove() {
        findBestMove();
    }

    public static void play() {
        moveCount = 0;
        printBoard();
        while (checkWin(board).equals("nothing")) {
            if (isHumanTurn())
                inputMove();
            else
                aiMove();
            printBoard();
            moveCount++;
        }
        if (checkWin(board).equals(humanPlayer))
            System.out.println("You win!");
        else if (checkWin(board).equals(aiPlayer))
            System.out.println("AI Player wins!");
        else
            System.out.println("Draw!");
    }

    public static void main(String args[]) {
        init();
        selectSymbol();
        play();
    }
}
