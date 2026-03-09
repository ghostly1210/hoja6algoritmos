public class TablaPociones {

    // ATRIBUTOS
    private Nodo[] arreglo;

    // Constructor de la tabla
    public TablaPociones() {
        int capacidad = 10;
        
        arreglo = new Nodo[capacidad];
    }

    class Nodo{
        // la llave es un atributo del objeto completo con el que se quiere trabajar 
        // es una manera más fácil de poder calcular los índices
        String llave;

        // El valor es el objeto completo del que sale la llave, que es lo que se almacena dentro de los nodos
        Pocion valor;

        // Se refiere al nodo siguiente al que se apunta, que es lo que genera la lista enlazada 
        Nodo siguiente;

        // importante saber que el nodo se manjea como un paquete, donde el contenido, o sea el objeto, está dentro del paquete
        // mientras que la llave sería como la etiqueta que tiene para buscarlo como el nombre del dueño del paquete
    }

    private int generarHash(String llave) {
        // Obtenemos el tamaño del arreglo
        int capacidad = arreglo.length;

        // Se calcula la longitud de la palabra
        int longitud = llave.length();
        int sumaAscii = 0;

        // Validación para extraer el ASCII
        if (longitud >= 2) {
            // Si tiene 2 o más letras, se suma el ASCII de las dos primeras
            sumaAscii = llave.charAt(0) + llave.charAt(1);
        } else if (longitud == 1) {
            // Si por alguna razón solo tiene una letra, se toma solo esa
            sumaAscii = llave.charAt(0);
        }

        // La formula que decidimos utilizar: (longitud + sumaAscii) dividido por capacidad, tomando el residuo
        int indiceFinal = (longitud + sumaAscii) % capacidad; 

        return indiceFinal;
    }

    public void insertar(String llave, Pocion nuevaPocion) {
        // Calculamos el índice usando la función hash
        int indice = generarHash(llave);

        // Se prepara el nuevo nodo con su información
        // donde se enlaza toda la información de la nueva poción a insertar al nuevo nodo
        // es como meter el contenido del paquete dentro de la caja
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.llave = llave;
        nuevoNodo.valor = nuevaPocion;
        nuevoNodo.siguiente = null; // Como es nuevo, aún no se engancha a nada

        // Se revisa el índice en el arreglo
        if (arreglo[indice] == null) {

            // CASO 1, El índice está vacío. Se deja el paquete o bloque o nodo aquí
            arreglo[indice] = nuevoNodo;
            
        } else {
            // CASO 2, hay colisión porque ya hay un nodo aquí
            // Se crea una variable de referencia llamada actual para caminar por los paquetes o nodos
            Nodo actual = arreglo[indice];

            // es posible utilizar while( actual != null )
            boolean insertado = false;
            while (!insertado) {

                // Si resulta que la llave ya existía, actualizamos la poción 
                if (actual.llave.equals(llave)) {
                    actual.valor = nuevaPocion;
                    insertado = true; // Salimos del método
                }

                // Si llegamos al último bloque o nodo de la fila
                else if (actual.siguiente == null) {
                    // Enganchamos nuestro nuevo bloque o nodo al final y terminamos
                    actual.siguiente = nuevoNodo;
                    insertado = true; // Salimos del método
                }

                // Si no era la misma llave y no estamos al final, caminamos al siguiente bloque o nodo
                else {
                    actual = actual.siguiente;
                }
            }
        }
    }


    public Pocion buscar(String llave) {
        // se calcula el índice
        int indice = generarHash(llave);
        
        // Nos paramos en el primer nodo o vagón del índice
        Nodo actual = arreglo[indice];
        
        // se recorre el arreglo
        while (actual != null) {
            
            // Se comprueba si la llave del nodo actual es igual a la llave que se busca
            if (actual.llave.equals(llave)) {
                
                // Se devuelve el objeto pocion, no el nodo
                return actual.valor;
            }
            
            
            // Si no son iguales, avanzamos al siguiente bloque o vagón o nodo
            actual = actual.siguiente;
        }
        
        // Si el bucle while termina y se llega a este punto, significa que la poción no estaba
        return null; 
    }
}


