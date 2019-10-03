package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece{

    //todo en passant
    //todo promotion

    public Pawn(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();
        if(isWhite){
            //moves
            if(yPos + 1 < 8 && freeSpace[xPos][yPos + 1]){
                moves.add(new int []{xPos, yPos});
            }
            if(neverMoved() && freeSpace[xPos][yPos + 2]){
                moves.add(new int []{xPos, yPos + 2});
            }
            //capture
            if(yPos + 1 < 8){
                if(xPos + 1 < 8){
                    if(opponents[xPos + 1][yPos + 1])
                        moves.add(new int []{xPos + 1, yPos + 1});
                }
                if(xPos - 1 >= 0){
                    if(opponents[xPos - 1][yPos + 1])
                        moves.add(new int []{xPos - 1, yPos + 1});
                }
            }
        }else{
            if(yPos - 1 >= 0 && freeSpace[xPos][yPos - 1]){
                moves.add(new int []{xPos, yPos - 1});
            }
            if(neverMoved() && freeSpace[xPos][yPos - 2]){
                moves.add(new int []{xPos, yPos - 2});
            }
            if(yPos - 1 >= 0){
                if(xPos + 1 < 8){
                    if(opponents[xPos + 1][yPos + 1])
                        moves.add(new int []{xPos + 1, yPos - 1});
                }
                if(xPos - 1 >= 0){
                    if(opponents[xPos - 1][yPos + 1])
                        moves.add(new int []{xPos - 1, yPos - 1});
                }
            }
        }

        return moves;
    }

    public boolean neverMoved(){
        if(isWhite){
            return yPos == 1;
        }else{
            return yPos == 6;
        }
    }

    @Override
    public int points() { return 10; }
}
