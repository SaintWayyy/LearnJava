package data_structure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Maps {
    public Map<Objects, Objects> hashMap = new HashMap<>();
    public Map<Objects, Objects> linkedHashMap = new LinkedHashMap<>();

    public NavigableMap<Objects, Objects> treeMap = new TreeMap<>();

    // Concurrent
    public ConcurrentMap<Objects, Objects> concurrentHashMap = new ConcurrentHashMap<>();

    public ConcurrentNavigableMap<Objects, Objects> concurrentSkipListMap = new ConcurrentSkipListMap<>();
}
