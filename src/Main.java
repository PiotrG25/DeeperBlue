import chess_pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> chessPieces = new ArrayList<>();
        setupBoard(chessPieces);

        chessPieces.remove(null);

        boolean [][] white = getWhite(chessPieces), black = getBlack(chessPieces), freeSpace = getFreeSpace(chessPieces);
        for(boolean [] c : white){
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
        for(boolean [] c : black){
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
        for(boolean [] c : freeSpace){
            System.out.println(Arrays.toString(c));
        }

    }

    private static int moveAndDecide(List<ChessPiece> chessPieces, boolean maxi, int points, int lvl){
        //todo basic cases
        //todo divide into 2 methods for white and black player
        boolean [][] freeSpace = getFreeSpace(chessPieces);
        if(maxi){
            int max = -999_999;
            // white player is maximizing
            boolean [][] black = getBlack(chessPieces);

            for(ChessPiece cp : chessPieces){
                List<int []> moves = cp.getPossibleMoves(freeSpace, black);
                int xStart = cp.getXPos(), yStart = cp.getYPos();

                for(int [] m : moves){

                    cp.setPosition(m[0], m[1]);

                    if(black[m[0]][m[1]]){
                        ChessPiece captured = null;
                        // find captured
                        for(ChessPiece c : chessPieces){
                            if(!c.isWhite() && c.getXPos() == m[0] && c.getYPos() == m[1]){
                                captured = c;
                                break;
                            }
                        }
                        chessPieces.remove(captured);

                        int someValue = moveAndDecide(chessPieces, !maxi, points, lvl - 1);
                        if(someValue > max){
                            max = someValue;
                        }

                        chessPieces.add(captured);
                        cp.setPosition(xStart, yStart);
                    }else{

                        int someValue = moveAndDecide(chessPieces, !maxi, points, lvl - 1);
                        if(someValue > max){
                            max = someValue;
                        }
                        cp.setPosition(xStart, yStart);
                    }

                }
            }

            return max;
        }else{
            int min = 999_999;
            // black player is minimizing
            boolean [][] white = getWhite(chessPieces);

            for(ChessPiece cp : chessPieces){
                List<int []> moves = cp.getPossibleMoves(freeSpace, white);
                int xStart = cp.getXPos(), yStart = cp.getYPos();

                for(int [] m : moves){

                    cp.setPosition(m[0], m[1]);

                    if(white[m[0]][m[1]]){
                        ChessPiece captured = null;
                        // find captured
                        for(ChessPiece c : chessPieces){
                            if(c.isWhite() && c.getXPos() == m[0] && c.getYPos() == m[1]){
                                captured = c;
                                break;
                            }
                        }
                        chessPieces.remove(captured);

                        int someValue = moveAndDecide(chessPieces, !maxi, points, lvl - 1);
                        if(someValue < min){
                            min = someValue;
                        }

                        chessPieces.add(captured);
                        cp.setPosition(xStart, yStart);
                    }else{

                        int someValue = moveAndDecide(chessPieces, !maxi, points, lvl - 1);
                        if(someValue < min){
                            min = someValue;
                        }
                        cp.setPosition(xStart, yStart);
                    }
                }
            }
            return min;
        }
    }

    private static void setupBoard(List<ChessPiece> chessPieces){
        for(int i = 0; i < 8; i++){
            chessPieces.add(new Pawn(i, 1, true));
            chessPieces.add(new Pawn(i, 6, false));
        }
        chessPieces.add(new Rook(0, 0, true));
        chessPieces.add(new Rook(7, 0, true));
        chessPieces.add(new Rook(0, 7, false));
        chessPieces.add(new Rook(7, 7, false));

        chessPieces.add(new King(1, 0, true));
        chessPieces.add(new King(6, 0, true));
        chessPieces.add(new King(1, 7, false));
        chessPieces.add(new King(6, 7, false));

        chessPieces.add(new Bishop(2, 0, true));
        chessPieces.add(new Bishop(5, 0, true));
        chessPieces.add(new Bishop(2, 7, false));
        chessPieces.add(new Bishop(5, 7, false));

        chessPieces.add(new Queen(3, 0, true));
        chessPieces.add(new Queen(3, 7, false));

        chessPieces.add(new King(4, 0, true));
        chessPieces.add(new King(4, 7, false));
    }
    private static boolean [][] getWhite(List<ChessPiece> chessPieces){
        boolean [][] white = new boolean [8][8];
        for(ChessPiece cp : chessPieces){
            if(cp.isWhite()){
                white[cp.getXPos()][cp.getYPos()] = true;
            }
        }
        return white;
    }
    private static boolean [][] getBlack(List<ChessPiece> chessPieces){
        boolean [][] black = new boolean [8][8];
        for(ChessPiece cp : chessPieces){
            if(!cp.isWhite()){
                black[cp.getXPos()][cp.getYPos()] = true;
            }
        }
        return black;
    }
    private static boolean [][] getFreeSpace(List<ChessPiece> chessPieces){
        boolean [][] white = getWhite(chessPieces), black = getBlack(chessPieces);
        boolean [][] freeSpace = new boolean [8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(!white[i][j] && ! black[i][j]){
                    freeSpace[i][j] = true;
                }
            }
        }
        return freeSpace;
    }
}
