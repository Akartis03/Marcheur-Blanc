package school.hei.marcheurblanc;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Lieu {
    private final String nom;
    private List<Rue> rues;

    public Lieu(String nom) {
        this(nom, new ArrayList<>());
    }

    private Lieu(String nom, List<Rue> rues){
        this.nom = nom;
        this.rues = rues;
    }

    public void addRues(Rue rue){
        rues.add(rue);
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
