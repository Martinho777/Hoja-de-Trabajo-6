import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PokemonTest {

    private Map<String, Pokemon> pokedex;
    private Set<Pokemon> coleccionUsuario;

    @BeforeEach
    public void setUp() {
        pokedex = new HashMap<>();
        coleccionUsuario = new LinkedHashSet<>();

        // Pokémon de prueba
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, "Grass", "Poison",
                "Seed Pokémon", 0.7, 6.9, "Overgrow, Chlorophyll", 1, "No");
        Pokemon charmander = new Pokemon("Charmander", 4, "Fire", "",
                "Lizard Pokémon", 0.6, 8.5, "Blaze", 1, "No");

        pokedex.put(bulbasaur.getName(), bulbasaur);
        pokedex.put(charmander.getName(), charmander);
    }

    @Test
    public void testAgregarPokemonColeccion() {
        Pokemon p = pokedex.get("Bulbasaur");
        assertFalse(coleccionUsuario.contains(p));

        coleccionUsuario.add(p);
        assertTrue(coleccionUsuario.contains(p));
    }

    @Test
    public void testBuscarPokemonPorHabilidad() {
        List<String> encontrados = new ArrayList<>();
        String habilidadBuscada = "chlorophyll";

        for (Pokemon p : pokedex.values()) {
            if (p.getAbilities().toLowerCase().contains(habilidadBuscada)) {
                encontrados.add(p.getName());
            }
        }

        assertEquals(1, encontrados.size());
        assertEquals("Bulbasaur", encontrados.get(0));
    }
}
