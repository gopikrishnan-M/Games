package Games;
import java.util.Scanner;
//game of tic tac toe
public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);

        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 3; ++col) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameover = false;

        while(!gameover) {
            display(board);
            System.out.println("enter the positiion of " + player);
            int row = sc.nextInt();

            int col;
            for(col = sc.nextInt(); row < 0 || row > 2; row = sc.nextInt()) {
                System.out.println("invalid index");
                System.out.println("enter the row ");
            }

            while(col < 0 || col > 2) {
                System.out.println("enter the col ");
                col = sc.nextInt();
            }

            if (board[row][col] != 'X' && board[row][col] != 'O') {
                for(int i = 0; i < board.length; ++i) {
                    for(int j = 0; j < board.length; ++j) {
                        board[row][col] = player;
                    }
                }
            } else {
                System.out.println("invalid index .. ;} the next time you do this ur move wont be considered");
                System.out.println("enter the positiion of " + player);
                row = sc.nextInt();
                col = sc.nextInt();
                board[row][col] = player;
            }

            if (isWin(board, player)) {
                gameover = true;
                System.out.println( "player :" +player + "   hey boi!!! you won the game");
            } else if (isFull(board)) {
                gameover = true;
                System.out.println("its draww :( ");
            }

            if (!gameover && !isFull(board)) {
                player = (char)(player == 'X' ? 79 : 88);
            }
        }

    }

    public static boolean isFull(char[][] board) {
        boolean iswhite = false;

        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 3; ++col) {
                if (board[row][col] == ' ') {
                    iswhite = false;
                    break;
                }

                iswhite = true;
            }
        }

        return iswhite;
    }

    public static void display(char[][] board) {
        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 3; ++col) {
                if(col==2){
                    System.out.print(board[row][col]);

                }
                else if(row==2) {
                    System.out.print(board[row][col] + " | ");
                }
                else{
                    System.out.print(board[row][col] + "_|_");
                }

            }

            System.out.println();
        }

    }

    public static boolean isWin(char[][] board, char player) {
        for(int col = 0; col < 3; ++col) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        for(int row = 0; row < 3; ++row) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        } else {
            return false;
        }
    }
}
