package in.samratc.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Heap<E> {

    private E[] arr;
    private Comparator<? super E> comparator;
    private int size;
    private int arrSize = (int) 1e7 + 7;

    public boolean isEmpty(){
        return this.size <= 1 ;
    }

    public Heap(Collection<? super E> collection, Comparator<? super E> comparator) {
        this.arr = (E[]) new Object[arrSize];
        Iterator<? super E> iterator = collection.iterator();
        int idx = 1;
        while (iterator.hasNext())
            this.arr[idx++] = (E) iterator.next();
        this.comparator = comparator;
        this.size = idx;
        heapify();

    }

    private void heapify() {
        for (int i = size - 1; i >= 1; i--)
            percolateUp(i);
    }

    private void percolateUp(int idx) {
        if (idx <= 1)
            return;
        if (comparator.compare(arr[parent(idx)], arr[idx]) > 0) {
            swap(idx, parent(idx));
            percolateUp(parent(idx));
        }
    }

    /*private void percolateDown(int idx) {
        if (right(idx) >= size && left(idx) >= size)
            return;
        if (right(idx) < size && comparator.compare(arr[right(idx)], arr[idx]) < 0 && comparator.compare(arr[right(idx)], arr[left(idx)]) <= 0) {
            swap(idx, right(idx));
            percolateDown(right(idx));
        } else if (left(idx) < size && comparator.compare(arr[left(idx)], arr[idx]) < 0 &&
                (right(idx) >= size || comparator.compare(arr[left(idx)], arr[right(idx)]) <= 0)) {
            swap(idx, left(idx));
            percolateDown(left(idx));
        }
    }*/

    private void percolateDown(int idx){
        int left = left(idx), right = right(idx), largest = idx;
        if(left < size && comparator.compare(arr[left], arr[idx]) < 0)
            largest = left;
        if(right < size && comparator.compare(arr[right], arr[largest]) < 0)
            largest = right;
        if(largest != idx){
            swap(idx, largest);
            percolateDown(largest);
        }
    }

    private int right(int idx) {
        return (idx << 1) + 1;
    }

    private int left(int idx) {
        return idx << 1;
    }

    private int parent(int idx) {
        return idx >> 1;
    }

    private void swap(int p, int q) {
        E temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public void insert(E val) {
        this.size++;
        this.arr[size - 1] = val;
        percolateUp(size - 1);
    }

    public E removeRoot() {
        if (this.size <= 1)
            return null;
        E root = this.arr[1];
        swap(1, this.size - 1);
        this.size--;
        percolateDown(1);
        return root;
    }

    public E getRoot() {
        return size <= 1 ? null : this.arr[1];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        IntStream.range(1, this.size).forEachOrdered(i -> sb.append(this.arr[i] + " "));
        return String.format("[%s]", sb.toString());
    }

    public Stream<E> stream() {
        return Arrays.stream(this.arr, 1, this.size);
    }
}