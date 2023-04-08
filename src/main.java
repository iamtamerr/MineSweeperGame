import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row, column;
        System.out.println("Welcome to Minesweeper Game !");
        System.out.println("Please enter the sizes of the game");
        System.out.print("Row: ");
        row = input.nextInt();
        System.out.print("Column: ");
        column = input.nextInt();

        MinesweeperGame mayin  = new MinesweeperGame(row,column);
        mayin.run();
    }   
}
