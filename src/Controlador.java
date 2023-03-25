import java.util.*;
public class Controlador {
    ArbolBinario ingles = new ArbolBinario();
    ArbolBinario español = new ArbolBinario();
    ArbolBinario frances = new ArbolBinario();

    ArrayList<String> Definiciones = new ArrayList<String>();


    String dir = "C:\\Users\\Usuario\\Desktop\\Universidad\\Tercer Semestre\\Datos Compu\\HDT-7\\src\\diccionario.txt";
    public void Iniciar(){
        Reader read = new Reader();
        read.Leer(dir);
        Definiciones = read.lineas;
        for (int i = 0; i <Definiciones.size()-1 ; i++) {
            String[] lenguajesComoArreglo = Definiciones.get(i).split(",");


        }






    }

}
