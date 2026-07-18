class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[0].length; j++) {
        //         if(matrix[i][j] == target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        int m = matrix[0].length;
        int j = m-1;
        int i = 0;

        while(i<matrix.length && j >= 0) {

            if(matrix[i][j] == target) {
                return true;
            } 

            if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }


            
            // i++;
        }
        

        return false;
        
    }
}