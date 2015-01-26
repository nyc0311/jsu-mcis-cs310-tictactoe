import java.util.Scanner;

public class TicTacToe {

    private int[][] matrix = new int[3][3]; // 1-->X 4-->O
    private Scanner input = new Scanner(System.in);
    private String winner;

    private void readcoordinates(int p) {
        System.out.print("Mark Location       ");
        int x = input.nextInt();
        int y = input.nextInt();

        while (x < 0 || x >= 3 || y < 0 || y >= 3 || matrix[x][y] != 0) {
            System.out.println("wrong location! re-input");
            System.out.print("Mark Location       ");
            x = input.nextInt();
            y = input.nextInt();
        }

        matrix[x][y] = p;
        String s;
        if (p == 1) {
            s = "X";
        } else {
            s = "O";
        }
        System.out.println("Location Should Be  " + x + "  " + y + "   " + s);

    }

    private boolean haswinner() {
        for (int i = 0; i < 3; i++) {
            int s1 = 0;
            int s2 = 0;

            for (int j = 0; j < 3; j++) {
                s1 += matrix[i][j];
                s2 += matrix[j][i];

            }
            if (s1 == 3 || s2 == 3) {
                winner = "X";

                return true;
            }
            if (s1 == 12 || s2 == 12) {
                winner = "O";
                return true;
            }
        }
        int s1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
        int s2 = matrix[0][2] + matrix[1][1] + matrix[2][0];
        if (s1 == 3 || s2 == 3) {
            winner = "X";

            return true;
        }
        if (s1 == 12 || s2 == 12) {
            winner = "O";
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Start New Game");
        TicTacToe game = new TicTacToe();
        int step = 0;
        while (true) {
            game.readcoordinates(1);
            step++;
            if (game.haswinner()) {
                System.out.println("Winner Should Be    " + game.winner);
                System.exit(0);
            }
            if (step == 9) {
                System.out.println("Winner Should Be    TIE");
                System.exit(0);
            }
            game.readcoordinates(4);
            step++;
            if (game.haswinner()) {
                System.out.println("Winner Should Be    " + game.winner);
                System.exit(0);
            }
        }
    }
}
