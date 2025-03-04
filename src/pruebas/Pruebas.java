/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import igu.Igu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Mateo
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Igu interfaz = new Igu();
        
        interfaz.setVisible(true);
        /*List <Libro> libros = new ArrayList<>();
        leerArchivo(libros);
        
        for(Libro lib : libros){
            System.out.println(lib.getTitulo());
        }
        //libros.add(new Libro("La odisea", "Homero", "casa blanca", 1940));
        
        //guardaArchivo(libros);*/
        
    }
    
    private static void guardaArchivo(List<Libro> lista){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("\\C:\\Users\\Mateo\\OneDrive\\Documentos\\NetBeansProjects\\Pruebas\\src\\pruebas\\Libros.txt\\",true));
            
            for(Libro libro : lista){
                escritor.write(libro.getTitulo() + "\t" + libro.getAutor() + "\t" + libro.getEditorial() + "\t" + String.valueOf(libro.getAnio()));
                escritor.newLine();
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }
    
    private static void leerArchivo(List<Libro> lista){
        try{
            BufferedReader lector = new BufferedReader(new FileReader("\\C:\\Users\\Mateo\\OneDrive\\Documentos\\NetBeansProjects\\Pruebas\\src\\pruebas\\Libros.txt\\"));
            String linea= "";
            while((linea=lector.readLine())!= null){
                String[] bloques = linea.split("\t");
                if(bloques.length==4){
                    String titulo = bloques[0];
                    String autor = bloques[1];
                    String editorial = bloques[2];
                    int anio = Integer.parseInt(bloques[3]);
                    lista.add(new Libro(titulo,autor,editorial,anio));
                }
                 
            }
        lector.close();
        }catch(IOException e){
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
}
