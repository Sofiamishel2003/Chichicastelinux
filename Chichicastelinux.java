
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Chichicastelinux {
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
                /* 
                    Archivos file =new Archivos();
                    ArrayList<String> lineas= file.read_file("procesos.txt");
                    for (int i = 0; i <= lineas.size()-1; i++) 
                    {   
                        System.out.println(lineas.get(i)); //hace el proceso linea por linea
                    }*/
                    Archivos archivos = new Archivos();
                    ArrayList<String> lineas = archivos.read_file("procesos.txt");
                    ArrayList<Proceso> procesos = new ArrayList<>();
                    

                    for (String linea : lineas) {
                        String[] datos = linea.split(",");
                        String proceso = datos[0];
                        String nombre = datos[1];
                        int nice = Integer.parseInt(datos[2]);
                        Proceso p = new Proceso(proceso, nombre, nice);
                        procesos.add(p);
                    }
                    
                    HeapBinaryTree<Proceso, Integer> heap = new HeapBinaryTree<Proceso, Integer>();


                    for (Proceso proceso : procesos) {
                        heap.Insert(proceso, proceso.getPrioridad());
                    }

                    while (!heap.isEmpty()) {
                        System.out.println(heap.remove());
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

