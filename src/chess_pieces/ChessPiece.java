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

    public boolean isWhite() { return isWhite; }

    public String moveCommunicate(int oldX, int oldY, int newX, int newY){
        StringBuilder sb = new StringBuilder();
        sb
                .append("move ").append(isWhite ? "white " : "black ").append(this.getClass())
                .append(" from: ").append(oldX).append(' ').append(oldX)
                .append(" to: ").append(newX).append(' ').append(newY);
        return sb.toString();
    }

    public abstract int points();
    public abstract List<int []> getPossibleMoves(boolean [][] freeSpace, boolean [][] opponents);
    //public abstract List<int []> getPossibleSpecialMoves();

}
