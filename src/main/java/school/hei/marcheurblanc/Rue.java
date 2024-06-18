package school.hei.marcheurblanc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Rue {
    private String nom;
    private Lieu lieu1;
    private Lieu lieu2;

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
