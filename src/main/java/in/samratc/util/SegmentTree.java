package in.samratc.util;

public interface SegmentTree<F,E> {

	E query(int rangeStart, int rangeEnd);
	
	void update(int pos, F val);
	
	void print();
	
	E[] getSegTree();
	
}
