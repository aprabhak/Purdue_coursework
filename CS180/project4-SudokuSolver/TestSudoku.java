import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TestSudoku extends TestCase {
    
    private int[][] board;
    
    protected void setUp() throws Exception {
        super.setUp();
        board = new int[9][9];
        String s = "130704856060008002000065000000920005710806023400031000000150000200600080953402061";
        int i = 0;
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
            board[r][c] = Character.getNumericValue((s.charAt(i)));
            i++;
    }
    }
    
    /**
     * A test method.
     * (Replace "X" with a name describing the test.  You may write as
     * many "testSomething" methods in this class as you wish, and each
     * one will be called when running JUnit over this class.)
     */
    public void testBoxBelonged() {
        assertEquals(0,board.boxBelonged(0,0));   
    }
    
}
