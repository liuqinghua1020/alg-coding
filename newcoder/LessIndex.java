package com.shark.newcoder;
/**
 * Created by qinghualiu on 2017/2/12.
 *
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，
 * 那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class LessIndex {

    /**
     * 思路：
     *  1.如果数组是空，或是长度是零，直接返回 -1
     *  2.如果只有一个元素，根据定义，直接返回 arr[0]
     *  3.此时 数组元素个数N>1,从边界情况入手：
     *    3.1 如果arr[0]<arr[1],直接返回arr[0]
     *    3.2 如果arr[N-1]<arr[N-2],直接返回 arr[N-1]
     *    3.3 如果不是 3.1和3.2的情况的话，则可以判断 arr[0]>arr[1]且arr[N-2]<arr[N-1],
     *        此时整个数组的趋势 从左到右是 下降的， 从右向左也是下降的
     *    3.4 先查看arr[(l+r)/2]与左右做对比
     *        3.4.1 如果arr[(l+r)/2] 比 左边小，可以只考虑左边
     *        3.4.2 如果arr[(l+r)/2] 比 右边小，可以只考虑右边
     *
     *    二分法处理问题的核心是：能否舍弃一半的内容
     * @param arr
     * @return
     */
    public int getLessIndex(int[] arr) {
        if(arr == null || arr.length <= 0) return -1;

        if(arr.length == 1) return 0;

        if(arr[0]<arr[1]) return 0;

        if(arr[arr.length-1]<arr[arr.length-2]) return arr.length-1;

        int left=0;
        int right = arr.length;


        while(left > 0 && right > 0 && left <= right){
            int mid=this.midIndex(left, right);
            if(mid <=0 || mid >= arr.length-1 ) break;
            if(arr[mid]<arr[mid-1] && arr[mid] < arr[mid+1]){

                return mid;

            }else if(arr[mid]>arr[mid-1]){
                right = mid-1;
            }else{
                left = mid+1;
            }

        }


        return -1;
    }

    public int midIndex(int left, int right){
        return left + (right - left)/2;
    }
}
