package Lab3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Example13 {

    private static final int ELEMENTS_COUNT = 100_000;

    public static void main(String[] args) {
        System.out.println("Количество элементов для демонстрационного запуска: " + ELEMENTS_COUNT);
        System.out.println("Для полного варианта 14 нужно использовать 14_000_000 элементов.");
        System.out.println();

        System.out.println("Сравнение времени добавления, нс");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Коллекция", "Начало", "Середина", "Конец");
        System.out.printf("%-15s %-15d %-15d %-15d%n", "ArrayList", addArrayListStart(), addArrayListMiddle(), addArrayListEnd());
        System.out.printf("%-15s %-15d %-15d %-15d%n", "LinkedHashSet", addSetStart(), addSetMiddle(), addSetEnd());
        System.out.printf("%-15s %-15d %-15d %-15d%n", "LinkedHashMap", addMapStart(), addMapMiddle(), addMapEnd());
        System.out.println();

        System.out.println("Сравнение времени удаления, нс");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Коллекция", "Начало", "Середина", "Конец");
        System.out.printf("%-15s %-15d %-15d %-15d%n", "ArrayList", removeArrayListStart(), removeArrayListMiddle(), removeArrayListEnd());
        System.out.printf("%-15s %-15d %-15d %-15d%n", "LinkedHashSet", removeSetStart(), removeSetMiddle(), removeSetEnd());
        System.out.printf("%-15s %-15d %-15d %-15d%n", "LinkedHashMap", removeMapStart(), removeMapMiddle(), removeMapEnd());
        System.out.println();

        System.out.println("Сравнение времени получения элемента, нс");
        System.out.printf("%-15s %-35s %-15s%n", "Коллекция", "Способ доступа", "Время");
        System.out.printf("%-15s %-35s %-15d%n", "ArrayList", "get(index)", getArrayListByIndex());
        System.out.printf("%-15s %-35s %-15d%n", "LinkedHashSet", "итерация до середины", getSetByIteration());
        System.out.printf("%-15s %-35s %-15d%n", "LinkedHashMap", "get(key)", getMapByKey());
    }

    private static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> list = new ArrayList<>(ELEMENTS_COUNT);
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            list.add(i);
        }
        return list;
    }

    private static LinkedHashSet<Integer> createSet() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(ELEMENTS_COUNT);
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            set.add(i);
        }
        return set;
    }

    private static LinkedHashMap<Integer, Integer> createMap() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(ELEMENTS_COUNT);
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            map.put(i, i);
        }
        return map;
    }

    private static long addArrayListStart() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        list.add(0, -1);
        return System.nanoTime() - start;
    }

    private static long addArrayListMiddle() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        list.add(list.size() / 2, -1);
        return System.nanoTime() - start;
    }

    private static long addArrayListEnd() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        list.add(-1);
        return System.nanoTime() - start;
    }

    private static long removeArrayListStart() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        list.remove(0);
        return System.nanoTime() - start;
    }

    private static long removeArrayListMiddle() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        list.remove(list.size() / 2);
        return System.nanoTime() - start;
    }

    private static long removeArrayListEnd() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        list.remove(list.size() - 1);
        return System.nanoTime() - start;
    }

    private static long getArrayListByIndex() {
        ArrayList<Integer> list = createArrayList();
        long start = System.nanoTime();
        int value = list.get(list.size() / 2);
        long time = System.nanoTime() - start;
        consume(value);
        return time;
    }

    private static long addSetStart() {
        LinkedHashSet<Integer> set = createSet();
        long start = System.nanoTime();
        LinkedHashSet<Integer> newSet = new LinkedHashSet<>();
        newSet.add(-1);
        newSet.addAll(set);
        return System.nanoTime() - start;
    }

    private static long addSetMiddle() {
        LinkedHashSet<Integer> set = createSet();
        long start = System.nanoTime();
        LinkedHashSet<Integer> newSet = new LinkedHashSet<>();
        int index = 0;
        for (Integer value : set) {
            if (index == set.size() / 2) {
                newSet.add(-1);
            }
            newSet.add(value);
            index++;
        }
        return System.nanoTime() - start;
    }

    private static long addSetEnd() {
        LinkedHashSet<Integer> set = createSet();
        long start = System.nanoTime();
        set.add(-1);
        return System.nanoTime() - start;
    }

    private static long removeSetStart() {
        LinkedHashSet<Integer> set = createSet();
        int first = set.iterator().next();
        long start = System.nanoTime();
        set.remove(first);
        return System.nanoTime() - start;
    }

    private static long removeSetMiddle() {
        LinkedHashSet<Integer> set = createSet();
        int target = getByIteration(set, set.size() / 2);
        long start = System.nanoTime();
        set.remove(target);
        return System.nanoTime() - start;
    }

    private static long removeSetEnd() {
        LinkedHashSet<Integer> set = createSet();
        int last = getByIteration(set, set.size() - 1);
        long start = System.nanoTime();
        set.remove(last);
        return System.nanoTime() - start;
    }

    private static long getSetByIteration() {
        LinkedHashSet<Integer> set = createSet();
        long start = System.nanoTime();
        int value = getByIteration(set, set.size() / 2);
        long time = System.nanoTime() - start;
        consume(value);
        return time;
    }

    private static int getByIteration(Set<Integer> set, int targetIndex) {
        int index = 0;
        for (Integer value : set) {
            if (index == targetIndex) {
                return value;
            }
            index++;
        }
        return -1;
    }

    private static long addMapStart() {
        LinkedHashMap<Integer, Integer> map = createMap();
        long start = System.nanoTime();
        LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<>();
        newMap.put(-1, -1);
        newMap.putAll(map);
        return System.nanoTime() - start;
    }

    private static long addMapMiddle() {
        LinkedHashMap<Integer, Integer> map = createMap();
        long start = System.nanoTime();
        LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<>();
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (index == map.size() / 2) {
                newMap.put(-1, -1);
            }
            newMap.put(entry.getKey(), entry.getValue());
            index++;
        }
        return System.nanoTime() - start;
    }

    private static long addMapEnd() {
        LinkedHashMap<Integer, Integer> map = createMap();
        long start = System.nanoTime();
        map.put(-1, -1);
        return System.nanoTime() - start;
    }

    private static long removeMapStart() {
        LinkedHashMap<Integer, Integer> map = createMap();
        Integer firstKey = map.keySet().iterator().next();
        long start = System.nanoTime();
        map.remove(firstKey);
        return System.nanoTime() - start;
    }

    private static long removeMapMiddle() {
        LinkedHashMap<Integer, Integer> map = createMap();
        Integer key = getKeyByPosition(map, map.size() / 2);
        long start = System.nanoTime();
        map.remove(key);
        return System.nanoTime() - start;
    }

    private static long removeMapEnd() {
        LinkedHashMap<Integer, Integer> map = createMap();
        Integer key = getKeyByPosition(map, map.size() - 1);
        long start = System.nanoTime();
        map.remove(key);
        return System.nanoTime() - start;
    }

    private static long getMapByKey() {
        LinkedHashMap<Integer, Integer> map = createMap();
        int key = ELEMENTS_COUNT / 2;
        long start = System.nanoTime();
        Integer value = map.get(key);
        long time = System.nanoTime() - start;
        consume(value);
        return time;
    }

    private static Integer getKeyByPosition(LinkedHashMap<Integer, Integer> map, int targetIndex) {
        int index = 0;
        for (Integer key : map.keySet()) {
            if (index == targetIndex) {
                return key;
            }
            index++;
        }
        return null;
    }

    private static void consume(Object value) {
        if (value == null) {
            System.out.println("Значение не найдено");
        }
    }
}
