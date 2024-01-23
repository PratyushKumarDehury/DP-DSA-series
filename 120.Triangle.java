Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?








class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        // minimum path sum in a triangle
        // Bottom-up Approach
        int N = triangle.size();
        for(int row = N-2; row >= 0; row--){
            List<Integer> currRow = triangle.get(row);
            List<Integer> prevRow = triangle.get(row+1);
            for(int col = 0; col < row+1; col++){
                int downleft = prevRow.get(col);
                int downright = prevRow.get(col+1);

                currRow.set(col, Math.min(downleft,downright) + currRow.get(col));
            }
        }
        return triangle.get(0).get(0);
    }
}

// T.C -> O(n^2)
// S.C -> O(n^2)

 
