package com.shark.newcoder;

/**
 * Created by qinghualiu on 2017/2/26.
 * <p>
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 */
public class MinValue {
    /**
     *
     * 二分搜索有两种形式：
     *    1.如果抛弃中间元素，即 left=mid+1或是right=mid-1，则一般终止条件是  left<=right
     *    2.如果不抛弃中间元素，即 left=mid或是right=mid，则一般终止条件是 left<right 且在内部有  left == right-1 则break
     * 总共三种情况： 最小值在左边，最小值在右边，最小值在 中间
     * 思路： 由于 循环有序，则 arr[mid] 至少要比左右 任意一边要小
     * 1.如果 arr[mid] < arr[left], right = mid-1,走左边
     * 2.如果 arr[mid] > arr[right]，left = mid+1，走右边
     * 3.不是以上两种情况，只能走遍历 （left<right）
     *
     * @param arr
     * @param n
     * @return
     */
    public int getMin(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            if (low == high - 1) {
                break;
            }
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            mid = (low + high) / 2;
            if (arr[low] > arr[mid]) {
                high = mid;
                continue;
            }
            if (arr[mid] > arr[high]) {
                low = mid;
                continue;
            }
            while (low < mid) {
                if (arr[low] == arr[mid]) {
                    low++;
                } else if (arr[low] < arr[mid]) {
                    return arr[low];
                } else {
                    high = mid;
                    break;
                }
            }
        }
        return Math.min(arr[low], arr[high]);
    }


    public static void main(String[] args) {
        MinValue mv = new MinValue();
        //1,2,3,3,4
        int[] arr = {4, 1, 2, 3, 3};
        //int[] arr = {1,2,3,3,4};
        //int[] arr = {3,3,4,1,2};
        //int[] arr = {4,1,2,3,3};
        //int[] arr = {2,3,3,4,1};
        //int[] arr = {1,1,1,1};
        //int[] arr = {3,4,1,2,3};

        System.out.print(mv.getMin(arr, arr.length));
    }
}














