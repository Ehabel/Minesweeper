import board.Board;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Long boardSize = ConfigParser.getConfig()[0];
        Long mineCount = ConfigParser.getConfig()[1];
        Board b = new Board(boardSize);
        b.run();
    }
}