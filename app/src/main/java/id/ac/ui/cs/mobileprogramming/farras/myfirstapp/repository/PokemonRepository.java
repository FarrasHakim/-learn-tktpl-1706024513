package id.ac.ui.cs.mobileprogramming.farras.myfirstapp.repository;

import id.ac.ui.cs.mobileprogramming.farras.myfirstapp.models.Pokemon;

import java.util.List;

public class PokemonRepository {

    private List<Pokemon> pokemonList;

    public PokemonRepository() {
        pokemonList.add(new Pokemon(1, "Squirtle", "Water", "A squirrel and turtle half breed"));
        pokemonList.add(new Pokemon(2, "Charmander", "Fire", "A smol fire gecko"));
        pokemonList.add(new Pokemon(3, "Bulbasaur", "Grass", "A smol frog infected with a plant"));
        pokemonList.add(new Pokemon(4, "Pikachu", "Lightning", "A lightning mouse pokemon"));
        pokemonList.add(new Pokemon(5, "Pidgey", "Flying", "Basically an eagle but with stylish hair"));
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
