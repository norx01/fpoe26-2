package mvc.model;

public class Aerolinea
{
    //Atributos
    private String nombre;
    private String codigo;
    private int cantidadAviones;
    private String tipoOperacion;
    private String paisOrigen;

    //Constructor
    public Aerolinea(String nombre, String codigo, int cantidadAviones, String tipoOperacion, String paisOrigen) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadAviones = cantidadAviones;
        this.tipoOperacion = tipoOperacion;
        this.paisOrigen = paisOrigen;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidadAviones() {
        return cantidadAviones;
    }

    public void setCantidadAviones(int cantidadAviones) {
        this.cantidadAviones = cantidadAviones;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
