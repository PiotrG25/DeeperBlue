package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece{


    public Knight(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();
        int [][] arr = {
                {xPos - 2, yPos - 1},
                {xPos - 2, yPos + 1},

                {xPos + 2, yPos - 1},
                {xPos + 2, yPos + 1},

                {xPos - 1, yPos - 2},
                {xPos + 1, yPos - 2},

                {xPos - 1, yPos + 2},
                {xPos + 1, yPos + 2}
        };
        for(int i = 0; i < arr.length; i++){
            if(0 <= arr[i][0] && arr[i][1] < 8 && (freeSpace[arr[i][0]][arr[i][1]] || opponents[arr[i][0]][arr[i][1]])){
                moves.add(arr[i]);
            }
        }
        return moves;
    }

    @Override
    public int points() {
        return 25;
    }
}
