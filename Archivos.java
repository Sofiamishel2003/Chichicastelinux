//
//
//  @ Project : Chichicastelinux.java
//  @ File Name : Archivos.java
//  @ Date : 03/04/2023
//  @ Author : Sofía Velásquez y Nicolle Gordillo
//
//
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; //Import the scanner to read the file
import java.util.ArrayList; //Import Arraylist
public class Archivos {
    private ArrayList<String> lineas;
    private  String path;
    public Archivos()
    {
        lineas = new ArrayList<String>();
        path="";

    }
    public ArrayList<String> read_file(String direccion) {
        File file = new File(direccion);
        try {
            Scanner obj = new Scanner(file);
            while (obj.hasNextLine()){
                String linea=obj.nextLine();
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
}
