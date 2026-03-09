public class Main {
    public static void main(String[] args) {
        
        // Crear nuestra Hash Table
        TablaPociones miBiblioteca = new TablaPociones();

        // Se crean un par de objetos Pocion
        Pocion pocion1 = new Pocion("Curacion Menor", "Restaura 20 PV");
        Pocion pocion2 = new Pocion("Veneno Letal", "Drena 5 PV por segundo");
        Pocion pocion3 = new Pocion("Invisibilidad", "El enemigo no puede verte por 15 segundos");

        // Se guardan las pociones en la tabla usando el método insertar
        System.out.println("Guardando pociones en la biblioteca..");
        miBiblioteca.insertar(pocion1.getNombre(), pocion1); 
        miBiblioteca.insertar(pocion2.getNombre(), pocion2);
        miBiblioteca.insertar(pocion3.getNombre(), pocion3);

        System.out.println("LAS POCIONES HAN SIDO GUARDADAS\n");

        String pocionABuscar = "Veneno Letal";
        System.out.println("Buscando: " + pocionABuscar);
        
        Pocion resultado = miBiblioteca.buscar(pocionABuscar);

        if (resultado != null) {
            System.out.println("Poción encontrada");
            System.out.println("Nombre: " + resultado.getNombre());
            System.out.println("Efecto: " + resultado.getEfectoSobreEnemigo());
        } else {
            System.out.println("La poción no existe en la biblioteca o hash table");
        }
    }
}