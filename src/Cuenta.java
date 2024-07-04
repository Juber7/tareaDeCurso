import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    class GastoException extends Exception {
        public GastoException() {
        }
    }

    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public Cuenta(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 0;
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double addIngresos(String descripcion, double cantidad) {
        this.setSaldo(this.getSaldo() + cantidad);
        this.ingresos.add(new Ingreso(cantidad, descripcion));
        return this.getSaldo();
    }

    public double addGastos(String descripcion, double cantidad) throws GastoException {
        if (this.getSaldo() < cantidad) {
            throw new GastoException();
        }
        this.setSaldo(this.getSaldo() - cantidad);
        this.gastos.add(new Gasto(cantidad, descripcion));
        return this.getSaldo();
    }

    public List<Gasto> getGastos() {
        return gastos;
    }


    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", usuario=" + usuario +
                ", gastos=" + gastos +
                ", ingresos=" + ingresos +
                '}';
}
}
