package prac_3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyMap<K, V> extends HashMap<K, V> implements Map<K, V> {
    private static final Lock lock = new ReentrantLock();
    @Override
    public int size() {
        lock.lock();
        int c = super.size();
        lock.unlock();
        return c;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean c = super.isEmpty();
        lock.unlock();
        return c;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean c = super.containsKey(key);
        lock.unlock();
        return c;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean c = super.containsValue(value);
        lock.unlock();
        return c;
    }

    @Override
    public V get(Object key) {
        lock.lock();
        V c = super.get(key);
        lock.unlock();
        return c;
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        V c = super.put(key, value);
        lock.unlock();
        return c;
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        V c = super.remove(key);
        lock.unlock();
        return c;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        super.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        super.clear();
        lock.unlock();
    }

    @Override
    public Set<K> keySet() {
        lock.lock();
        Set<K> c = super.keySet();
        lock.unlock();
        return c;
    }

    @Override
    public Collection<V> values() {
        lock.lock();
        Collection<V> c = super.values();
        lock.unlock();
        return c;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        lock.lock();
        Set<Entry<K, V>> c = super.entrySet();
        lock.unlock();
        return c;
    }
}
