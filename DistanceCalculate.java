import java.util.Arrays;

/**
 * @author xiaobzhu
 * this class is used to do the calculation for the EditDistance, in this class, it find the minimum distance first, then
 * use the 2D-array method to find the way in the 2D array, then find the least numbers in the 2D-array matrix
 */
public class DistanceCalculate {
    /**
     * this private value is used to set the int value of the rows
     */
    private int rows;
    /**
     * this private value is used to set the int value of the coloms
     */
    private int cols;
    /**
     * this private value is used to set the initial value of the String before that will change to
     */
    private String oriString;
    /**
     * this private value is used to set the value of String will change to another String
     */
    private String fixString;
    /**
     * this private value is used to save the minimum distance
     */
    private int[][] dp;

    /**
     * this is the construtor of this class, in this constructor, it got the Two String pass in, then call the method
     * minDistance
     * @param string is the String value for the initial String value
     * @param string1 is the String value for the need change String value
     */
    public DistanceCalculate(String string, String string1) {
        this.oriString = string;
        this.fixString = string1;
        minDistance(string, string1);
    }

    /**
     * this method is used to calculate the minimum distance between two String, it use the itetative method to do the calculation
     * @param word1 is the String that the initial String
     * @param word2 is the String that need to change
     * @return the int value of the int[][] dp that is the minimum distance for the editdistance
     */
    public int minDistance(String word1, String word2) {

        rows = word1.length() + 1;
        cols = word2.length() + 1;
        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        findPath(dp);
        printPath(dp);
        return dp[rows - 1][cols - 1];
    }

    private void printPath(int[][] path){
        for(int[] aPath: path){
            System.out.println(Arrays.toString(aPath));
        }
    }


    /**
     * this method is used to find the minimum distance that the edit. it used the 2d-array matrix, use a new 2D-array for the int
     * to record the path that edit progress.
     * @param path value pass in, it is the calculated minimum distance from the above method
     */
    private void findPath(int[][] path){
        int row = rows-1;
        int col = cols-1;
        int count = 1;
        int[][] newpath = new int[row+1][col+1];
        while(row>0 && col> 0){
            if(path[row-1][col-1]+1 == path[row][col]){
                newpath[row][col] = path[row][col];
                System.out.println("edit distance: " + count + "--> replace '" + oriString.charAt(row-1) + "' with '" + fixString.charAt(col-1)+"'");
                count++;
                row--;
                col--;
            }else if(path [row-1][col]+1 == path[row][col]){
                newpath[row][col] = path[row][col];
                System.out.println("edit distance: " + count + "--> remove '" + oriString.charAt(row-1) + "' from str1");
                row--;
                count++;

            }else if(path [row][col-1]+1 == path[row][col]){
                newpath[row][col] = path[row][col];
                System.out.println("edit distance: " + count + "--> add '" + fixString.charAt(col-1) + "' to str1");
                count++;
                col--;
            }else if(path [row-1][col-1] == path[row][col]){
                newpath[row][col] = path[row][col];
                row--;
                col--;
            }
        }
        if( row != 0){
            while(row > 0){
                if(path[row][col] == path[row-1][col]+1){
                    newpath[row][col] = path[row][col];
                    System.out.println("edit distance: " + count + "--> remove '" + oriString.charAt(row-1) + "' to str1");
                    count++;
                    row--;
                }
            }
        }
        if( col != 0){
            while(col > 0){
                if(path[row][col] == path[row][col-1]+1){
                    newpath[row][col] = path[row][col];
                    System.out.println("edit distance: " + count + "--> add '" + fixString.charAt(col-1) + "' to str1");
                    count++;
                    col--;
                }
            }
        }
       // printPath(newpath);
    }

}