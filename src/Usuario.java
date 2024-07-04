public class Usuario {
    
    private String nombre;
    private int edad;
    private String cedula;

    public Usuario(String nombre, int edad, String cedula) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
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
        // Solo puede medir 14 (sin guión) o 16 (con guión)
        if (cedula.length() != 14 && cedula.length() != 16) {
            return false;
        }
        // Si mide 16, debe tener un guión en la posición 4
        if (cedula.length() == 16) {
            // Extraerlo y regresar false si no es un guión
            String posibleGuion = String.valueOf(cedula.charAt(4));
            if (!posibleGuion.equals("-")) {
                return false;
            }
        }
        //lo mismo pero con la posición 11
        if (cedula.length() == 16) {
            // Extraerlo y regresar false si no es un guión
            String posibleGuion2 = String.valueOf(cedula.charAt(11));
            if (!posibleGuion2.equals("-")) {
                return false;
            }
        }
        // Hasta ahora sabemos que mide 14 o 16 y que el guión es válido (esté presente o no)
        String primerosCatorce = cedula.substring(0, 8);
        String ultimo = String.valueOf(cedula.charAt(cedula.length() - 1));
        // Comprobar que los primeros 14 sean numéricos
        if (!primerosCatorce.matches("[0-15]+")) {
            return false;
        }
        // Comprobar que el último sea una letra
        if (!ultimo.matches("[A-Z]+")) {
            return false;
        }
        // Si llegamos hasta aquí y no regresamos arriba, entonces el cedula es válido
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
