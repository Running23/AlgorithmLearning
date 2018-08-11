package running.algorithmlearning.paixu;

/**
 * @ClassName: SelectionSort
 * @Description: 选择排序
 * @Author: running
 * @Create: 2018/8/10 10:10
 * @Version: 1.0
 **/
public class SelectionSort {
    /**
     * 1.每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，
     * 直到全部记录排序完毕。也就是：每一趟在n-i+1(i=1，2，…n-1)个记
     * 录中选取关键字最小的记录作为有序序列中第i个记录。
     * <p>
     * 2.简单选择排序的基本思想：给定数组：int[] arr={里面n个数据}；第
     * 1趟排序，在待排序数据arr[1]~arr[n]中选出最小的数据，将它与arrr[1]交换；
     * 第2趟，在待排序数据arr[2]~arr[n]中选出最小的数据，将它与r[2]交换；以此
     * 类推，第i趟在待排序数据arr[i]~arr[n]中选出最小的数据，将它与r[i]交换，
     * 直到全部排序完成。
     * 3.复杂度
     * 时间复杂度（平均）: 	O(n2)
     * 时间复杂度（最坏)： O(n2)
     * 时间复杂度（最好)： O(n2)
     * 空间复杂度：O(1)
     * 稳定性: 不稳定
     * 复杂性: 简单
     *
     */
    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("排序之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //选择排序优化
        //做第i趟排序
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            //选最小的记录
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    //记录最小值所在的位置
                    k = j;
                }
            }
            //内层循环结束后，如果存在最小的数，则进行交换
            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("选择排序后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
