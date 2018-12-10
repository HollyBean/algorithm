/**
 * 描述：
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 * 思路：
 * 因为数组是从左到右递增，从上到下递增，如果按照这种顺序来解题，
 * 每次都需要选择两个分支(即target > array[row][column] => row++ / column++)，
 * 但是转变一下思路，从左下角开始，则可每次只有一个分支(即target > array[row][column] => column++
 * 或者　target < array[row][column] => row--);

 * Result:
 * 3 is in array ? false
 * 3 is in arrayA ? true
 * 3 is in arrayb ? false
 *
 */

public class findInTwoDemensionalArray {
    public static void main(String[] args) {
        int[][] arrayA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[][] arrayB = {
                {1, 5, 9},
                {2, 4, 8},
        };
        int[][] array = {};
        Boolean isInArr = Solution.find(3, array);
        System.out.println("3 is in array ? " + isInArr);
        Boolean isInArrA = Solution.find(3, arrayA);
        System.out.println("3 is in arrayA ? " + isInArrA);
        Boolean isInArrB = Solution.find(3, arrayB);
        System.out.println("3 is in arrayb ? " + isInArrB);

    }

    public static class Solution {
        public static Boolean find(int target, int[][] array) {
            if (null == array) {
                return false;
            }

            int row = array.length - 1;
            int column = 0;

            while (row >= 0 && column <= array[0].length - 1) {
                if (target > array[row][column]) {
                    column ++;
                }else if (target < array[row][column]) {
                    row --;
                }else{
                    return true;
                }
            }

            return false;
        }
    }
}
