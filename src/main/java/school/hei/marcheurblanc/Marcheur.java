package school.hei.marcheurblanc;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@ToString
public class Marcheur {
    private final String nom;
    private Lieu position;
    private List<Lieu> lieusDejaVisite;

    public Marcheur(String nom, Lieu position){
        this.nom = nom;
        this.position = position;
        this.lieusDejaVisite = new ArrayList<>();
        this.lieusDejaVisite.add(position);
    }

    public Lieu marcher(){
        var rueChoisi = choisirRueAleatoire(position);
        position = rueChoisi.getAutreLieu(position);
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