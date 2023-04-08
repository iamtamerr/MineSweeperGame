import java.util.Random;
import java.util.Scanner;

public class MinesweeperGame {
    int row,column,size;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    MinesweeperGame(int row, int column){
        this.row = row;
        this.column = column;
        this.map = new int[row][column];
        this.board = new int[row][column];
        this.size = row*column;
    }

    public void check(int r, int c){
        if(map[r][c] == 0){
            if((r>0) && (map[r-1][c] == -1)){
                board[r][c]++;
            }
            if((r < row - 3) && (map[r+1][c] == -1)){
                board[r][c]++;
            }
            if((c>0) && (map[r][c-1] == -1)){
                board[r][c]++;
            }
            if((c < column -1) && (map[r][c+1] == -1)){
                board[r][c]++;
            }
            
            if(board[r][c] == 0){
                board[r][c] = -2;
            }
        }
        
    }

    public void run(){
        int rowuser, columnuser,success=0;
        prepareGame();
        System.out.println("The game has started!");
        while(game){
            print(board);
            System.out.print("Row: ");
            rowuser = input.nextInt();
            System.out.print("Column: ");
            columnuser = input.nextInt();
            if(rowuser < 0 || rowuser >= row){
                System.out.println("Invalid coordinate.");
                continue;
            }
            if(columnuser < 0 || columnuser >= column){
                System.out.println("Invalid coordinate.");
                continue;
            }
            if(map[rowuser][columnuser] != -1){
                check(rowuser,columnuser);
                success++;
                if(success == (size - (size/4))){
                    System.out.println("You avoid the all bombs! ");
                }
            }
            else{
                game = false;
                System.out.println("Game Over !");
            }
        }
    }

    public void prepareGame(){
        int randRow,randColumn,count = 0;
        while(count != (size/4)){
            randRow = rand.nextInt(row);
            randColumn = rand.nextInt(column);
            if(map[randRow][randColumn] != -1){
                map[randRow][randColumn] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length;j++){
                if(arr[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
