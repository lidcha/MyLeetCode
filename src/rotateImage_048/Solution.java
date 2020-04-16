package rotateImage_048;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Solution {
    public int[][] rotate(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int j=0,k=matrix[i].length-1;
            while(j<=k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;k--;
            }
        }
        return matrix;
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{ {1,2,3},{4, 5, 6},{7, 8, 9}};
        int[][] excepted = new int[][]{{7, 4, 1},{8, 5, 2},{9, 6, 3}};
        assertEquals(excepted, new Solution().rotate(matrix));
    }
}
