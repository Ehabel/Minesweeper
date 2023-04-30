package game.board;

import game.board.cells.Cells;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private ArrayList<ArrayList<Cells>> board;
    private Long numMines;
    private Long size;

    public Board(Long size, Long numMines){
        this.board = new ArrayList<ArrayList<Cells>>();
        this.size = size;
        this.numMines = numMines;
        this.generateBoard();
    }

    public void generateBoard(){
        for(int i = 0; i < this.size; i++){
            this.board.add(new ArrayList<Cells>());
            for(int j = 0; j < this.size; j++){
                this.board.get(i).add(new Cells(i, j, false));
            }
        }
        setMines();
    }

    public void setMines(){
        int counter = 0;
        Random random = new Random();
        while(counter != this.numMines) {
            int randRow = random.nextInt(Math.toIntExact(this.size));
            int randCol = random.nextInt(Math.toIntExact(this.size));
            if(this.board.get(randRow).get(randCol).getMine()) {
                continue;
            } else {
                this.board.get(randRow).get(randCol).setMine(true);
                counter++;
            }
        }
    }

    public void renderBoard(){
        for (int i = 0; i < this.board.size(); i++) {
            for (int j = 0; j < this.board.get(i).size(); j++) {
//                System.out.print(this.board.get(i).get(j).getMine() + " ");
//                System.out.print("|??");
//                System.out.printf("%d%d ", i, j);
                System.out.print(this.board.get(i).get(j).toString() + " ");
            }
            System.out.println();
        }
    }

    public void renderBoardDebug(){
        for (int i = 0; i < this.board.size(); i++) {
            for (int j = 0; j < this.board.get(i).size(); j++) {
                System.out.print(this.board.get(i).get(j).getMine() + " ");
//                System.out.print("|??");
//                System.out.printf("%d%d ", i, j);
            }
            System.out.println();
        }
    }

    public int getCellNeighbours(Cells cell){
        ArrayList<Cells> neighbours = new ArrayList<Cells>();
        int x = cell.getX();
        int y = cell.getY();
        int above = y - 1;
        int below = y + 1;
        int left = x - 1;
        int right = x + 1;
        int count = 0;

        if(above >= 0 ){
            if(left >= 0) {
                neighbours.add(this.board.get(x - 1).get(y - 1));
                count += this.board.get(x - 1).get(y - 1).getMine() ? 1 : 0;
            };
            if(right < this.size) {
                neighbours.add(this.board.get(x + 1).get(y - 1));
                count += this.board.get(x + 1).get(y - 1).getMine() ? 1 : 0;
            }
            neighbours.add(this.board.get(x).get(y - 1));
            count += this.board.get(x).get(y - 1).getMine() ? 1: 0;
        }

        if(left >= 0){
            neighbours.add(this.board.get(x - 1).get(y));
            count +=this.board.get(x - 1).get(y).getMine() ? 1: 0;
        }

        if(right < this.size){
            neighbours.add(this.board.get(x + 1).get(y));
            count += this.board.get(x + 1).get(y).getMine() ? 1: 0;
        }

        if(below < this.size){
            if(left >= 0) {
                neighbours.add(this.board.get(x - 1).get(y + 1));
                count += this.board.get(x - 1).get(y + 1).getMine() ? 1 : 0;
            }
            if(right < this.size) {
                neighbours.add(this.board.get(x + 1).get(y + 1));
                count += this.board.get(x + 1).get(y + 1).getMine() ? 1 : 0;
            }
            neighbours.add(this.board.get(x).get(y + 1));
            count += this.board.get(x).get(y + 1).getMine() ? 1: 0;
        }
        cell.setRevealed(true);
        this.cascade(count, neighbours);
        return count;
    }

    private void cascade(int count, ArrayList<Cells> neighbours){
        for(Cells c: neighbours){
            if(!c.isRevealed() && !c.getMine()){
                if(count == 0) {
                    c.setNeighbouringMines(this.getCellNeighbours(c));
                    c.setDisplay(String.valueOf(c.getNeighbouringMines() + " |"));
                    c.setRevealed(true);
                }
            }
        }
    }

    public Cells getCell(int x, int y){
        return this.board.get(x).get(y);
    }
    public void run(){
        this.renderBoard();
    }
}
