package chess_pieces;

public abstract class ChessPiece {

    private int x, y;


    public int getPosX() { return x; }
    public int getPosY() { return y; }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract int points();
    public abstract int [][] getPossibleMoves(boolean [][] freeSpace);

}
