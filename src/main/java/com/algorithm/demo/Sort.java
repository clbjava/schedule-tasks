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
    public static void bubbleSort(int[] numbers) {
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
        int log=0;
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

    public static void main(String[] args) throws JsonProcessingException {
       /* int sort[] = {30,19, 50, 100,30, 7, 60, 102, 68, 46, 80};
        selectSort(sort);*/

    }
}
