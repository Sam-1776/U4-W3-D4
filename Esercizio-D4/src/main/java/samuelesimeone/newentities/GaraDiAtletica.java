package samuelesimeone.newentities;

import samuelesimeone.entities.Persona;
import samuelesimeone.eventi.Evento;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {

    @OneToMany(mappedBy = "nome")
    private Set<Persona> atleti;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona vincitore;

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate data_evento, String descrizione, long numero_massimo_partecipanti, Set<Persona> atleti, Persona vincitore) {
        super(titolo, data_evento, descrizione, numero_massimo_partecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
