/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public interface IHeap<P, V> {

	void Insert(P priority, V value);
	
	V get();

	P getPrioridad();
	
	V remove();
	
	int count();
	
	boolean isEmpty();
	
}