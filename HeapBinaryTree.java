import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author moises.alonso
 *
 */
public class HeapBinaryTree<P, V> implements IHeap<P, V> {

	private int _count;
	private TreeNode<P, V> _root;
	private Comparator<P> _priorityComparator;
	
	public HeapBinaryTree() {
		this(new Comparator<Proceso>() {
			@Override
			public int compare(Proceso p1, Proceso p2) {
				return Integer.compare(p2.getPrioridad(), p1.getPrioridad());
			}
		});
	}
	
	public HeapBinaryTree(Comparator<Proceso> priorityComparator) {
		_count = 0;
		count=0;
		count1=0;
		_priorityComparator = (Comparator<P>) priorityComparator;
	}

	@Override
	public void Insert(P priority, V value) {
		TreeNode<P, V> newNode = new TreeNode<P, V>(priority, value);

		if (_root == null) { // tree is empty
			_root = newNode;
			_count++;
			return;
		}

		// find the position to insert the new node
		Queue<TreeNode<P, V>> queue = new LinkedList<>();
		queue.add(_root);

		while (!queue.isEmpty()) {
			TreeNode<P, V> current = queue.remove();

			if (current.get_left() == null) {
				current.set_left(newNode);
				newNode.set_parent(current);
				_count++;
				break;
			} else if (current.get_right() == null) {
				current.set_right(newNode);
				newNode.set_parent(current);
				_count++;
				break;
			} else {
				queue.add(current.get_left());
				queue.add(current.get_right());
			}
		}

		// restore the heap property by swapping the new node with its siblings
		TreeNode<P, V> current = newNode;

		while (current.get_parent() != null && _priorityComparator.compare(current.get_priority(), current.get_parent().get_priority()) > 0) {
			Swap(current);
			current = current.get_parent();
		}

		while (current.get_parent() != null && current.get_parent().get_left() != null && _priorityComparator.compare(current.get_priority(), current.get_parent().get_left().get_priority()) > 0) {
			Swapleft(current);
			current = current.get_parent().get_left();
		}
		
	}

	
	private void Swap(TreeNode<P, V> actualNode) {
		if (actualNode != null) {
			
			if (actualNode.get_parent() != null) { //is not the root
				
				int result = _priorityComparator.compare(actualNode.get_priority(), actualNode.get_parent().get_priority());
				
				if (result > 0) { //if child is greater than parent
					P tempP = actualNode.get_priority();
					V tempV = actualNode.get_value();
					
					actualNode.set_priority(actualNode.get_parent().get_priority());
					actualNode.set_value(actualNode.get_parent().get_value());
					
					actualNode.get_parent().set_priority(tempP);
					actualNode.get_parent().set_value(tempV);
				}
				
			}
			
		}
	}

	private void Swapleft(TreeNode<P, V> actualNode) {
		if (actualNode != null) {
			
			if (actualNode.get_parent() != null) { //is not the root
				
				int result = _priorityComparator.compare(actualNode.get_priority(), actualNode.get_parent().get_left().get_priority());
				
				if (result > 0) { //if child is greater than parent
					P tempP = actualNode.get_priority();
					V tempV = actualNode.get_value();
					
					actualNode.set_priority(actualNode.get_parent().get_left().get_priority());
					actualNode.set_value(actualNode.get_parent().get_left().get_value());
					
					actualNode.get_parent().get_left().set_priority(tempP);
					actualNode.get_parent().get_left().set_value(tempV);
				}
				
			}
			
		}
	}

	@Override
	public V get() {
		if (isEmpty())
			return null;
		else 
			return _root.get_value();
	}
	int count;
	int count1;
	

	@Override
	public P getPrioridad() {
		if (isEmpty()) {
			return null;
		}
		
		P maxPriority = _root.get_priority();
		TreeNode<P, V> currentNode = _root;
		
		while (currentNode != null) {
			if (currentNode.get_left() != null && 
				_priorityComparator.compare(currentNode.get_left().get_priority(), maxPriority) > 0) {
				maxPriority = currentNode.get_left().get_priority();
				currentNode = currentNode.get_left();
			} else if (currentNode.get_right() != null && 
					_priorityComparator.compare(currentNode.get_right().get_priority(), maxPriority) > 0) {
				maxPriority = currentNode.get_right().get_priority();
				currentNode = currentNode.get_right();
			} else {
				break;
			}
		}
		
		return maxPriority;
	}

	@Override
	public V remove() {
		if (isEmpty()) {
			return null;
		}
	
		V rootValue = _root.get_value();
	
		// Remove the root node
		boolean rootRemoved = false;
		while (!rootRemoved) {
			TreeNode<P, V> temp = _root;
			if (temp._left != null) {
				_root = temp._left;
				if (temp._right != null) {
					// Find the rightmost node in the left subtree
					TreeNode<P, V> rightmost = _root;
					while (rightmost._right != null) {
						rightmost = rightmost._right;
					}
	
					// Attach the right subtree to the right of the rightmost node
					rightmost._right = temp._right;
				}
			} else if (temp._right != null) {
				_root = temp._right;
			} else {
				_root = null;
			}
			rootRemoved = true;
		}
	
		// Restore heap property
		TreeNode<P, V> actual = _root;
		while (actual != null) {
			Swap(actual);
			actual = actual.get_parent();
		}
	
		_count--;
	
		return rootValue;
	}


	@Override
	public int count() {
		return _count;
	}

	@Override
	public boolean isEmpty() {
		return _count == 0;
	}

}