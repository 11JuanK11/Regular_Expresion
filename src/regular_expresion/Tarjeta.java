
package regular_expresion;

public class Tarjeta {
    private String Tipo;
    private String Numero;
    private String Fecha;
    private String Nombre;
    private String Apellido;
    private String Codigo;

    public Tarjeta(String Tipo, String Numero, String Fecha, String Nombre, String Apellido, String Codigo) {
        this.Tipo = Tipo;
        this.Numero = Numero;
        this.Fecha = Fecha;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Codigo = Codigo;
    }
    
    public Tarjeta() {
    this.Tipo = "";
    this.Numero = "";
    this.Fecha = "";
    this.Nombre = "";
    this.Apellido = "";
    this.Codigo = "";
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    
}
