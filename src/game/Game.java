package game;

import game.board.Board;
import game.board.cells.Cells;

import java.util.Objects;
import java.util.Scanner;


public class Game {
    private boolean isRun = true;
    private Board board;

    public Game(){
        Long[] configVals = ConfigParser.getConfig();
        Long boardSize = configVals[0];
        Long mineCount = configVals[1];
        board = new Board(boardSize, mineCount);
    }

    public void run(){
        Scanner s = new Scanner(System.in);
        while(isRun){
            board.run();
            String move = s.nextLine();
            if(Objects.equals(move, "") || move.length() != 2 ||  !Character.isDigit(move.charAt(0)) || !Character.isDigit(move.charAt(1))){
                System.out.println("Please enter a numeric Coordinate");
                continue;
            }
            int[] moveCord = {Character.getNumericValue(move.charAt(0)), Character.getNumericValue(move.charAt(1))};
            Cells c = board.getCell(moveCord[0], moveCord[1]);
            if(c.getMine()){
                System.out.println("You lost");
                isRun = false;
            }
            c.setNeighbouringMines(board.getCellNeighbours(c));
            c.setDisplay(c.getNeighbouringMines() + " |");
            if(board.revealedAll()){
                board.run();
                System.out.println("You win!");
                isRun = false;
            }
        }
    }
}
