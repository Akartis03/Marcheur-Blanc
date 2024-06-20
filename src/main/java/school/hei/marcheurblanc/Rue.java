package school.hei.marcheurblanc;

import lombok.*;
import school.hei.marcheurblanc.Lieu;

@Getter
@ToString
public class Rue {
    private String nom;
    private Lieu lieu1;
    private Lieu lieu2;

    public Rue(String nom, Lieu lieu1, Lieu lieu2) {
        this.nom = nom;
        this.lieu1 = lieu1;
        lieu1.addRues(this);
        this.lieu2 = lieu2;
        lieu2.addRues(this);
    }

    public Lieu getAutreLieu(Lieu lieu) {
        if (lieu.equals(lieu1)) {
            return lieu2;
        } else if (lieu.equals(lieu2)) {
            return lieu1;
        } else {
            return null;
        }
    }
}
