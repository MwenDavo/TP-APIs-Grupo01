package pojo;

import javax.persistence.*;

@Entity
@DiscriminatorValue("general")
public class General extends Reclamo {
    @ManyToOne
    private Edificio edificio;

    public General() {
        super();
    }


}
