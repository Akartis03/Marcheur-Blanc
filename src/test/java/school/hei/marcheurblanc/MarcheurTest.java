package school.hei.marcheurblanc;

import lombok.extern.flogger.Flogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarcheurTest{
    @Test
    void le_marcheur_peut_marcher(){
        var Sekolintsika = new Lieu("Sekolintsika");
        var Hei = new Lieu("Hei");

        var sekolintsikaHei = new Rue("Sekolintsika & Hei", Sekolintsika, Hei);

        var bjarni = new Marcheur("Bjarni",Sekolintsika);
        var depart = bjarni.getPosition();
        var positionDeBjarniDeplace = bjarni.marcher();

        assertNotEquals(depart, positionDeBjarniDeplace);
    }
}
