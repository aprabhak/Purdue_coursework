/**
 * CS 180 - Project 03 - RiverCrossingPuzzle
 * 
 * implement the river crossing puzzle and 
 * handle the underlying details of solving the puzzle using user interaction.
 * 
 * @author Avinash Prabhakar aprabhak@purdue.edu
 * 
 * @lab (Your lab section)
 *
 * @date 10/14/2014
 */
import java.util.Scanner;

public class RiverCrossingPuzzle {
    int numEach;
    int boatSize;
    int mil;
    int mir;
    int canl;
    int canr;
    boolean boatl;
    boolean boatr;
    int tm;
    int stat;
    char ch;
    String str;
    
    
    public static void main(String[] args) {
        int n = 0; 
        int b = 0;
        if(args.length == 0) {
            n = 3;
            b = 2;
        }
        else if(args[0].equals("-n") && args[2].equals("-b")) {
            n = Integer.parseInt(args[1]);
            b = Integer.parseInt(args[3]); 
        }
        else if(args[0].equals("-b") && args[2].equals("-n")) {
            b = Integer.parseInt(args[1]);
            n = Integer.parseInt(args[3]);
        }
        RiverCrossingPuzzle r = new RiverCrossingPuzzle(n, b);
        r.play();
    }
    
    public RiverCrossingPuzzle(int numEach, int boatSize) {
        this.numEach = numEach;
        this.boatSize = boatSize;
        mil = numEach;
        mir = 0;
        canl = numEach;
        canr = 0;
        boatl = true;
        boatr = false;
        tm = 0;
        stat = 0;
        
    }
    
    public int numMissionariesOnLeftBank() {
        return mil;
    }
    
    public int numMissionariesOnRightBank() {
        return mir;
        
    }
    
    public int numCannibalsOnLeftBank() {
        return canl;
    }
    
    public int numCannibalsOnRightBank() {
        return canr;
    }
    
    public boolean boatOnLeftBank() {
        return boatl;
    }
    
    public boolean boatOnRightBank() {
        return boatr;
    }
    
    public String availableActions() {
        String act = "\n";
        return act;
    }
    
    public void move(int numCannibalsToMove, int numMissionariesToMove) {
        if (numCannibalsToMove + numMissionariesToMove <= 1) {
            return;
        }
        if (numCannibalsToMove + numMissionariesToMove > boatSize) {
            return;
        }
        if (boatl) {
            if (mil > numMissionariesToMove && canl > numCannibalsToMove) {
            mil = mil - numMissionariesToMove;
            mir = mir + numMissionariesToMove;
            canl = canl - numCannibalsToMove;
            canr = canr + numCannibalsToMove;
            boatr = true;
            tm++;
            }
        } else {
            if (mir > numMissionariesToMove && canr > numCannibalsToMove) {
            mir = mir - numMissionariesToMove;
            mil = mil + numMissionariesToMove;
            canr = canr - numCannibalsToMove;
            canl = canl + numCannibalsToMove;
            boatl = false;
            tm++;
            }
        }
    }
    
    public int totalMoves() {
        return tm;
    }
    
    public void reset() {
        mil = numEach;
        mir = 0;
        canl = numEach;
        canr = 0;
        boatl = true;
        boatr = false;
        tm = 0;
        stat = 0;
    }
    
    public int status() { 
        if (mil == 0 && canl == 0)
            return 1;
        
        if (canl > mil || canr > mir) {
            return -1;
        }
        
        return 0;
    }
    
    
    public void play() {
        Scanner s = new Scanner(System.in);
        String str;
        while (status() == 0) {
            System.out.println(puzzleState());
            System.out.println(prompt());
            int i = 0;
            int[] m = new int[2];
            while(i < 2 && s.hasNextInt()) { 
                m[i] = s.nextInt();
                i++;
            }
            int c = m[0];
            int mi = m[1];                  
            move(c,mi);
        }
            if(status() == -1) {
                System.out.println("you lose. Play again? (yes,no)");
                str = s.next();
                if (str.equals("yes")) {
                    play();
                } else {
                    return;
                }
            }
            if (status() == 1) {
                return;
            }
        }
                    
         
    /**
     * 
     *  ***DO NOT CHANGE THIS FUNCTION.***
     * @return String containing the prompt for user input
     */
    public String prompt() {
        String str = "";
        str += "Available Actions\n";
        str += availableActions();
        str += "Action: ";
        return str;
    }
    
    /**
     * ***DO NOT CHANGE THIS FUNCTION.***
     * @return state of left (starting) bank as a String
     */
    private String leftBank() {
        String str = "";
        for (int i = 0; i < numCannibalsOnLeftBank(); i++)
            str += "C";
        str += " ";
        for (int i = 0; i < numMissionariesOnLeftBank(); i++)
            str += "M";
        str += " ";
        if (boatOnLeftBank())
            str += "B";
        return str;
    }
    
    /**
     *  ***DO NOT CHANGE THIS FUNCTION.***
     * @return state of right (ending) bank as a String
     */
    private String rightBank() {
        String str = "";
        if (boatOnRightBank())
            str += "B ";
        for (int i = 0; i < numCannibalsOnRightBank(); i++)
            str += "C";
        str += " ";
        for (int i = 0; i < numMissionariesOnRightBank(); i++)
            str += "M";
        return str;
    }
    
    public String toString() {
        return leftBank() + " | " + rightBank();
    }
    
    /**
     *  ***DO NOT CHANGE THIS FUNCTION.***
     * @return String representation of current state of puzzle
     */
    private String puzzleState() {
        String lb = leftBank();
        String rb = rightBank();
        String str = "\n";
        str += "Left Bank";
        for (int i = 9; i < lb.length(); i++)
            str += " ";
        str += " | ";
        for (int i = lb.length() + 3; i < lb.length() + rb.length() + 3 - 10; i++)
            str += " ";
        str += "Right Bank";
        str += "\n";
        str += lb;
        for (int i = lb.length(); i < 9; i++)
            str += " ";
        str += " | ";
        for (int i = rb.length() - 10; i < 0; i++)
            str += " ";
        str += rb;
        str += "\n";
        str += "\n";
        str += "   Cannibals on left,right banks: ";
        str += String.format("%3d,%3d", numCannibalsOnLeftBank(), numCannibalsOnRightBank());
        str += "\n";
        str += "Missionaries on left,right banks: ";
        str += String.format("%3d,%3d", numMissionariesOnLeftBank(), numMissionariesOnRightBank());
        str += "\n";
        str += "\n";
        str += "Number of moves: " + totalMoves();
        str += "\n";
        return str;
    }
}