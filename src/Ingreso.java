public class Ingreso extends Dinero {
    public Ingreso(double ingreso, String description) {
        this.setDinero(ingreso);
        this.setDescription(description);
    }

    @Override
    public String toString() {
        return this.getDescription() + " " + this.getDinero(); 
    }
}