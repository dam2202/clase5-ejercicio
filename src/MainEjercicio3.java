import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainEjercicio3 {

    public static void main(String[] args) {


        //El codigo funciona, pero tiene un error que no eh encontrado como solucionar me remplaza las 'y' por '_'


        if (args.length < 4) {
            System.out.println("Debe ingresar el tipo de operación (codificar o decodificar), el valor del desplazamiento, la ruta del archivo de entrada, y la ruta del archivo de salida.");
            System.exit(1);
        }
        String tipoOperacion = args[0];
        int desplazamiento = Integer.parseInt(args[1]);
        String archivoEntrada = args[2];
        String archivoSalida = args[3];
        boolean codificar = tipoOperacion.equals("codificar");
        try (Scanner scanner = new Scanner(new File(archivoEntrada))) {
            FileWriter writer = new FileWriter(archivoSalida);
            while (scanner.hasNext()) {
                String palabra = scanner.next();
                StringBuilder resultado = new StringBuilder();
                for (int i = 0; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    if (Character.isLetter(c)) {
                        char cifrado = (char) (c + (codificar ? desplazamiento : -desplazamiento));
                        if ((Character.isUpperCase(c) && cifrado > 'Z') || (Character.isLowerCase(c) && cifrado > 'z')) {
                            cifrado = (char) (c - (26 - (codificar ? desplazamiento : -desplazamiento)));
                        }
                        resultado.append(cifrado);
                    } else {
                        resultado.append(c);
                    }
                }
                writer.write(resultado.toString());
                if (scanner.hasNext()) {
                    writer.write(" ");
                }
            }
            writer.close();
            System.out.println("La operación se ha completado exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de entrada no existe.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir el archivo de salida.");
            System.exit(1);
        }
    }
}
