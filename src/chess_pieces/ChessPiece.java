package chess_pieces;

import java.util.List;

public abstract class ChessPiece {

    protected int xPos, yPos;
    protected boolean isWhite;


    public ChessPiece(int xPos, int yPos, boolean isWhite) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isWhite = isWhite;
    }


    public int getXPos() { return xPos; }
    public int getYPos() { return yPos; }
    public void setPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public abstract int points();
    public abstract List<int []> getPossibleMoves(boolean [][] freeSpace, boolean [][] opponents);
    //public abstract List<int []> getPossibleSpecialMoves();

}
