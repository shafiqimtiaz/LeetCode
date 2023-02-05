import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(String[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String number = board[i][j];
                if (!number.equals(".")) {
                    if (!seen.add(number + " row " + i) ||
                            !seen.add(number + " column " + j) ||
                            !seen.add(number + " block " + i / 3 + "-" + j / 3)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[][] input = new String[][]{{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}, {
                ".", "9", "8", ".", ".", ".", ".", "6", "."}, {"8", ".", ".", ".", "6", ".", ".", ".", "3"}, {
                "4", ".", ".", "8", ".", "3", ".", ".", "1"}, {"7", ".", ".", ".", "2", ".", ".", ".", "6"}, {
                ".", "6", ".", ".", ".", ".", "2", "8", "."}, {".", ".", ".", "4", "1", "9", ".", ".", "5"}, {
                ".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        System.out.println(isValidSudoku(input));
    }
}
