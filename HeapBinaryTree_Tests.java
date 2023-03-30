import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
public class HeapBinaryTree_Tests {

    @Test
    public void testInsert() {
        HeapBinaryTree<Proceso> heap = new HeapBinaryTree<Proceso>();
        Proceso p1 = new Proceso("ls", "maria30", -20);
        Proceso p2 = new Proceso("vi", "pinkcy12", -10);
        ArrayList<Proceso> procesos = new ArrayList<>();
        procesos.add(p1);
        procesos.add(p2);
        for (Proceso proceso : procesos) {
            heap.Insert(proceso);
        }
        Proceso pri=heap.getPrioridad();
        assertEquals("maria30", pri.getNombre());
    }

    @Test
    public void testremove() {
        HeapBinaryTree<Proceso> heap = new HeapBinaryTree<Proceso>();
        Proceso p1 = new Proceso("ls", "maria30", -20);
        Proceso p2 = new Proceso("vi", "pinkcy12", -10);
        ArrayList<Proceso> procesos = new ArrayList<>();
        procesos.add(p1);
        procesos.add(p2);
        for (Proceso proceso : procesos) {
            heap.Insert(proceso);
        }
        heap.remove();
        Proceso pri=heap.getPrioridad();
        assertEquals("pinkcy12", pri.getNombre());
  }
  public void testIsEmpty() {
    HeapBinaryTree<Proceso> heap = new HeapBinaryTree<Proceso>();
    assertEquals(true, heap.isEmpty());
}
}
