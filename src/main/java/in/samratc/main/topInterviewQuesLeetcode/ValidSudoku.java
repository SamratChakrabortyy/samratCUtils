package in.samratc.main.topInterviewQuesLeetcode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVis = new boolean[9][9], colVis = new boolean[9][9], blockVis = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                int val = board[i][j] - '0' - 1, block = (i/3*3) + j/3;
                if(rowVis[i][val] || colVis[j][val] || blockVis[block][val])
                    return false;
                rowVis[i][val] = colVis[j][val] =  blockVis[block][val] = true;
            }
        }
        return true;
    }
}
