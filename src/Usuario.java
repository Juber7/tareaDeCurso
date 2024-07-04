
public class Usuario {
    private String nombre;
    private int edad;
    private String cedula;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public boolean setCedula(String cedula) {

        if (cedula.length() != 14 && cedula.length() != 16) {
            return false;
        }

        if (cedula.length() == 16) {
            if (cedula.charAt(4) != '-' || cedula.charAt(11) != '-') {
                return false;
            }
        }

        String cedulaSinGuiones = cedula.replace("-", "");
        String primerosTrece = cedulaSinGuiones.substring(0, 13);
        String ultimo = cedulaSinGuiones.substring(13);

        if (!primerosTrece.matches("\\d+")) {
            return false;
        }

        if (!ultimo.matches("[A-Z]")) {
            return false;
        }

        this.cedula = cedula;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}