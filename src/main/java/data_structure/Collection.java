package data_structure;

import java.util.*;
import java.util.concurrent.*;

public class Collection {
    Collections collections;

    public List<Object> arrayListlist = new ArrayList<>();
    public List<Object> linkedList = new LinkedList<>();

    public Queue<Object> queue = new PriorityQueue<>();

    public Deque<Object> deque = new ArrayDeque<>();

    public Set<Object> hashSet = new HashSet<>();
    public Set<Object> linkedHashSet = new LinkedHashSet<>();

    public SortedSet<Object> sortedSet = new TreeSet<>();


    // Concurrent Data Structure
    public List<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    public Queue<Object> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public Deque<Object> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    public BlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
    public BlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();

    public BlockingDeque<Object> linkedBlockingDeque = new LinkedBlockingDeque<>();

    public Set<Object> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    public Set<Object> copyOnWriteArraySet = new CopyOnWriteArraySet();
}
