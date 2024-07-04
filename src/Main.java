import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Cuenta.GastoException {
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = new Usuario();
        System.out.print("Ingrese su nombre: ");
        usuario.setNombre(scanner.nextLine());
        System.out.print("Ingrese su edad: ");
        usuario.setEdad(scanner.nextInt());
        scanner.nextLine();

        boolean cedulaValida = false;
        while (!cedulaValida) {
            System.out.print("Ingrese su cédula: ");
            String cedula = scanner.nextLine();
            cedulaValida = usuario.setCedula(cedula);
            if (!cedulaValida) {
                System.out.println("Cédula no válida, intente de nuevo.");
            }
        }

        Cuenta cuenta = new Cuenta(usuario);

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Registrar ingreso");
            System.out.println("2. Registrar gasto");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la descripción del ingreso: ");
                    String descripcionIngreso = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del ingreso: ");
                    double cantidadIngreso = scanner.nextDouble();
                    cuenta.addIngresos(descripcionIngreso, cantidadIngreso);
                    System.out.println("Ingreso registrado.");
                    break;
                case 2:
                    System.out.print("Ingrese la descripción del gasto: ");
                    String descripcionGasto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del gasto: ");
                    double cantidadGasto = scanner.nextDouble();
                    cuenta.addGastos(descripcionGasto, cantidadGasto);
                    System.out.println("Gasto registrado.");
                    break;
                case 3:
                    System.out.println("Saldo actual: " + cuenta.getSaldo());
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        scanner.close();
    }
}