public class TablaPociones {

    // ATRIBUTOS
    private Nodo[] arreglo;

    // Constructor de la tabla
    public TablaPociones() {
        int capacidad = 10;
        
        arreglo = new Nodo[capacidad];
    }

    class Nodo{
        String llave;
        Pocion valor;
        Nodo siguiente;
    }
}


