import java.util.*;

public class MapFactory {
    public static Map<String, Pokemon> getMap(String tipoMapa) {
        switch (tipoMapa.toLowerCase()) {
            case "hashmap":
                return new HashMap<>();
            case "treemap":
                return new TreeMap<>();
            case "linkedhashmap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa inválido: " + tipoMapa);
        }
    }
}
