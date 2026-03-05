public class Pocion {

    private String nombre, efectoSobreEnemigo;

    public Pocion(String nombre, String efectoSobreEnemigo){

        this.nombre = nombre;
        this.efectoSobreEnemigo = efectoSobreEnemigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getEfectoSobreEnemigo(){
        return this.efectoSobreEnemigo;
    }

}