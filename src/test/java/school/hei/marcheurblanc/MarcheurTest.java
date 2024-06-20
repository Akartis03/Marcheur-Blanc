package school.hei.marcheurblanc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarcheurTest{
    @Test
    void le_marcheur_peut_marcher(){
        var sekolintsika = new Lieu("Sekolintsika");
        var hei = new Lieu("Hei");

        var sekolintsikaHei = new Rue("Sekolintsika & Hei", sekolintsika, hei);

        var bjarni = new Marcheur("Bjarni",sekolintsika);
        var depart = bjarni.getPosition();
        var positionDeBjarniDeplace = bjarni.marcher();

        assertNotEquals(depart, positionDeBjarniDeplace);
    }

    @Test
    void peut_aller_vers_destination(){
        var marais = new Lieu("Marais");
        var sekolintsika = new Lieu("Sekolintsika");
        var hei = new Lieu("Hei");
        var pullman = new Lieu("Pullman");
        var balancoire = new Lieu("Balancoire");
        var nexta = new Lieu("Nexta");
        var boulevard = new Lieu("Boulevard");
        var esti = new Lieu("ESTI");

        var maraisSekolintsika = new Rue("Marais & Sekolintsika", marais, sekolintsika);
        var sekolintsikaHei = new Rue("Sekolintsika & Hei", sekolintsika, hei);
        var heiPullman = new Rue("Hei & Pullman", hei, pullman);
        var heiBalancoire = new Rue("Hei & Balancoire", hei, balancoire);
        var pullmanNexta = new Rue("Pullman & Nexta", pullman, nexta);
        var balancoireBoulevard = new Rue("Balancoire & Boulevard", balancoire, boulevard);
        var balancoireEsti = new Rue("Balancoire & ESTI", balancoire, esti);
        var boulevardEsti = new Rue("Boulevard & ESTI", boulevard, esti);

        var bjarni = new Marcheur("Bjarni",sekolintsika);
        var destination = nexta;
        var chemin = bjarni.trouverCheminAleatoire(destination);
        var leBoutDuChemin = chemin.get(chemin.size() - 1);
        assertEquals(destination.getNom(), leBoutDuChemin);
    }
}
