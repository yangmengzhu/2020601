/*
 * @program: 2020529
 * @description
 * 哈希桶
 * @author: mrs.yang
 * @create: 2020 -05 -29 20 :11
 */
class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array = new Node[10];
    public int usedSize;

    public void put(int key,int val) {

        int index = key % array.length;
        for (Node cur = array[index];cur != null;cur = cur.next) {
            if(cur.key == key) {
                //key相同 更新val值
                cur.val = val;
                return;
            }
        }
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        if(loadFactor() > 0.75) {
            resize();
        }

    }

    public void resize() {
        Node[] newArray = new Node[2*this.array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                Node curNext=cur.next;
                int index=cur.key%newArray.length;
                //头插法放入newArray[index]
                cur.next=newArray[index];
                newArray[index]=cur;
                cur=curNext;
            }
        }
        array=newArray;
    }
   public int get(int key){
        int index=key%array.length;
        Node cur=array[index];
        while(cur!=null){
            if(cur.key==key){
                return cur.val;
            }
            cur=cur.next;
        }
        return -1;
   }
    public double loadFactor(){
        return this.usedSize*1.0 / this.array.length;
    }

}

