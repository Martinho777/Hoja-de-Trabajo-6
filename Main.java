import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Se elige el tipo de mapa
        System.out.println("Selecciona el tipo de Mapa que vas a usar: HashMap, TreeMap o LinkedHashMap: ");
        String tipoMapa = scanner.nextLine();
        Map<String, Pokemon> pokedex = MapFactory.getMap(tipoMapa);

        // Cargar Pokémon desde archivo CSV usando LectorCSV
        LectorCSV lector = new LectorCSV();
        lector.cargarPokemonsDesdeArchivo("PokemonData.csv", pokedex);

        // Coleccion del usuario
        Set<Pokemon> coleccionUsuario = new LinkedHashSet<>();

        // Menú principal
        int opcion = 0;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Agregar Pokémon a la coleccion");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar coleccion del usuario (nombre y tipo1)");
            System.out.println("4. Mostrar todos los Pokémon (nombre y tipo1, ordenados por tipo1)");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Pokémon a agregar: ");
                    String nombreAgregar = scanner.nextLine().trim();
                    Pokemon p = pokedex.get(nombreAgregar);
                    if (p == null) {
                        System.out.println("¡Ese Pokémon no existe!");
                    } else if (coleccionUsuario.contains(p)) {
                        System.out.println("¡Ya lo tienes en tu colección!");
                    } else {
                        coleccionUsuario.add(p);
                        System.out.println(nombreAgregar + " agregado a tu colección.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del Pokémon a consultar: ");
                    String nombreBuscar = scanner.nextLine().trim();
                    Pokemon buscado = pokedex.get(nombreBuscar);
                    if (buscado != null) {
                        System.out.println("\n=== DATOS DEL POKÉMON ===");
                        System.out.println(buscado);
                    } else {
                        System.out.println("¡Ese Pokémon no existe!");
                    }
                    break;

                case 3:
                    System.out.println("\n=== COLECCIÓN DEL USUARIO (ordenada por tipo1) ===");
                    coleccionUsuario.stream()
                        .sorted(Comparator.comparing(Pokemon::getType1))
                        .forEach(poke -> System.out.println(poke.getName() + " - " + poke.getType1()));
                    break;

                case 4:
                    System.out.println("\n=== TODOS LOS POKÉMON (ordenados por tipo1) ===");
                    pokedex.values().stream()
                        .sorted(Comparator.comparing(Pokemon::getType1))
                        .forEach(poke -> System.out.println(poke.getName() + " - " + poke.getType1()));
                    break;

                case 5:
                    System.out.print("Ingrese habilidad a buscar: ");
                    String habilidad = scanner.nextLine().trim().toLowerCase();
                    System.out.println("\n=== POKÉMON CON HABILIDAD: " + habilidad + " ===");
                    boolean encontrado = false;
                    for (Pokemon poke : pokedex.values()) {
                        if (poke.getAbilities().toLowerCase().contains(habilidad)) {
                            System.out.println(poke.getName());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ningún Pokémon tiene esa habilidad.");
                    }
                    break;

                case 6:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}
