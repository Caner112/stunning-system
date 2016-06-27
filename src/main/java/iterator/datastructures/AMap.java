package iterator.datastructures;

import iterator.CoolAndHipIterator;

import java.util.*;

/**
 * Created by j on 6/27/16.
 */
public class AMap<K, V> implements CoolAndHipIterator<V>{

    private Map<K, V> map = new LinkedHashMap<K, V>();
    private int current = 0;

    @Override
    public Optional<V> getCurrent() {
        if (current < map.size()){
            Set<K> key = map.keySet();
            K[] arr = (K[])key.toArray();
            K currentKey = arr[current];
            V currentObj = map.get(currentKey);
            if(currentObj != null) {
                return Optional.of(currentObj);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean hasNext() {
        if(current <= map.size()-1){return true;}
        return false;
    }

    @Override
    public void moveNext() {
        current++;
    }

    @Override
    public CoolAndHipIterator<V> getIterator() {
        return this;
    }

    public void add(K key, V value){
        map.put(key, value);
    }

}