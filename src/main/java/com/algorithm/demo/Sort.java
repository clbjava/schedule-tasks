package com.algorithm.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: schedule-tasks
 * @Description: TODO
 * @author: Administrator
 * @date: 2018-12-21 9:44
 * @version: 1.0.0
 */
public class Sort {

    private static final Logger LOG = LoggerFactory.getLogger(Sort.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /*
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param numbers 需要排序的整型数组
     * O(n*n)
     */
    public static void bubbleSort(int[] numbers) throws JsonProcessingException {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }

            LOG.info("selectSort:{}{}", i,MAPPER.writeValueAsString(numbers));
        }
    }


    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low,int high)
    {
        //数组的第一个作为中轴
        int temp = numbers[low];
        while(low < high)
        {
            try {
                LOG.info("---:{}",MAPPER.writeValueAsString(numbers));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            while(low < high && numbers[high] >= temp)
            {
                high--;
            }
            //比中轴小的记录移到低端
            numbers[low] = numbers[high];
            while(low < high && numbers[low] < temp)
            {
                low++;
            }
            //比中轴大的记录移到高端
            numbers[high] = numbers[low];
        }
        //中轴记录到尾
        numbers[low] = temp ;
        // 返回中轴的位置
        return low ;
    }

    public static void quickSort(int sort[], int low, int high) {
        if (low < high) {
            int middle = getMiddle(sort, low, high);
            quickSort(sort, low, middle - 1);
            quickSort(sort, middle + 1, high);
        }
    }

    public static void selectSort(int sort[]) {
        //int mini=sort[0];
        int log = 0;
        int size = sort.length;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = k + 1; j < size; j++) {
                log++;
                int flag = sort[k];
                if (sort[j] < flag) {
                    sort[k] = sort[j];
                    sort[j] = flag;
                }
            }
        }
        LOG.info("selectSort:{}", log);
    }

    /**
     * 插入排序
     *
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     * @param numbers  待排序数组
     */
    public static void insertSort(int[] numbers)
    {
        int size = numbers.length;
        int temp = 0 ;
        int j =  0;

        for(int i = 0 ; i < size ; i++)
        {
            //取标志位
            temp = numbers[i];

            //假如temp比前面的值小，则将前面的值后移
            for(j = i ; j > 0 && temp < numbers[j-1] ; j --)
            {
                numbers[j] = numbers[j-1];
            }

            //j--
            numbers[j] = temp;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
       int sort[] = {49,27,13,76,97,65,38,49};
        /* selectSort(sort);*/
        insertSort(sort);
        LOG.info("---:{}",MAPPER.writeValueAsString(sort));

        int[] a={6,7,4,5,8};
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            LOG.info("---:{}-->>{}",i,MAPPER.writeValueAsString(a));
        }

        LOG.info("---:{}",MAPPER.writeValueAsString(a));

    }

    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex){
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }

}
