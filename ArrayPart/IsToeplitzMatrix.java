/**
 *  leetcode 766
 */
public class IsToeplitzMatrix {
    /**
     * 方法一：遍历
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for(int i = 1;i < height;i++){
            for(int j = 1; j<width;j++){
                if(matrix[i][j]!=matrix[i-1][j-1]) return false;
            }
        }
        return true;

    }


    /**
     * 
     */
    public boolean isToeplitzMatrixWithDFS(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        for(int i = 0; i< height; i++){
            if(!dfs(matrix,i,0,matrix[i][0])) return false;            
        }
        for(int j = 1;j<width;j++){
            if(!dfs(matrix,0,j,matrix[0][j])) return false;
        }
        return true;

    }
    private boolean dfs(int[][] matrix, int i, int j, int target){
        if(i>=matrix.length||j>=matrix[0].length) return true;
        if(matrix[i][j]!=target) return false;
        return dfs(matrix,i+1,j+1,target);


    }


    
}
