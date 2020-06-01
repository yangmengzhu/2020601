import java.util.*;

/*
 * @program: 2020529
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -29 14 :02
 */
/*class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;//大堆
    }
}*/
public class TopK {

        public String name="abc";
        public static void main(String[] args){
            TopK test=new TopK();
            TopK testB=new TopK();
            System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
        }

   public static int[] topk(int[] arr,int k){
      // MyComparator MyComparator=new MyComparator();
       PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2)->o2-o1);
       for (int i:arr) {
           if(priorityQueue.size()<k){
               priorityQueue.offer(i);
           }else{
               Integer val=priorityQueue.peek();
               if(val!=null&&val>i){
                   priorityQueue.poll();
                   priorityQueue.offer(i);
               }
           }
       }
       int[] array=new int[k];
       for (int i = 0; i < k; i++) {
           Integer s= priorityQueue.poll();
           array[i]=s;
       }
       return array;
   }
   //比较版本号
    public int compareVersion(String version1, String version2) {
     String[] versioni1=version1.split("\\.");
     String[] versioni2=version2.split("\\.");
     int len=Math.max(versioni1.length,versioni2.length);
     int[] array1=new int[len];
     int[] array2=new int[len];
        for (int i = 0; i < len; i++) {
            if(i<versioni1.length){
                array1[i]=Integer.valueOf(versioni1[i]);
            }
            if(i<versioni2.length){
                array2[i]=Integer.valueOf(versioni2[i]);
            }
            if(array1[i]>array2[i]){
                return 1;
            }
            if(array2[i]>array1[i]){
                return -1;
            }
        }
        return 0;
    }
    //最接近X的K个元素
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret=new ArrayList<>();
        if(arr.length==0||k==0){
            return ret;
        }
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o2)-Math.abs(o1);
        }
    });
        for (int i = 0; i <arr.length ; i++) {
            if(maxHeap.size()<k){
                maxHeap.offer(arr[i]-x);
            }else if(Math.abs(maxHeap.peek())>Math.abs(arr[i]-x)){
                maxHeap.poll();
                maxHeap.offer(arr[i]-x);
            }
        }
      while(maxHeap.size()>0){
          ret.add(maxHeap.poll()+x);
      }
      Collections.sort(ret);
      return ret;
    }
    //员工的重要性
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id){
          Map<Integer,Employee> map=new HashMap<>();
        for (Employee e:employees) {
            map.put(e.id,e);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(id);
        int sum=0;
        while(!queue.isEmpty()){
            Integer e=queue.poll();
            sum+=map.get(e).importance;
            for (int val:map.get(e).subordinates) {
               queue.offer(val);
            }
        }
        return sum;
    }
    public static void main1(String[] args) {
        int[] array={4,8,5,7,4,6,1};
        int[] ret=topk(array,4);
        System.out.println(Arrays.toString(ret));
    }

}
