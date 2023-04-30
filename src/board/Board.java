package board;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Integer>> board;

    public Board(Long size){
        this.board = new ArrayList<ArrayList<Integer>>();
        this.generateBoard(size);
    }

    public void generateBoard(Long size){
        for(int i = 0; i <= size; i++){
            this.board.add(new ArrayList<Integer>());
            for(int j = 0; j <= size; j++){
                this.board.get(i).add(j);
            }
        }
    }

    public void renderBoard(){
        for (int i = 1; i < this.board.size(); i++) {
            for (int j = 1; j < this.board.get(i).size(); j++) {
                System.out.print("|??");
//                System.out.printf("%d%d ", i, j);
            }
            System.out.println();
        }
    }
    public void run(){
        System.out.println("Running");
        this.renderBoard();
    }
}
