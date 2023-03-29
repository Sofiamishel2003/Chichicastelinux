
import java.util.ArrayList;
import java.util.Scanner;
public class Chichicastelinux {
    public static void main(String[] args)
    {
        String[] values;
        String key;
        String value;
        Scanner in = new Scanner(System.in);
        int e=0;
        while (e!=2)
        {
            System.out.println("Chichicaste Linux--------- \n Escoge una opcion\n 1.Ir al chichicasteLinux\n 2.Salir");
            e=in.nextInt();
            switch (e)
            {
                case 1:
                    Archivos file =new Archivos();
                    ArrayList<String> lineas= file.read_file("procesos.txt");
                    for (int i = 0; i <= lineas.size()-1; i++) 
                    {   
                        System.out.println(lineas.get(i)); //hace el proceso linea por linea
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

