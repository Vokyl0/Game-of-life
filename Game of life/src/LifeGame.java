import java.util.ArrayList;
import java.util.List;

public class LifeGame {
    private boolean[][] board;
    private final String rules;
    private double speed = 1;
    public LifeGame(String rules, int height, int width){
        this.board = new boolean[25][25];
        this.rules = rules;
    }
    public void show(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]){
                    System.out.printf("%s  ", "*");
                }else{
                    System.out.printf("%s  ", ".");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------");
    }
    private boolean isPointAlive(int a, int b){
        if (a < 0 || a >= board.length || b < 0 || b >= board[0].length){
            return false;
        }
        return board[a][b];
    }
    public void invertPoint(int a, int b){
        board[a][b] = !board[a][b];
    }
    public int countAliveNeighbours(int a, int b){
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (isPointAlive(a+i, b+j)){
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }
    public void nextStep(){
        List<Integer> stayAlive = new ArrayList<>();
        List<Integer> becomeAlive = new ArrayList<>();
        char[] stayAliveArray = rules.split("/")[0].toCharArray();
        char[] becomeAliveArray = rules.split("/")[1].toCharArray();
        for (char digit : stayAliveArray) {
            stayAlive.add((int)(digit - '0'));
        }
        for (char digit : becomeAliveArray) {
            becomeAlive.add((int)(digit - '0'));
        }
        boolean[][] newBoard = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!isPointAlive(i,j)){
                    boolean tmp = false;
                    for (Integer digit : becomeAlive) {
                        if (countAliveNeighbours(i,j) == digit){
                            tmp = true;
                        }
                    }
                    newBoard[i][j] = tmp;
                }else{
                    boolean tmp = false;
                    for (Integer digit : stayAlive) {
                        if (countAliveNeighbours(i,j) == digit){
                            tmp = true;
                        }
                    }
                    newBoard[i][j] = tmp;
                }
            }
        }
        board = newBoard;
    }
    public void runGame() throws InterruptedException {
        while (true){
            show();
            nextStep();
            Thread.sleep((int)(1000/speed));
        }
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
