package samuelesimeone.newentities;

import samuelesimeone.eventi.Evento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    private GenereMusica genere;
    private boolean in_streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate data_evento, String descrizione, long numero_massimo_partecipanti, GenereMusica genere, boolean in_streaming) {
        super(titolo, data_evento, descrizione, numero_massimo_partecipanti);
        this.genere = genere;
        this.in_streaming = in_streaming;
    }

    public GenereMusica getGenere() {
        return genere;
    }

    public void setGenere(GenereMusica genere) {
        this.genere = genere;
    }

    public boolean isIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(boolean in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", in_streaming=" + in_streaming +
                '}';
    }
}
