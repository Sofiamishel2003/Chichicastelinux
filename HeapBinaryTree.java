import java.util.Vector;

public class HeapBinaryTree<E extends Comparable<E>> implements IHeap<E>
{

	protected Vector<E> data; 

	public HeapBinaryTree()
	{
		data = new Vector<E>();
	}

	public HeapBinaryTree(Vector<E> v)
	{
		int i;
		data = new Vector<E>(v.size()); 
		for (i = 0; i < v.size(); i++)
		{
			Insert(v.get(i));
		}
	}

	protected static int parent(int i)
	{
		return (i-1)/2;
	}

	protected static int left(int i)
	{
		return 2*i+1;
	}

	protected static int right(int i)
	{
		return (2*i+1) + 1;
	}

	protected void percolateUp(int leaf)
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

	public void Insert(E value)
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

	protected void pushDownRoot(int root)
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; 
			} else { 
				data.set(root,value);
				return;
			}
			} else { 
				data.set(root,value);
				return;
			}
		}
	}


	public E remove()
	{
		E minVal = getPrioridad();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

	public E getPrioridad() {
		E first = null;
		
		if((data.size()) > 0){
			first = data.get(0);
			return first;
		}
		
		return first;
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public int size() {
		return data.size();
	}

	public void clear() {
		
	}
}
