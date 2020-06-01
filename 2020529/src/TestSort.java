/*
 * @program: 2020529
 * @description
 * 数组排序
 * @author: mrs.yang
 * @create: 2020 -05 -29 16 :26
 */

public class TestSort {
    //直接插入排序
    public static void insertSort(int[] array){
        for (int i =1; i <array.length ; i++) {
            int tmp=array[i];
            int j;
            for (j = i-1; j >=0 ; j--) {
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    //选择排序
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        boolean flag=false;
        for (int i = 0; i <arr.length-1 ; i++) {
            flag=false;
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
                flag=true;
            }
        }
        if(flag==false){
            return;
        }
    }
    //
}
