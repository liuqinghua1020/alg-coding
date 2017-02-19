package com.shark.newcoder;

/**
 * 链接：https://www.nowcoder.com/courses/1/6/3
 来源：牛客网

 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 测试样例：
 [1,2,3,3,4],5,3
 返回：2
 */
public class LeftMostAppearance {

    /**
     * 思路：
     *   1.二分搜索找到第一个指定的元素，此时由于是找最先出现的元素，其右边的可以抛弃，将right指向该元素
     *   2.对 left 到 right之间继续采用二分搜索。
     *   3.如果在 left和right 之间还能找到 指定的值的元素，则right继续移到该位置;否则 left+1 继续二分搜索
     *   4.最终 left>right终止 二分搜索
     *   5.返回 right
     * @param arr
     * @param n
     * @param num
     * @return
     */
    public int findPos(int[] arr, int n, int num) {
        // write code here
        int left = 0;
        int right = n-1;
        int pos = -1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid] == num){
                pos = mid;
                right = mid-1;
            }else if(arr[mid]>num){
                right = mid-1;
            }else if(arr[mid]<num){
                left = mid+1;
            }
        }
        return pos;
    }


    public static void main(String[] args){
        int[] arr = {1,2,3,3,4};

        LeftMostAppearance leftMostAppearance = new LeftMostAppearance();
        int resultIindex = leftMostAppearance.findPos(arr,5,3);
        System.out.println(resultIindex);
    }
}






