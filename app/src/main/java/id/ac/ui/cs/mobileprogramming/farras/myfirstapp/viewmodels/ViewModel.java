package id.ac.ui.cs.mobileprogramming.farras.myfirstapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import id.ac.ui.cs.mobileprogramming.farras.myfirstapp.models.Pokemon;
import id.ac.ui.cs.mobileprogramming.farras.myfirstapp.repository.PokemonRepository;

import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<Pokemon> selected = new MutableLiveData<Pokemon>();

    private PokemonRepository repository = new PokemonRepository();

    public void select(Pokemon pokemon) {
        selected.setValue(pokemon);
    }

    public LiveData<Pokemon> getSelected() {
        return selected;
    }

    public List<Pokemon> getPokemonList() {
        return this.repository.getPokemonList();
    }
}
