public class Gasto extends Dinero {
    
    public Gasto(double gasto, String descripcion) {
        this.setDinero(gasto);
        this.setDescription(descripcion);
    }

    @Override
    public String toString() {
        return this.getDescription() + " " + this.getDinero();
    }
}
