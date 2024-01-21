package data_structure;

import java.util.*;

public class Collection {
    public List<Objects> arrayListlist = new ArrayList<>();
    public List<Objects> linkedList = new LinkedList<>();

    public Queue<Objects> queue = new PriorityQueue<>((o1, o2) -> o1.hashCode() - o2.hashCode());

    public Deque<Objects> deque = new ArrayDeque<>();

    public Set<Objects> hashSet = new HashSet<>();
    public Set<Objects> linkedHashSet = new LinkedHashSet<>();

    public SortedSet<Objects> sortedSet = new TreeSet<>((o1, o2) -> o1.hashCode() - o2.hashCode());
}
