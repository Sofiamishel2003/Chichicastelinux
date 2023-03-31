
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class ChichicasteLinux_PriorityQueue {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int e=0;
        //HeapBinaryTree<String, String> heap = new HeapBinaryTree<>(null);
        while (e!=2)
        {
            System.out.println("Chichicaste Linux--------- \n Escoge una opcion\n 1.Ir al chichicasteLinux\n 2.Salir");
            e=in.nextInt();
            switch (e)
            {
                case 1:
                
                    Archivos archivos = new Archivos();
                    ArrayList<String> lineas = archivos.read_file("procesos.txt");
                    PriorityQueue<Proceso> Lista_prioridad = new PriorityQueue<>();
                    for (String linea : lineas) {
                        String[] datos = linea.split(",");
                        String proceso = datos[0];
                        String nombre = datos[1];
                        int nice = Integer.parseInt(datos[2]);
                        Lista_prioridad.add(new Proceso(proceso, nombre, nice));
                    }
                    while (!Lista_prioridad.isEmpty())
                    {
                        Proceso pri = Lista_prioridad.poll();;
                        System.out.println(pri.getProceso()+", "+pri.getNombre()+", "+pri.getNice()+", PR = "+pri.getPrioridad());
                    }   
                    break;
                case 2:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion ingresada invalida");
                    break;
            }
        }
    }
}
