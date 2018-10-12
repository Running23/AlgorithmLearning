package running.algorithmlearning.sort;

import java.util.Arrays;

/**
 * @ClassName: MergeSort
 * @Description: 归并排序
 * 归并排序是利用归并的思想实现的排序方法，该算法采用经典的分治策略
 * （分治法将问题分成一些小的问题然后递归求解，而治的阶段将分的阶段得到的各答案“修补”在一起，即分而治之。）
 * @Author: running
 * @Create: 2018/10/12 9:33
 * @Version: 1.0
 **/
public class MergeSort {
    /**
     * 1.基本思想：分而治之
     *                      84571362
     *           8457                       1362
     *      84          57              13          62
     *   8      4   5       7      1        3   6       2
     *      48          57              13          26
     *           4578                       1236
     *                      12345678
     * 分阶段可以理解为就是递归拆分子序列的过程，递归深度为log2n,n是排序数
     * 治阶段将两个已经有序的子序列合并成一个有序序列
     * 以最后一次合并为例：
     * 1<4,将1填入temp数组中,右移j
     * 2<4,将2继续填入temp数组中，右移j
     * 3<4,将3填入temp数组,右移j
     * 4<6,此时将4填入temp中，右移i
     * 继续重复这种比较+填入的步骤，直到右子序列已经填完，这时将左边的7和8依次填入
     * 最后,将temp中的内容全部拷到原数组中去,排序完成
     */

    public static void sort(int [] arr){
        //排序前,先建好一个长度等于原数组长度的临时数组,避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int [] arr,int left,int right,int [] temp){
        if (left<right){
            int mid = (left + right) / 2;
            //左边归并排序,使左边子序列有序
            sort(arr,left,mid,temp);
            //右边归并排序,使右边子序列有序
            sort(arr,mid+1,right,temp);
            //将两个有序子序列数组合并操作
            merge(arr,left,mid,right,temp);
        }
    }

    //治
    private static void merge(int[]arr,int left,int mid,int right,int[] temp){
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t=0;
        while(i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while (i<=mid){
            temp[t++] = arr[i++];
        }
        //将右边剩余元素填充进temp中
        while (j<=right){
            temp[t++] = arr[j++];
        }
        t=0;
        //将temp中的元素全部拷贝到原数组中
        while(left<=right){
            arr[left++] = temp[t++];
        }
    }
    public static void main(String []args){
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
