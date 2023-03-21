package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash<K,V>{
    private class HmNode{
        K key;
        V value;
        HmNode(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
    private int size;//n
    private LinkedList<HmNode>[] buckets;//N=bucket.length
    public MyHash(){
        initbuckets(4);
        size=0;
    }
    private void initbuckets(int N) {
        buckets=new LinkedList[N];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
        }
    }
    public void put(K key, V value){
        int bi=hashFn(key);
        int di=findKey(key,bi);
        if(di!=-1){
            //update
            HmNode node=buckets[bi].get(di);
            node.value=value;
        }else{
            //insert
            HmNode node=new HmNode(key, value);
            buckets[bi].add(node);
            size++;
        }
        double lambda=size*1.0 / buckets.length;
        if(lambda >2.0){
            rehash();
        }
    }
    private void rehash() {
        LinkedList<HmNode>[] oba=buckets;
        initbuckets(oba.length * 2);
        size=0;
        for(int i=0;i<oba.length;i++){
            for(HmNode node:oba[i]){
                put(node.key, node.value);
            }
        }
    }
    private int findKey(K key, int bi) {
        int di=0;
        for(HmNode node: buckets[bi]){
            if(node.key.equals(key)){
                return di;
            }
            di++;
        }
        return -1;
    }
    private int hashFn(K key) {
        int hc=key.hashCode();
        return Math.abs(hc)%buckets.length;
    }
    public boolean containsKey(K key){
        int bi = hashFn(key);
        int di = findKey(key, bi);
        if (di != -1) {
            return true;
        } else {
           return false;
        }
    }
    public V get(K key){
        int bi = hashFn(key);
        int di = findKey(key, bi);
        if (di != -1) {
            HmNode node=buckets[bi].get(di);
            return node.value;
        } else {
            return null;
        }
    }
    public V remove(K key){
        int bi = hashFn(key);
        int di = findKey(key, bi);
        if (di != -1) {
            HmNode node = buckets[bi].remove(di);
            size--;
            return node.value;
        } else {
            return null;
        }
    }
    public int size(){
        return size;
    }
    public ArrayList<K> keySet(){
        ArrayList<K>keys=new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            for(HmNode node: buckets[i]){
                keys.add(node.key);
            }
        }
        return keys;
    }
    
}
