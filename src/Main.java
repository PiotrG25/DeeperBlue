import chess_pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> chessPieces = new ArrayList<>();
        setupBoard(chessPieces);
        
    }

    private static int maximizingMove(List<ChessPiece> chessPieces, int points, int lvl){
        boolean [][] freeSpace = getFreeSpace(chessPieces);
        int max = -999_999; // white player is maximizing
        String maxCommunicate = "UwU";
        boolean [][] black = getBlack(chessPieces);

        for(ChessPiece cp : chessPieces){
            List<int []> moves = cp.getPossibleMoves(freeSpace, black);
            int xStart = cp.getXPos(), yStart = cp.getYPos();

            List<ChessPiece> chessPieces2 = new ArrayList<>();
            chessPieces2.addAll(chessPieces);

            for(int [] m : moves){

                cp.setPosition(m[0], m[1]);
                // if captured
                ChessPiece captured = findCaptured(chessPieces2, false, m[0], m[1]);
                if(captured != null){
                    chessPieces2.remove(captured);
                    points += captured.points();
                }

                int someValue;
                if(lvl <= 1){
                    someValue = points;
                }else{
                    someValue = minimizingMove(chessPieces2, points, lvl - 1);
                }

                if(someValue > max){
                    max = someValue;
                    maxCommunicate = cp.moveCommunicate(xStart, yStart, m[0], m[1]);
                }

                if(captured != null){
                    chessPieces2.add(captured);
                    points -= captured.points();
                }
                cp.setPosition(xStart, yStart);
            }
        }
        if(lvl <= 1)
            System.out.println("lvl " + lvl + " " + maxCommunicate);
        return max;
    }
    private static int minimizingMove(List<ChessPiece> chessPieces, int points, int lvl) {
        boolean [][] freeSpace = getFreeSpace(chessPieces);
        int min = 999_999; // black player is minimizing
        String minCommunicate = "UwU";
        boolean [][] white = getWhite(chessPieces);

        for(ChessPiece cp : chessPieces){
            if(cp.isWhite()) continue;
            List<int []> moves = cp.getPossibleMoves(freeSpace, white);
            int xStart = cp.getXPos(), yStart = cp.getYPos();

            List<ChessPiece> chessPieces2 = new ArrayList<>();
            chessPieces2.addAll(chessPieces);

            for(int [] m : moves){

                cp.setPosition(m[0], m[1]);
                // if captured
                ChessPiece captured = findCaptured(chessPieces2, true, m[0], m[1]);
                if(captured != null){
                    chessPieces2.remove(captured);
                    points -= captured.points();
                }

                int someValue;
                if(lvl <= 1){
                    someValue = points;
                }else{
                    someValue = minimizingMove(chessPieces2, points, lvl - 1);
                }

                if(someValue < min){
                    min = someValue;
                    minCommunicate = cp.moveCommunicate(xStart, yStart, m[0], m[1]);
                }

                if(captured != null){
                    chessPieces2.add(captured);
                    points += captured.points();
                }
                cp.setPosition(xStart, yStart);
            }
        }
        if(lvl <= 1)
            System.out.println("lvl " + lvl + " " + minCommunicate);
        return min;
    }
    private static int moveAndDecide(List<ChessPiece> chessPieces, boolean maxi, int points, int lvl){
        //todo basic cases
        //todo divide into 2 methods for white and black player
        return 0;
    }

    private static ChessPiece findCaptured(List<ChessPiece> chessPieces, boolean isWhite, int x, int y){
        for(ChessPiece c : chessPieces){
            if(c.isWhite() == isWhite && c.getXPos() == x && c.getYPos() == y){
                return c;
            }
        }
        return null;
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
