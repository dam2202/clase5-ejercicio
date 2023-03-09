import java.util.Arrays;
import java.util.Scanner;

public class MainEjercicio1 {
    public static void main(String[] args) {


            //por parámetro ponga 3 números y una letra que represente
            //ascendente o descendente y los muestre ordenados por tal criterio

        /*

        int[] numeros = new int[3];
        for (int i = 0; i < 3; i++) {
            numeros[i] = Integer.parseInt(args[i]);
        }
        if (args[3].equals("asc")) {
            Arrays.sort(numeros);
        } else if (args[3].equals("desc")) {
            Arrays.sort(numeros);
            int[] numerosDescendentes = new int[3];
            for (int i = 0, j = 2; i < 3; i++, j--) {
                numerosDescendentes[i] = numeros[j];
            }
            numeros = numerosDescendentes;
        } else {
            System.out.println("El cuarto parámetro debe ser 'asc' o 'desc'");
            System.exit(1);
        }
        System.out.println("Números ordenados: " + Arrays.toString(numeros));

         */



                 //haga lo mismo, pero solicitando los parámetros de a uno por consola


/*
                Scanner scanner = new Scanner(System.in);
                int[] numeros = new int[3];
                System.out.print("Ingrese el primer número: ");
                numeros[0] = scanner.nextInt();
                System.out.print("Ingrese el segundo número: ");
                numeros[1] = scanner.nextInt();
                System.out.print("Ingrese el tercer número: ");
                numeros[2] = scanner.nextInt();
                System.out.print("Ingrese 'asc' para ordenar ascendentemente o 'desc' para ordenar descendentemente: ");
                String orden = scanner.next();
                if (orden.equals("asc")) {
                    Arrays.sort(numeros);
                } else if (orden.equals("desc")) {
                    Arrays.sort(numeros);
                    int[] numerosDescendentes = new int[3];
                    for (int i = 0, j = 2; i < 3; i++, j--) {
                        numerosDescendentes[i] = numeros[j];
                    }
                    numeros = numerosDescendentes;
                } else {
                    System.out.println("El ordenamiento debe ser 'asc' o 'desc'");
                    System.exit(1);
                }
                System.out.println("Números ordenados: " + Arrays.toString(numeros));
                scanner.close();
*/


        //lo mismo, pero usando los parámetros si hay alguno (como en a) y haciendo (b) si no
        //detecta ninguno. Vea si con una función puede evitar repetir código

        Scanner scanner = new Scanner(System.in);
        int[] numeros;
        String orden;
        if (args.length == 3) {
            numeros = new int[] {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
            orden = leerOrden(scanner);
        } else {
            numeros = leerNumeros(scanner);
            orden = leerOrden(scanner);
        }
        scanner.close();
        int[] numerosOrdenados = ordenarNumeros(numeros, orden);
        System.out.println("Números ordenados: " + Arrays.toString(numerosOrdenados));
    }

    private static int[] leerNumeros(Scanner scanner) {
        int[] numeros = new int[3];
        System.out.print("Ingrese el primer número: ");
        numeros[0] = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        numeros[1] = scanner.nextInt();
        System.out.print("Ingrese el tercer número: ");
        numeros[2] = scanner.nextInt();
        return numeros;
    }

    private static String leerOrden(Scanner scanner) {
        String orden = "";
        while (!orden.equals("asc") && !orden.equals("desc")) {
            System.out.print("Ingrese 'asc' para ordenar ascendentemente o 'desc' para ordenar descendentemente: ");
            orden = scanner.nextLine();
        }
        return orden;
    }

    private static int[] ordenarNumeros(int[] numeros, String orden) {
        int[] numerosOrdenados;
        if (orden.equals("asc")) {
            numerosOrdenados = Arrays.copyOf(numeros, 3);
            Arrays.sort(numerosOrdenados);
        } else if (orden.equals("desc")) {
            numerosOrdenados = new int[3];
            for (int i = 0, j = 2; i < 3; i++, j--) {
                numerosOrdenados[i] = numeros[j];
            }
        } else {
            System.out.println("El ordenamiento debe ser 'asc' o 'desc'");
            System.exit(1);
            return null; // Nunca se llega aquí, pero es necesario para que el compilador no marque error
        }
        return numerosOrdenados;

    }
}