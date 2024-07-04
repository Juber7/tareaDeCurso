public class Ingreso extends Dinero {
    
    public Ingreso(double ingreso, String descripcion) {
        this.setDinero(ingreso);
        this.setDescription(descripcion);
    }

    @Override
    public String toString() {
        return this.getDescription() + " " + this.getDinero();
    }
}
