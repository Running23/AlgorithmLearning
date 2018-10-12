package running.algorithmlearning.sort;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @Author: running
 * @Create: 2018/8/11 11:39
 * @Version: 1.0
 **/
public class QuickSort {
    /**
     * 1.假设我们现在对“6  1  2 7  9  3  4  5 10  8”这个10个数进行排序。首先在这个序列中随便找一个数作为基准数，
     * 为了方便，就让第一个数6作为基准数；
     * 2.接下来，需要将这个序列中所有比基准数大的数放在6的右边，比基准数小的数放在6的左边，类似下面这种排列：
     * “3  1  2 5  4  6  9 7  10  8”
     * 3.在初始状态下，数字6在序列的第1位。我们的目标是将6挪到序列中间的某个位置，假设这个位置是k。现在就需要寻找这个k，
     * 并且以第k位为分界点，左边的数都小于等于6，右边的数都大于等于6；
     * 4.方法其实很简单：分别从初始序列“6  1  2 7  9  3  4  5 10  8”两端开始“探测”。先从右往左找一个小于6的数，
     * 再从左往右找一个大于6的数，然后交换他们。这里可以用两个变量i和j，分别指向序列最左边和最右边。
     * 5.i指向6，j指向最右边8，此处设置的基准数是最左边的数，所以需要让j先出动,j--,直到找到一个小于6的数停下来,接下来
     * i++,直到找到一个数大于6的数停下来,最后j停在了数字5面前，i停在了数字7面前,然后将两个数交换，到此，第一次交换结束。
     * 6.接下来开始j继续向左挪动，发现了4（比基准数6要小，满足要求）之后停了下来，i也继续向右挪动的，他发现了9（比基准数
     * 6要大，满足要求）之后停了下来。此时再次进行交换。第二次交换结束，“探测”继续。
     * 7.j继续向左挪动，他发现了3，之后又停了下来。i继续向右移动，此是i和j相遇，说明此时“探测”结束。我们将基准数6和3进
     * 行交换。到此第一轮“探测”真正结束。此时以基准数6为分界点，6左边的数都小于等于6，6右边的数都大于等于6。其实j的使命
     * 就是要找小于基准数的数，而i的使命就是要找大于基准数的数，直到i和j碰头为止。
     * 8.现在基准数6已经归位，它正好处在序列的第6位。此时我们已经将原来的序列，以6为分界点拆分成了两个序列，左边的序列
     * 是“3  1 2  5  4”，右边的序列是“9  7  10  8”。接下来还需要分别处理这两个序列。
     * 9.已经掌握了方法，接下来只要模拟刚才的方法分别处理6左边和右边的序列即可。现在先来处理6左边的序列
     * 10.左边的序列是“3  1  2 5  4”。请将这个序列以3为基准数进行调整，使得3左边的数都小于等于3，3右边的数都大于等于3。
     * 11.快速排序的每一轮处理其实就是将这一轮的基准数归位，直到所有的数都归位为止，排序就结束了。
     * 12.相比冒泡排序，每次交换是跳跃式的。每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，将大于
     * 等于基准点的数全部放到基准点的右边。这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距
     * 离就大的多了。因此总的比较和交换次数就少了，速度自然就提高了。
     * 时间复杂度（平均）:O(nlog2n)
     * 时间复杂度（最坏):O(n2)
     * 时间复杂度（最好):O(nlog2n)
     * 空间复杂度:O(nlog2n)
     * 稳定性:不稳定
     * 复杂性:较复杂
     *
     * @param args
     */


    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 45, 65, 33, 12};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        Long start = System.currentTimeMillis();
        System.out.println("排序之前：" + start);
        Integer[] resultSort = quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + (System.currentTimeMillis() - start));
        System.out.println();
        for (Integer num : resultSort) {
            System.out.print(num + " ");
        }
    }

    public static Integer[] quickSort(Integer[] arr, Integer left, Integer right) {
        Integer i, j, t, temp;
        if (left > right)
            return arr;

        //temp存储基准数
        temp = arr[left];
        i = left;
        j = right;
        while (i != j) {
            //顺序很重要，要从左边开始找
            while (arr[j] > temp && i < j) {
                j--;
            }
            //左边完，再从右边开始找
            while (arr[i] <= temp && i < j) {
                i++;
            }
            //交换两个数在数组中的位置
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //最终将基数归位
        arr[left] = arr[i];
        arr[i] = temp;
        //继续处理左边，这里是一个递归的过程
        quickSort(arr, left, i - 1);
        //继续处理右边，这里是一个递归的过程
        quickSort(arr, i + 1, right);
        return arr;
    }

}
