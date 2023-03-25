import java.util.*;
public class Controlador {
    ArbolBinario ingles_español = new ArbolBinario();
    ArbolBinario ingles_frances = new ArbolBinario();
    ArbolBinario español_ingles = new ArbolBinario();
    ArbolBinario español_frances = new ArbolBinario();
    ArbolBinario frances_ingles = new ArbolBinario();
    ArbolBinario frances_español = new ArbolBinario();
    int Eleccion = 0;

    ArrayList<String> Definiciones = new ArrayList<String>();
    String RespS = "";
    Integer RespI = 0;
    Scanner sc = new Scanner(System.in);
    String String_Builder = "";


    String dir = "C:\\Users\\Usuario\\Desktop\\Universidad\\Tercer Semestre\\Datos Compu\\HDT-7\\HDT-7\\src\\diccionario.txt";
    //Ingles,español,frances
    public void Iniciar(){
        Reader read = new Reader();
        read.Leer(dir);
        Definiciones = read.lineas;
        for (int i = 0; i <Definiciones.size(); i++) {
            String[] arrays = Definiciones.get(i).toLowerCase().split(",");
            ingles_español.insertar(arrays[0],arrays[1]);
            ingles_frances.insertar(arrays[0],arrays[2]);
            español_ingles.insertar(arrays[1],arrays[0]);
            español_frances.insertar(arrays[1],arrays[2]);
            frances_ingles.insertar(arrays[2],arrays[0]);
            frances_español.insertar(arrays[2],arrays[1]);
        }
        System.out.println("Desea traducir una oracion o ver las relaciones de las palabras: 1. Traducir 2. Relacion");
        Eleccion = sc.nextInt();

        if(Eleccion == 1) {
            System.out.println("Elija el idioma que desea traducir su oracion: 1. Ingles, 2. Español, 3. Frances");
            RespI = sc.nextInt();
            System.out.println("Escriba la oracion que desea que se traduzca: ");
            sc.nextLine();
            RespS = sc.nextLine();
            String[] Oracion_Dividida = RespS.split(" ");
            for (int i = 0; i < Oracion_Dividida.length; i++) {
                String temporal = traducir(Oracion_Dividida[i]);
                String_Builder = String_Builder + " " + temporal;
            }
            System.out.println(String_Builder);
        }
        if(Eleccion == 2){
            ingles_español.imprimirRelaciones();
            ingles_frances.imprimirRelaciones();
            español_ingles.imprimirRelaciones();
            español_frances.imprimirRelaciones();
            frances_ingles.imprimirRelaciones();
            frances_español.imprimirRelaciones();

        }

    }
    public String traducir(String palabra){
        String traduccion = null;
        if(ingles_español.buscar(palabra) != null && RespI == 2){
            traduccion = ingles_español.buscar(palabra);
        }
        else if(ingles_frances.buscar(palabra) != null && RespI == 3){
            traduccion = ingles_frances.buscar(palabra);
        }
        else if(español_ingles.buscar(palabra) != null && RespI == 1){
            traduccion = español_ingles.buscar(palabra);
        }
        else if(español_frances.buscar(palabra) != null && RespI == 3){
            traduccion = español_frances.buscar(palabra);
        }
        else if(frances_ingles.buscar(palabra) != null && RespI == 1){
            traduccion = frances_ingles.buscar(palabra);
        }
        else if(frances_español.buscar(palabra) != null && RespI == 2){
            traduccion = frances_español.buscar(palabra);
        }
        else {
            traduccion = "*"+palabra+"*";
        }
        return traduccion;
    }


}
