package school.hei.marcheurblanc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Carte {
    private Map<Lieu, List<Rue>> adjLieus;

    public Carte() {
        adjLieus = new HashMap<>();
    }

    public void ajouterLieu(Lieu lieu) {
        adjLieus.putIfAbsent(lieu, new ArrayList<>());
    }

    public void ajouterRue(String nom, Lieu lieu1, Lieu lieu2) {
        Rue rue = new Rue(nom, lieu1, lieu2);
        adjLieus.get(lieu1).add(rue);
        adjLieus.get(lieu2).add(rue);
    }

    public List<Lieu> getLieusAdjacents(Lieu lieu) {
        List<Lieu> lieusAdjacents = new ArrayList<>();
        for (Rue rue : adjLieus.get(lieu)) {
            lieusAdjacents.add(rue.getAutreLieu(lieu));
        }
        return lieusAdjacents;
    }

    public List<String> trouverCheminAleatoire(Lieu depart, Lieu destination) {
        List<String> chemin = new ArrayList<>();
        dfsAleatoire(depart, destination, chemin);
        return chemin;
    }

    private boolean dfsAleatoire(Lieu courant, Lieu destination, List<String> chemin) {
        chemin.add(courant.getNom());

        if (courant.equals(destination)) {
            return true;
        }

        List<Lieu> voisins = getLieusAdjacents(courant);
        Collections.shuffle(voisins);

        for (Lieu voisin : voisins) {
            if (lieuEstRelie(voisin, courant)) {
                if (dfsAleatoire(voisin, destination, chemin)) {
                    return true;
                }
            }
        }

        if (chemin.size() > 1) {
            chemin.add(chemin.get(chemin.size() - 2));
        }
        return false;
    }

    private boolean lieuEstRelie(Lieu lieu1, Lieu lieu2) {
        return adjLieus.get(lieu1).stream().anyMatch(rue -> rue.getAutreLieu(lieu1).equals(lieu2));
    }
}