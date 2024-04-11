package data_structure;

import java.util.*;
import java.util.concurrent.*;

public class CollectionsAndMaps {
    public Collections collections;

    public List<Object> arrayListlist = new ArrayList<>();
    public List<Object> linkedList = new LinkedList<>();
    public List<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    public Queue<Object> queue = new PriorityQueue<>();
    public Queue<Object> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public Deque<Object> deque = new ArrayDeque<>();
    public Deque<Object> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    public BlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
    public BlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
    public BlockingDeque<Object> linkedBlockingDeque = new LinkedBlockingDeque<>();

    public Set<Object> hashSet = new HashSet<>();
    public Set<Object> linkedHashSet = new LinkedHashSet<>();
    public Set<Object> copyOnWriteArraySet = new CopyOnWriteArraySet();

    public NavigableSet<Object> sortedSet = new TreeSet<>();
    public NavigableSet<Object> concurrentSkipListSet = new ConcurrentSkipListSet<>();

    public Map<Objects, Objects> hashMap = new HashMap<>();
    public Map<Objects, Objects> linkedHashMap = new LinkedHashMap<>();

    public NavigableMap<Objects, Objects> treeMap = new TreeMap<>();

    public ConcurrentMap<Objects, Objects> concurrentHashMap = new ConcurrentHashMap<>();

    public ConcurrentNavigableMap<Objects, Objects> concurrentSkipListMap = new ConcurrentSkipListMap<>();
}
