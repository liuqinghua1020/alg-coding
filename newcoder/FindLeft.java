package com.shark.newcoder;

/**
 * Created by qinghualiu on 2017/3/19.
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。

 给定有序数组arr及它的大小n，请返回所求值。

 测试样例：
 [-1,0,2,3],4
 返回：2
 */
public class FindLeft {
    /**
     * 思路：
     *     采用二分搜索：
     *     1. mid = left+((right-left)/2);
     *     2. 如果 arr[mid]=mid,记录返回值result=mid,right=mid-1，继续在左半边寻找
     *     3. 如果 arr[mid]<mid,left=mid+1,继续在右半边寻找
     *     4. 如果 arr[mid]>mid,right=mid-1,继续在左半边找
     *
     * @param arr
     * @param n
     * @return
     */
    public int findPos(int[] arr, int n) {
        // write code here
        int result = -1;
        int left = 0;
        int right = n-1;
        int mid = -1;
        while(left <= right){
             mid = left + (right-left)/2;
             if(arr[mid]==mid){
                 result = mid;
                 right = mid-1;
             }else if(arr[mid]>mid){
                 right=mid-1;
             }else{
                 left=mid+1;
             }
        }

        return result;
    }


    public static void main(String[] args){
        FindLeft fl = new FindLeft();

        int[] arr = {-1,0,2,3};

        System.out.println(fl.findPos(arr, arr.length));
    }
}
