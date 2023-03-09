import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainEjercicio2 {

    public static void main(String[] args) {

        /*

        if (args.length == 0) {
            System.out.println("Debe ingresar la ruta del archivo como parámetro.");
            System.exit(1);
        }
        String archivo = args[0];
        int suma = 0;
        try (Scanner scanner = new Scanner(new File(archivo))) {
            while (scanner.hasNextInt()) {
                suma += scanner.nextInt();
            }
            System.out.println("La suma de los números en el archivo es: " + suma);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe o no se puede leer.");
            System.exit(1);
        }

         */


        //Recuerde ingresar los parametros del archivo y de la operacion a realizar " suma o multiplicacion"

        if (args.length < 2) {
            System.out.println("Debe ingresar la ruta del archivo y la operación a realizar (suma o multiplicación).");
            System.exit(1);
        }
        String archivo = args[0];
        String operacion = args[1];
        int resultado = 0;
        try (Scanner scanner = new Scanner(new File(archivo))) {
            while (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                if (operacion.equals("suma")) {
                    resultado += numero;
                } else if (operacion.equals("multiplicacion")) {
                    if (resultado == 0) {
                        resultado = 1;
                    }
                    resultado *= numero;
                } else {
                    System.out.println("La operación debe ser 'suma' o 'multiplicacion'.");
                    System.exit(1);
                }
            }
            System.out.println("El resultado de la operación " + operacion + " en el archivo es: " + resultado);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe o no se puede leer.");
            System.exit(1);
        }


    }
}