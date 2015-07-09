package algorithm.treebased;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListPool<T> {
    private final Integer listCapacity;
    private LinkedList<ArrayList<T>> pool;

    public ArrayListPool(Integer initialCapacity, Integer listCapacity) {
        this.pool = new LinkedList<>();
        this.listCapacity = listCapacity;
        for (Integer integer = 0; integer < initialCapacity; integer++) {
            pool.add(new ArrayList<>(listCapacity));
        }
    }

    public ArrayList<T> getList() {
        ArrayList<T> lastList = pool.pollLast();
        if(lastList == null) {
            return new ArrayList<>(listCapacity);
        }
        if(!lastList.isEmpty()) {
            lastList.clear();
        }
        return lastList;
    }

    public void utilizeList(ArrayList<T> listForUtilization) {
        pool.push(listForUtilization);
    }


}
