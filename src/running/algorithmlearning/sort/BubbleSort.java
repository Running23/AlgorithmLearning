package running.algorithmlearning.sort;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: running
 * @Create: 2018/8/10 10:51
 * @Version: 1.0
 **/
public class BubbleSort {
    /**
     * 1.相邻元素前后交换、把最大或者最小的排到最后
     * 2.如果前者比后者小，把前者和后者调换顺序，两两调换后一轮下来 最小的会被排到最后
     * 去。每一轮j都从0开始，当i轮排序，就有最后面的i个数字因为他是最小的，所以后面的每
     * 轮都不用理他了，也就是score.length-1-i往后的数不用管了
     * 时间复杂度（平均）:O(n2)
     * 时间复杂度（最坏):O(n2)
     * 时间复杂度（最好):O(n)
     * 空间复杂度:O(1)
     * 稳定性:稳定
     * 复杂性:简单
     *
     */
    public static void main(String[] args){
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        //冒泡排序：大的在前面
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){

                if (arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println();
        System.out.println("选择排序后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
