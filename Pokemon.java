public class Pokemon {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private String abilities;
    private int generation;
    private String legendaryStatus;

    public Pokemon(String name, int pokedexNumber, String type1, String type2,
                   String classification, double height, double weight,
                   String abilities, int generation, String legendaryStatus) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    // Getters
    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getAbilities() { return abilities; }

    @Override
    public String toString() {
        return "Nombre: " + name + "\nPokedex #: " + pokedexNumber +
               "\nTipo1: " + type1 + "\nTipo2: " + type2 +
               "\nClasificacion: " + classification +
               "\nAltura: " + height + " m\nPeso: " + weight + " kg" +
               "\nHabilidades: " + abilities +
               "\nGeneracion: " + generation +
               "\nLegendario: " + legendaryStatus;
    }
}
