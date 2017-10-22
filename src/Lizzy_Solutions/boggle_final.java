import java.io.*;
import java.util.*;

public class boggle_final {
        public static int count = 0;

    public static void main(String[] args) {
        

        BoardSquare[][] thisBoard = new BoardSquare[4][4];
        
        for (int row = 0; row < thisBoard.length; row++) {
            for (int col = 0; col < thisBoard[row].length; col++) {
                thisBoard[row][col] = new BoardSquare();
                String n = "x";
                char a = n.charAt(0);
                switch (row) {
                    case 1: a = findLetter(col); 
                        break;
                    default: 
                }
                
                thisBoard[row][col].setLetter(a);
                //System.out.println(thisBoard[row][col].getLetter());
                
            }
        }
        
       
        
        String word = "sand";
        // or whatever word you want
        boolean exists = search(thisBoard, word);
        if (exists) {
            System.out.println("word exists");
        } else {
            System.out.println("sorry, word does not exist in this board");
        }

        String info = "";
        for (int row = 0; row < thisBoard.length; row++ ) {
            for (int col = 0; col < thisBoard[row].length; col++) {
                info += thisBoard[row][col].getLetter();
            }
            info += "\n";
        }
        System.out.println("board was\n" + info);

    }
    
    private static char findLetter(int col) {
        String a = "x";
        switch (col) {
            case 0 : a = "d"; break;
            case 1 : a = "n"; break;
            case 2 : a = "a"; break;
            case 3 : a = "s"; break;
            default : a = "x"; break;
            
        }
        return a.charAt(0);
    }

    private static boolean search(BoardSquare[][] board, String word) {
        boolean exists = false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (!exists) {
                    if (board[row][col].getLetter() == word.charAt(0)) {
                        System.out.println("found first letter at " + row + ", " + col);
                        exists = search(board, word, row, col, 0);
                    }
                }
            }
        }
        return exists;
    }

    private static boolean search(BoardSquare[][] board, String word, int row, int col, int count) {
        count++;
        boolean exists = false;
        System.out.println(count + "th iteration, coordinates are " + row + ", " + col);
        
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col].isUsed()) {
            return false;
        } else if (word.length() == 0) {
            return true;
        } else if (word.charAt(0) != board[row][col].getLetter()) {
            System.out.println("letter at " + count + "th iteration, coordinates " + row + ", " + col +
            "; letter is: " + board[row][col].getLetter() + " - does not match search char " + word.charAt(0)
            + "; returning false.");
            return false;
        } else {
            exists = (word.charAt(0) == board[row][col].getLetter());
            board[row][col].setUsed(true);
            System.out.println("match found at " + row + ", " + col + "; search query was " + word.charAt(0));
            if (exists) {
                 exists = ((word.charAt(0) == board[row][col].getLetter()) &&
                 (search(board, word.substring(1), row + 1, col + 1, count)) || 
                 search(board, word.substring(1), row, col + 1, count) || 
                 search(board, word.substring(1), row + 1, col, count) || 
                 search(board, word.substring(1), row - 1, col - 1, count) || 
                 search(board, word.substring(1), row + 1, col - 1, count) || 
                 search(board, word.substring(1), row - 1, col + 1, count) || 
                 search(board, word.substring(1), row, col - 1, count) || 
                 search(board, word.substring(1), row - 1, col, count));
                
                
            }
        }
        return exists;
/*
        return exists;

        for (int rowDiff = -1; rowDiff < 2; rowDiff++) {
            for (int colDiff = -1; colDiff < 2; colDiff++) {

            }
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col].isUsed() || word.charAt(0) != board[row][col].getLetter()) {
            return exists;
        } else if (word.length = 0) {
            if (word.length > 0) {
                board[row][col].setUsed(true);
            exists = true;
            return exists;
        } else {
            exists = search(board, word.substring(1), row + rowDiff, col + colDiff);
        }
    }
*/

    }


private static class BoardSquare {

    private char letter;
    private boolean isUsed = false;

    public void BoardSquare() {
        Random r = new Random();
        letter = (char)(r.nextInt(26) + 'a');
        // System.out.println(r);
    }
    

    public char getLetter() {
        return letter;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
    
    public boolean isUsed() {
        return isUsed;
    }
    
    public void setLetter(char a) {
        letter = a;
    }

}  
  
}
//new String(letters, 1, letters.length - 1)
