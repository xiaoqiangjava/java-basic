package com.xq.learn.collection.map;

/**
 * HashMap源码解析
 * @author xiaoqiang
 * @date 2019/6/22 18:30
 */
public class HashMapMain<K, V>
{
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int TREEIFY_THRESHOLD = 8;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    Node<K, V>[] table;

    int size;

    int threshold;

    int modCount;

    final float loadFactor;

    public HashMapMain(int initialCapacity, float loadFactor)
    {
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    static class Node<K, V>
    {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next)
        {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public final int size()
    {
        return size;
    }

    /**
     * put，往map中保存数据
     * @param key key
     * @param value value
     * @return oldValue
     */
    public final V put(K key, V value)
    {
        return putVal(key, value, hash(key));
    }

    final V putVal(K key, V value, int hash)
    {
        Node<K, V>[] tab; Node<K, V> p; int n, i;
        // 当第一put操作时，会初始化table
        if (null == (tab = table) || (n = tab.length) == 0)
        {
            n = (tab = resize()).length;
        }
        // 根据hash值定位当前key在数组中的下标，如果该下标出没有元素，则直接新建Node，将node赋值为数组
        if (null == (p = tab[i = (n - 1) & hash]))
        {
            tab[i] = new Node<>(hash, key, value, null);
        }
        else
        {
            // 当前hash所在的位置已经存在元素，并且key已经存在，直接替换value
            Node<K, V> e; K k;
            // 判断key是否存在时，先判断key的hash值是否相等，若相等再通过equals方法是否相等，因为由于hashCode方法的实现
            // 两个hash值相等的对象不一定是同一个对象，还需要判断是否是同一个类型，但由于equals方法比较繁重，先使用hash判断
            // 提高性能，当hash值不相等时不需要使用equals来判断，两个对象肯定不相等。
            if (p.hash == hash && ((k = p.key) == key || (null != key && key.equals(k))))
            {
                e = p;
            }
            else
            {
                // 遍历链表，获取next对应的node，如果key已经存在则更新值，否则直到next为null新建node
                for (int binCount = 0;; binCount++)
                {
                    if (null == (e = p.next))
                    {
                        p.next = new Node<>(hash, key, value, null);
                        // 链表节点增加之后判断是否到了转换的阈值，将链表结构转换成红黑数
                        if (binCount >= TREEIFY_THRESHOLD)
                        {
                            // todo  将链表转换成红黑树
                        }
                        break;
                    }
                    // 同样判断当前节点中key是否存在，如果已经存在，跳出循环，直接将value修改即可
                    if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k))))
                    {
                        break;
                    }
                    // 遍历链表，循环结束后需要将当前的node节点修改了父节点
                    p = e;
                }

            }

            if (null != e)
            {
                // put操作更新完成后返回修改前的value
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        ++modCount;
        // 当map中的key-value对超过临界值时，数组需要扩容，threshold默认是initialCapacity * loadFactor
        if (++size > threshold)
        {
            resize();
        }
        return null;
    }

    public final V get(Object key)
    {
        return table[(table.length - 1) & hash(key)].value;
    }

    static final int hash(Object key)
    {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    final Node<K, V>[] resize()
    {
        if (null == table || table.length == 0)
        {
            Node<K, V>[] newTab = new Node[DEFAULT_INITIAL_CAPACITY];
            table = newTab;
            return newTab;
        }

        return null;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args)
    {
        HashMapMain<String, String> map = new HashMapMain<>(10, 0.75f);
        map.put("name", "xiaoqiang");
        map.put("age", "24");
        map.put("faceValue", "100");
        String value = map.get("name");
        System.out.println(value);
        System.out.println(map.get("age"));
        System.out.println(map.get("faceValue"));
    }
}
