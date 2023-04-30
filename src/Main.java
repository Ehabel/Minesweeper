import board.Board;

public class Main {
    public static void main(String[] args) {
        Long boardSize = ConfigParser.getSize();
        Board b = new Board(boardSize);
        b.run();
    }
}