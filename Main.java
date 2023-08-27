import java.io.File;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String objetivo = "";
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese nombre para el archivo:");
        String nombreArchivo = scan.nextLine();
        scan.close();



        File directorioActual = new File(Paths.get(".").toAbsolutePath().normalize().toString());


        try {
            String rutaActual = Paths.get(".").toAbsolutePath().normalize().toString();
            // Construye la ruta para el directorio y el archivo
            File directorio = new File(rutaActual + "/../../../../assets/locale");
            File locale;
            FileWriter escriba;

            if(!directorio.exists()){
                directorio.mkdirs(); // Crea los directorios necesarios
                System.out.println("Se ha creado la ruta en: ");
                System.out.println(directorio.getAbsolutePath());
                locale = new File(directorio, nombreArchivo + ".properties");
                File archivo = new File(directorio.getAbsolutePath()+ "/"+ nombreArchivo + ".properties");
                if(archivo.exists()){
                    System.out.println("Ya existe el archivo");
                    escriba = new FileWriter(archivo,true);
                }else{
                    System.out.println("El archivo no existia y se ha creado");
                    escriba = new FileWriter(archivo);
                }
            }else{
                System.out.println("Existe la ruta");
                File archivo = new File(directorio.getAbsolutePath()+ "/"+ nombreArchivo + ".properties");
                if(archivo.exists()){
                    System.out.println("Ya existe el archivo");
                    escriba = new FileWriter(archivo,true);
                }else{
                    System.out.println("El archivo no existia y se ha creado");
                    escriba = new FileWriter(archivo);
                }
            }
       
            mostrarDirectorio(directorioActual, escriba);
            escriba.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarDirectorio(File directorio, FileWriter escriba){//Funcion recursiva
                File elementos[] = directorio.listFiles(); //iguala los elementos del directorio pasado por parametro a un array de File
                for (File elemento : elementos) {   //por cada elementos se fija si el elemento es un archivo y lo imprime
                   if(elemento.isFile()){
                    //System.out.println(elemento);
                    leer_Y_Escribir(elemento, escriba);
                   }else if(elemento.isDirectory()){    //si el elementos es un direcotirio, vuelve a llamarse para volver a hacer lo de arriba
                    mostrarDirectorio(elemento.getAbsoluteFile(), escriba);
                   }
                }
    }

    public static void leer_Y_Escribir(File archivo, FileWriter escriba){
        try {
        Scanner s = new Scanner(archivo);
        while (s.hasNextLine()) {

            String linea = s.nextLine();
            if (linea.contains(".createBundle")) {//Busca si dentro de cada linea aparece ".createBundle", esto le permite saber que nombre le asignaste a la variable del tipo I18NBundle
                int indexInicio = linea.indexOf("e");//En la linea que encontro lo que buscaba saca el indice de poscion de la "e" (I18NBundl"e")
                int indexFin = linea.indexOf("=");//Luego el indice del "=" (I18NBundle ***** "=" new ...)
                objetivo = linea.substring(indexInicio + 2, indexFin - 1);//El objetivo es lo que se encuentre entre los indices inical+2 y final-1 (por los espacios)
                //System.out.println(objetivo);
            }

            // Buscar la palabra en la línea
            if (linea.contains(objetivo + ".get(")) {//Busca si dentro de cada linea aparece el objetivo ya encontrado antes + ".get(", por ejemplo "bundle.get(" o "plinplin.get("
                int indiceInicio = linea.indexOf("\"") + 1; // Encontrar el indice de las comillas ej: "hud.titulo"
                int indiceFin = linea.indexOf("\"", indiceInicio); // Encontrar el índice de fin de las comillas ej: "hud.titulo"
                //System.out.println(indiceInicio);
                String pedazoRecortado = linea.substring(indiceInicio, indiceFin); // Extrae lo que hay entre comillas ej: hud.titulo
                System.out.println(pedazoRecortado);
                escriba.append(pedazoRecortado + "=\n");
            }
        }
        s.close();

    }
        catch(Exception e) {

        }
    }
    
}
