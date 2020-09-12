import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Test
public class MinesweeperTest {

    public void testCase0() throws IOException {
        generateBoardTest(0);
    }

    public void testCase1() throws IOException {
        checkMoveTest(1);
    }
    

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }

    private int readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        int n = Integer.parseInt(lines.get(0));
        return n;
    }

    private List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    private void generateBoardTest(int i) throws IOException {
        int n = readInput(i);
        List<String> expectedOutput = readOutput(i);
        int[][] board = Minesweeper.generateBoardStatic(n);
        List<String> output = new ArrayList<String>();
        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                output.add(String.valueOf(board[row][column]));
            }
        }

        Assert.assertEquals(output, expectedOutput);
    }


    private void checkMoveTest(int i) throws IOException {
        int n = readInput(i);
        List<String> expectedOutput = readOutput(i);
        int[][] board = Minesweeper.generateBoardStatic(3);
        boolean out = Minesweeper.checkMove(board, n%10, n/10);
        List<String> output = new ArrayList<String>();
        output.add(String.valueOf(out));
        Assert.assertEquals(output, expectedOutput);
    }
    
}
