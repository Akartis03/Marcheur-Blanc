package school.hei.marcheurblanc;

import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@ToString
public class Marcheur {
    private final String nom;
    private Lieu position;
    private Set<Lieu> lieusDejaVisite;

    public Marcheur(String nom, Lieu position){
        this.nom = nom;
        this.position = position;
        this.lieusDejaVisite = new HashSet<>();
        this.lieusDejaVisite.add(position);
    }

    public List<String> trouverCheminAleatoire(Lieu destination){
        List<String> chemin = new ArrayList<>();
        var depart = this.position;
        chemin.add(depart.getNom());
        if (destination.equals(depart)){
            return chemin;
        }
        while (position != destination){
            chemin.add(marcher().getNom());
        }
        return chemin;
    }

    public Lieu marcher(){
        var rueChoisi = choisirRueAleatoire(position);
        position = rueChoisi.getAutreLieu(position);
        ajoutLieuVisite(position);
        return position;
    }
    public Rue choisirRueAleatoire(Lieu lieu){
        List<Rue> choixDeRue = lieu.getRues();
        Collections.shuffle(choixDeRue);
        return choixDeRue.get(choixDeRue.size() - 1);
    }
    public void ajoutLieuVisite(Lieu lieu) {
        lieusDejaVisite.add(lieu);
    }
}