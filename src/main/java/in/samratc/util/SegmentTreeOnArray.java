package in.samratc.util;

import java.lang.reflect.Array;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class SegmentTreeOnArray<F,E> implements SegmentTree<F, E>{
	private E[] segTree;
	private F[] arr;
	private int arrSize, segTreeSize;
	private BinaryOperator<E> mergerFuct;
	private Function<F, E> converterFunc;
	public SegmentTreeOnArray(Class<E> segTreeClazz, F[] arr, BinaryOperator<E> mergerBiFunction, Function<F, E> converterFunc) {
		if(arr == null || arr.length == 0)
			throw new IllegalStateException("Null or Empty Array");
		this.arrSize = arr.length;
		this.segTreeSize = 4*arrSize;
		// Use Array native method to create array
        // of a type only known at run time
        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(segTreeClazz, segTreeSize);
        this.arr = arr;
        segTree = a;
        this.mergerFuct = mergerBiFunction;
        this.converterFunc = converterFunc;
        build(1, 0, arrSize - 1);
	}
	
	public E[] getSegTree() {
		return segTree;
	}
	
	public void update(int pos, F val) {
		if(pos < 0 || pos >= arrSize)
			throw new IllegalStateException("Invalid Array Position");
		update(1, 0, arrSize -1 , pos, val);
		arr[pos] = val;
	}
	
	public E query(int rangeStart, int rangeEnd) {
		return query(rangeStart, rangeEnd, 1, 0, arrSize - 1);
	}
	
	private E query(int rangeStart, int rangeEnd, int treeIndex, int start, int end) {
		if(start == end)
			return segTree[treeIndex];
		E res;
		int mid = start + (end - start)/2;
		if(rangeStart <= start && rangeEnd >= end)
			res =  segTree[treeIndex];
		else if(rangeEnd <= mid)
			res = query(rangeStart, rangeEnd, 2*treeIndex, start, mid);
		else if(rangeStart > mid)
			res = query(rangeStart, rangeEnd, 2*treeIndex + 1, mid+1, end);
		else
			res = mergerFuct.apply(query(rangeStart, mid, 2*treeIndex, start, mid), query(mid+1, rangeEnd, 2*treeIndex + 1, mid +1, end));
		
		return res;
	}
	
	private void update(int treeIndex, int start, int end, int pos, F val) {
		if(start == end) {
			segTree[treeIndex] = converterFunc.apply(val);
			return;
		}
		int mid = start + (end - start)/2;
		if(pos <= mid)
			update(2*treeIndex, start, mid, pos, val);
		else
			update(2*treeIndex +1, mid+1, end, pos, val);
		segTree[treeIndex] = mergerFuct.apply(segTree[2*treeIndex], segTree[2*treeIndex + 1]);
	}

	private void build(int treeIndex, int start, int end) {
		if(start == end) {
			segTree[treeIndex] = converterFunc.apply(arr[start]);
			return;
		}
		int mid = start + (end - start) / 2;
		build(2* treeIndex, start, mid);
		build(2*treeIndex+1, mid + 1, end);
		segTree[treeIndex] = mergerFuct.apply(segTree[2*treeIndex], segTree[2*treeIndex +1]);
	}
	
	public void print() {
		print(1, 0, arrSize -1 );
	}
	
	private void print(int treeIndex, int start, int end) {
		System.out.printf("%s [%d %d]\n",segTree[treeIndex], start, end);
		if(start == end)
			return;
		int mid = start + (end - start)/2;
		print(2*treeIndex, start, mid);
		print(2*treeIndex + 1, mid + 1, end);		
	}
}
