/**
 * leetcode 73
 * 
 * 
 */
class SetZeros{
    /**
     * 使用额外的空间
     *  Time:O(m*n)
     *  Space:O(m+n)
     * @param matrix
     */
    public void setZeroes(int[][] matrix){
         // 通过容器存储需要被置换的行和列
         Set<Integer> columnSet = new HashSet<>();
         Set<Integer> rowSet = new HashSet<>();
       
         int m = matrix.length;
         int n = matrix[0].length;
         for(int i = 0;i<m;i++){
             for(int j = 0;j<n;j++){
                 if(matrix[m][n]==0){
                     columnSet.add(n);
                     rowSet.add(m);
                 }
             } 
         }
         // 通过set的数据去置换
         for (int val : columnSet) {
             for(int i = 0;i<m;i++){
                 matrix[i][val]=0;
             }
             
         }
         for(int val : rowSet){
             for(int i = 0;i<n;i++){
                 matrix[val][i]=0;
             }
         }
    }

   /**
    * 不使用额外的空间 遍历到之后不存，而是在原地做标记
    * @param matrix
    */
    public static void setZerosSimple(int[][] matrix){
        boolean rowSet = false;
        boolean colSet = false;
        // 判断第一行和第一列要不要变成 0 
        if(matrix[0][0]==0){
            // 第一行 第一列都得变成0 ，但是通过变量延迟变化
            rowSet = true;
            colSet = true;
        }else{
            for(int row = 0;row<matrix.length;row++){
                if(matrix[row][0]==0){
                    rowSet = true;
                    break;
                }

            }
            for(int col = 0;col<matrix[0].length;col++){
                if(matrix[0][col]==0){
                    colSet = true;
                    break;
                }

            }

        }

        // 如果其他行或者列需要变成0，用 第一行或者第一列来做记号
        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 通过头部是否是0，来将行和列 变为 0
        // for(int row = 0;row<matrix.length;row++){
        //     for(int col = 0;col<matrix[0].length;col++){
        //         if(matrix[row][0]==0||matrix[0][col]==0){
        //             matrix[row][col] = 0;
        //         }
        //     }
        // }
        for (int row = matrix.length-1; row >= 0; row--) {
            for (int col = matrix[0].length-1; col >=0 ; col--) {
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }

        // 第一行 第一列 判断

        if(rowSet){
            for(int i = 0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        if(colSet){
            for(int i = 0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }


    }
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZerosSimple(matrix);
    }
}