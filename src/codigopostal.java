import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class codigopostal {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\figur\\Downloads\\codigos_postales_hmo.csv";

        ArrayList<String> codigosPostales = new ArrayList<>();
        ArrayList<Integer> conteos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length >= 2) {
                    String codigoPostal = datos[0].trim();

                    int indice = codigosPostales.indexOf(codigoPostal);
                    if (indice != -1) {
                        conteos.set(indice, conteos.get(indice) + 1);
                    } else {
                        codigosPostales.add(codigoPostal);
                        conteos.add(1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < codigosPostales.size(); i++) {
            System.out.println("Código postal: " + codigosPostales.get(i) +
                    " - Número de asentamientos: " + conteos.get(i));
        }
    }
}