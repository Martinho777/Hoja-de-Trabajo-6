import java.io.*;
import java.util.*;

public class LectorCSV {

    public void cargarPokemonsDesdeArchivo(String PokemonData, Map<String, Pokemon> pokedex) {
        try (BufferedReader br = new BufferedReader(new FileReader(PokemonData))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",", -1);
                if (datos.length < 10) continue;

                try {
                    String name = datos[0].trim();
                    int pokedexNum = parseIntSafe(datos[1]);
                    String type1 = datos[2].trim();
                    String type2 = datos[3].trim();
                    String classification = datos[4].trim();
                    double height = parseDoubleSafe(datos[5]);
                    double weight = parseDoubleSafe(datos[6]);

                    String abilities;
                    int generation;
                    String legendaryStatus;

                    if (datos.length == 10) {
                        abilities = datos[7].trim();
                        generation = parseIntSafe(datos[8]);
                        legendaryStatus = datos[9].trim();
                    } else if (datos.length == 11) {
                        abilities = datos[7].trim() + ", " + datos[8].trim();
                        generation = parseIntSafe(datos[9]);
                        legendaryStatus = datos[10].trim();
                    } else {
                        continue;
                    }

                    Pokemon p = new Pokemon(name, pokedexNum, type1, type2, classification,
                            height, weight, abilities, generation, legendaryStatus);

                    pokedex.put(name, p);

                } catch (Exception e) {
                    System.out.println("LInea con error ignorada: " + linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private double parseDoubleSafe(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }
}