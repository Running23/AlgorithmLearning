package running.algorithmlearning.paixu;

/**
 * @ClassName: InsertionSort
 * @Description: 插入排序
 * @Author: running
 * @Create: 2018/8/11 10:53
 * @Version: 1.0
 **/
public class InsertionSort {

    /**
     * 1.插入排序是基于比较的排序。所谓的基于比较，就是通过比较数组中的元素，看谁大谁小，根据结果来调整元素的位置
     * 2.对于这类排序，就有两种基本的操作：①比较操作； ②交换操作
     * 3.对于交换操作，可以优化成移动操作，即不直接进行两个元素的交换，还是用一个枢轴元素(tmp)将当前元素先保存起来
     * ，然后执行移动操作，待确定了最终位置后，再将当前元素放入合适的位置。因为，交换操作需要三次赋值，而移动操作只
     * 需要一次赋值！
     * 4.插入排序算法分析:
     * 插入排序算法有种递归的思想在里面，它由N-1趟排序组成。初始时，只考虑数组下标0处的元素，只有一个元素，显然是有序的;
     * 然后第一趟 对下标 1 处的元素进行排序，保证数组[0,1]上的元素有序；
     * 第二趟 对下标 2 处的元素进行排序，保证数组[0,2]上的元素有序；
     * .....
     * .....
     * 第N-1趟对下标 N-1 处的元素进行排序，保证数组[0,N-1]上的元素有序，也就是整个数组有序了。
     * 它的递归思想就体现在：当对位置 i 处的元素进行排序时，[0,i-1]上的元素一定是已经有序的了。
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("排序之前：");
        for (Integer num : arr) {
            System.out.print(num + " ");
        }

        //插入排序
        for (int i = 1; i < arr.length; i++) {
            //保存当前数据，其中前[0,i-1]已经排好序了
            Integer tem = arr[i];
            int j;
            //比较移动
            for (j = i; j > 0 && tem.compareTo(arr[j - 1]) < 0; j--) {
                //后移一位
                arr[j] = arr[j - 1];
            }
            //插入合适位置
            arr[j] = tem;
        }
        System.out.println();
        System.out.println("排序后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
