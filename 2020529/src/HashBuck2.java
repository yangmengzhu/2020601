import java.util.Objects;

/*
 * @program: 2020529
 * @description
 *
 * @author: mrs.yang
 * @create: 2020 -05 -29 21 :04
 */
class Person {
    public int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class HashBuck2<K,V> {
        static class Node<K,V> {
            public K key;
            public V val;
            public Node<K,V> next;
            public Node(K key,V val) {
                this.key = key;
                this.val = val;
            }
        }
        public Node<K,V>[] array = (Node<K,V>[])new Node[10];
        public int usedSize;

        public void put(K key,V val) {
            int hash = key.hashCode();
            int index = hash % array.length;
            for (Node<K,V> cur = array[index];cur != null;cur = cur.next) {
                if(cur.key.equals(key)) {
                    cur.val = val;
                    return;
                }
            }
            Node<K,V> node = new Node<>(key,val);
            node.next = array[index];
            array[index] = node;
            this.usedSize++;
        }

        public V get(K key) {
            //1、找位置
            int hash=key.hashCode();
            int index=hash%array.length;
            //2、遍历单链表开始找  找到返回val值
            Node<K,V> cur=array[index];
          while(cur!=null){
              if(cur.key.equals(key) ){
                  return cur.val;
              }
              cur=cur.next;
          }
          return null;
        }
    }
