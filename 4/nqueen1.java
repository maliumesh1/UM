import java.util.*;

public class nqueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Queens :");
        int N = sc.nextInt();
        int board[][] = new int[N][N];

        // Initialize the board with zeros
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        // Call the helper method to solve N Queens problem
        helper(board, 0, N);

        // Print the final board configuration
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
        sc.close();
    }

    // Method to solve the N Queens problem recursively
    public static boolean helper(int board[][], int col, int N) {
        // Base case: If all queens are placed, return true
        if (col >= N) {
            return true;
        }
        // Recursive case: Try placing the queen in each row of the current column
        for (int i = 0; i < N; i++) {
            // Check if it's safe to place a queen in this position
            if (safe(board, col, i, N)) {
                // Place the queen
                board[i][col] = 1;
                // Recur to place the rest of the queens
                if (helper(board, col + 1, N)) {
                    return true;
                }
                // If placing queen here doesn't lead to a solution, backtrack
                board[i][col] = 0;
            }
        }
        // If no queen can be placed in this column, return false
        return false;
    }

    // Method to check if it's safe to place a queen in the given position
    public static boolean safe(int board[][], int col, int row, int N) {
        // Check if there's a queen in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Check lower diagonal on left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // If no queen is attacking the given position, return true
        return true;
    }
}
