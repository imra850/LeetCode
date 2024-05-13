class Solution {
    public int matrixScore(int[][] grid) {
        int Rows = grid.length;
         int   Cols = grid[0].length;
        for (int i = 0; i < Rows; ++i) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < Cols; ++j) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < Cols; ++j) {
            int Count = 0; 
            for (int i = 0; i < Rows; ++i) {
                Count += grid[i][j];
            }
            ans += Math.max(Count, Rows - Count) * (1 << (Cols - j - 1));
        }
        return ans;
    }
}