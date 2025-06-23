public class Comida {
    private String nombre;
    private int calorias;
    private String tipo;// entrda/principal/postre
    public Comida(String nombre, int calorias, String tipo){
        this.calorias = calorias;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalorias() {
        return calorias;
    }
    public String getTipo(){
        return tipo;
    }
    @Override
    public String toString(){
        return "Tipo: " + tipo + " ---   Comida: " + nombre + " ---   calorias: " + calorias ;
    }
}
