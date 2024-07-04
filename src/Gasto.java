public class Gasto extends Dinero {
    public Gasto(double gasto, String description) {
        this.setDinero(gasto);
        this.setDescription(description);
    }

    @Override
    public String toString() {
        return this.getDescription() + " " + this.getDinero();
    }
}
