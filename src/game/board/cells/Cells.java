package game.board.cells;

public class Cells {
    private int x;
    private int y;
    private boolean isMine;
    private String display = "??";

    public Cells(int x, int y,boolean isMine){
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isMine() {
        return isMine;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return  getDisplay();
    }
}
