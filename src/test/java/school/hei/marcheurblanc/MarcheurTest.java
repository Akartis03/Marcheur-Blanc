package school.hei.marcheurblanc;

import org.junit.jupiter.api.Test;

import java.util.List;

public class MarcheurTest{
    @Test
    void justATest(){
        Carte carte = new Carte();

        Lieu Marais = new Lieu("Marais");
        Lieu Sekolintsika = new Lieu("Sekolintsika");
        Lieu Hei = new Lieu("Hei");
        Lieu Pullman = new Lieu("Pullman");
        Lieu Balançoire = new Lieu("Balançoire");
        Lieu Boulevard = new Lieu("Boulevard");
        Lieu Nexta = new Lieu("Nexta");
        Lieu ESTI = new Lieu("ESTI");

        carte.ajouterLieu(Marais);
        carte.ajouterLieu(Sekolintsika);
        carte.ajouterLieu(Hei);
        carte.ajouterLieu(Pullman);
        carte.ajouterLieu(Balançoire);
        carte.ajouterLieu(Boulevard);
        carte.ajouterLieu(Nexta);
        carte.ajouterLieu(ESTI);

        carte.ajouterRue("Marais vers Sekolintsika", Marais, Sekolintsika);
        carte.ajouterRue("Sekolintsika vers Hei", Sekolintsika, Hei);
        carte.ajouterRue("Hei vers Pullman", Hei, Pullman);
        carte.ajouterRue("Hei vers Balançoire", Hei, Balançoire);
        carte.ajouterRue("Pullman vers Nexta", Pullman, Nexta);
        carte.ajouterRue("Pullman vers Balançoire", Pullman, Balançoire);
        carte.ajouterRue("Balançoire vers Boulevard", Balançoire, Boulevard);
        carte.ajouterRue("Balançoire vers ESTI", Balançoire, ESTI);
        carte.ajouterRue("Boulevard vers ESTI", Boulevard, ESTI);

        List<String > chemin = carte.trouverCheminAleatoire(Hei, ESTI);

        if (chemin != null) {
            System.out.println("Son itinéraire : " + chemin);
        } else {
            System.out.println("Aucun chemin trouvé.");
        }
    }
}
