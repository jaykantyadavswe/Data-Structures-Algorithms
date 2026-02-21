package DSA.Hashing;
import java.util.*;

public class HashMapImplement {
    static class HashMap<K, V> { //generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int size; //n
        private LinkedList<Node> buckets[]; //N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.size = 0;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % size;
        }

        public void put(K key, V value){
            int bi = hashFunction(key); //0 to 3
            int di = SearchInLL(key); //valid; -1
        }

        private int SearchInLL(K key, )
    }
    public static void main(String[] args) {
        
    }
}
