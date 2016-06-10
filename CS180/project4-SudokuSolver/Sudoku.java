public class Sudoku {
    private int[][] board = new int[9][9];
    
    public Sudoku() {
        for (int r = 1; r < 10; r++) {
            for (int c = 1; c < 10; c++) {
                board[r-1][c-1] = 0;
            }
        }
    }
    
    public Sudoku(int[][] board) {
        this.board = board;
    }
    
    public int[][] board() {
        return board;
    }
    
    public int boxBelonged(int row, int column) {
        int box = 3*(row/3) + (column/3);
        return box;
    }
    
    public boolean[] candidates(int row, int column) {
        boolean[] digit = new boolean[10];
        digit[0] = false;
        for (int d = 1; d <= 9; d++) {
            digit[d] = true;
        }
        for (int r = 0; r < 9; r++) 
            if (board[r][column] != 0) {
            digit[board[r][column]] = false;
        }
        
        for (int c = 0; c < 9; c++)
            if (board[row][c] != 0) {
            digit[board[row][c]] = false;
        }
        
        int n = boxBelonged(row,column);
        int r = 3 * (n/3);
        int c = 3 * (n%3);
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] != 0 ) {
                    digit[board[i][j]] = false;
                }
                
            }
        }
        
        return digit;
    }
    
    public boolean isSolved() {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
            if (board[r][c] == 0)
                return false;
            
        }
        return true;
    }
    
    public boolean nakedSingles() {
        int lastNumber = 0;
        int count = 0;
        int numberPlaced = 0;
        
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
            boolean[] candidateNumber = (candidates(r,c));
            for (int d = 1; d < 10; d++) {
                
                
                if (candidateNumber[d] == true) {
                    count++;
                    lastNumber = d;
                }
                
                
            }
            if ((count == 1) && (board[r][c] == 0)) {
                board[r][c] = lastNumber;
                count = 0;
                numberPlaced++;
            }
            
            
            
        }
        if (numberPlaced > 0)
            return true;
        else 
            return false;
    }
    public boolean hiddenSingles() {
       /* public hiddenSingleRow(int row) {
            for (int c = 0; c < 9; c++) {
                boolean[] a = (candidates(row,c));
                for (int i = 1; i < 10; i++) {
                    if((a[i] == true)) {
                        occur[i] = occur[i]++
                            posn[i] = c;
                        for (i = 0; i <10; i++) {
                            if (occur[i] == 1) {
                                board[row][posn[i]] = i;
                            }
                        }
                    }
                }
            }
        }
        
        
    }*/
        int numberPlaced = 0;
        System.out.println("hiddenSingles method");
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
            boolean[] a = (candidates(r,c)).clone();
            int count = 0;
            int count1 = 0;
            int count2 = 0;
            
            int candidateLeft = 0;
            for (int column = 0; column < 9; column++) {
                if (column == c)
                    continue;
                
                
                boolean[] b = (candidates(r,column));
                for (int d = 0; d < 9; d++) {
                    if ((a[d] == true) && (b[d] == true)) 
                        a[d] = false;
                }
                
                for (int e = 0; e < 9; e ++) {
                    if (a[e] == true) {
                        count++;
                        candidateLeft = e + 1;
                    }
                    
                    
                }
            }
            
            if (count == 1) {
                board[r][c] = candidateLeft;
                return true;
            } else {
                
                for (int row = 0; row < 9; row++) {
                    if (row == r)
                        continue;
                    boolean[] k = (candidates(row,c)).clone();
                    for (int f = 0; f < 9; f++) {
                        if ((a[f] == true) && (k[f] == true))
                            a[f] =false;
                    }
                    for (int g = 0; g < 9; g++) {
                        if (a[g] == true) {
                            count1++;
                            candidateLeft = g + 1;
                        }
                        
                        
                        
                    }
                }
                if (count1 == 1) {
                    board[r][c] = candidateLeft;
                    return true;
                    
                } else {
                    int n = boxBelonged(r,c);
                    int row = 3 * (n/3);
                    int col = 3 * (n%3);
                    for (int i = row; i < row + 3; i++) {
                        for (int j = col; j < col + 3; j++) {
                            if ((r == i) && c == j) {
                                continue;
                            }
                                boolean[] o = (candidates(i,j)).clone();
                                for (int t = 0; t < 9; t++) {
                                    if ((a[t] == true) && (o[t] == true)) {
                                        a[t] = false;
                                    }
                                    for (int q = 0; q < 9; q++) {
                                        if (a[q] == true) {
                                            count2++;
                                            candidateLeft = q + 1;
                                        }
                                    }
                                }
                                if (count2 == 1) {
                                    board[r][c] = candidateLeft;
                                    return true;
                                }
                            }
                        
                    }   
                }
            }
        }
        if (numberPlaced > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    

    public static int[][] translate(String s) {
        int[][] init = new int[9][9];
        int i = 0;
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
            init[r][c] = Character.getNumericValue((s.charAt(i)));
            i++;
        }
        return init;
        
    }
    public void solve() {
        while (!isSolved() && (nakedSingles()) || (hiddenSingles()))
            boardPrint();
    }
    
    
    
    
    public void boardPrint() {
        
        for (int j = 1; j < 10; j++) {
            if ( j == 1) {
                System.out.print("   " + j);
            } else {
                System.out.print("  " + j);
            }
            
        }
        System.out.println();
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
            if (c == 0) {
                if (board[r][c] == 0) {
                    System.out.print(Character.toString ((char) (r + 65)) + "   ");
                } else {
                    System.out.print(Character.toString ((char) (r + 65)) + "  " + board[r][c]);
                }
            }
            
            
            else if (c == 8) {                
                if (board[r][c] == 0) {
                    System.out.print("   ");
                    System.out.println();
                } else { 
                    System.out.print("  " + board[r][c]);
                    System.out.println();
                    
                }
            }  else {
                if (board[r][c] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print("  " + board[r][c]);
                }
            }
            
        }
        
        
        
    }
    public static void main(String args[]) {
        String s = "000079065000003002005060093340050106000000000608020059950010600700600000820390000";
        int[][] board = Sudoku.translate(s);
        Sudoku sdk = new Sudoku(board); 
        sdk.boardPrint();
        sdk.solve();
        
    }        
}