package leetcode.DymicProgramming.medium.array_matrix;

/**
 * Created by Administrator on 2016/7/28.
 */
/*
   题意：给定一个矩阵，以及两组值，（row1，col1），（row2，col2），计算从row1，col1 到row2，col2组成的区域的所有元素的和
         如：Given matrix = [
               [3, 0, 1, 4, 2],
               [5, 6, 3, 2, 1],
               [1, 2, 0, 1, 5],
               [4, 1, 0, 1, 7],
               [1, 0, 3, 0, 5]
             ]
           sumRegion(2, 1, 4, 3) -> 8
           sumRegion(1, 1, 2, 2) -> 11
           sumRegion(1, 2, 2, 4) -> 12
   思路：sumRegion(row1,col1,row2,col2) = (0,0,row2,col2) - (0,0,row1 - 1,col2) - (0,0,row2,col1 - 1) + (0,0,row1 - 1,col1 - 1);
         其实就是找规律了
         首先改变矩阵每个元素的值，其实就是每个点的值为以(0,0)为左上角，以该点为右下角的全部和，然后套公式
 */
public class OJ_304RangeSumQuery2D {
    int[][] subMatrix;
    public OJ_304RangeSumQuery2D(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        subMatrix = new int[row][col];
        subMatrix[0][0] = matrix[0][0];
        //第一行
        for(int i = 1;i < subMatrix.length;i++){
            subMatrix[0][i] = subMatrix[0][i-1] + matrix[0][i];
        }
        //第一列
        for(int j = 1;j < subMatrix[0].length;j++){
            subMatrix[j][0] = subMatrix[j-1][0] + matrix[j][0];
        }
        for(int i = 1;i < subMatrix.length;i++){
            for(int j = 1;j < subMatrix.length;j++){
                subMatrix[i][j] = subMatrix[i - 1][j] + subMatrix[i][j - 1] - subMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return subMatrix[row2][col2] - subMatrix[row1 - 1][col2] - subMatrix[row2][col1 - 1] + subMatrix[row1 - 1][col1 - 1];
    }
}
