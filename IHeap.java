public interface IHeap<E extends Comparable<E>>
{
	
	public E getPrioridad();

	public E remove();

	public void Insert(E value);
	
	public boolean isEmpty();
	
	public int size();
	
	public void clear();
}