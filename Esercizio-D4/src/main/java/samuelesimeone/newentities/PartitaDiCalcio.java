package samuelesimeone.newentities;

import samuelesimeone.eventi.Evento;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Evento {

    private String squadra_di_casa;
    private String getSquadra_ospite;
    private String getSquadra_vincente;
    private int gol_squadra_di_casa;
    private int gol_squadra_ospite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate data_evento, String descrizione, long numero_massimo_partecipanti, String squadra_di_casa, String getSquadra_ospite, String getSquadra_vincente, int gol_squadra_di_casa, int gol_squadra_ospite) {
        super(titolo, data_evento, descrizione, numero_massimo_partecipanti);
        this.squadra_di_casa = squadra_di_casa;
        this.getSquadra_ospite = getSquadra_ospite;
        this.gol_squadra_di_casa = gol_squadra_di_casa;
        this.gol_squadra_ospite = gol_squadra_ospite;
        this.getSquadra_vincente = getSquadra_vincente;
    }

    public String getSquadra_di_casa() {
        return squadra_di_casa;
    }

    public void setSquadra_di_casa(String squadra_di_casa) {
        this.squadra_di_casa = squadra_di_casa;
    }

    public String getGetSquadra_ospite() {
        return getSquadra_ospite;
    }

    public void setGetSquadra_ospite(String getSquadra_ospite) {
        this.getSquadra_ospite = getSquadra_ospite;
    }

    public String getGetSquadra_vincente() {
        return getSquadra_vincente;
    }

    public void setGetSquadra_vincente(String getSquadra_vincente) {
        this.getSquadra_vincente = getSquadra_vincente;
    }

    public int getGol_squadra_di_casa() {
        return gol_squadra_di_casa;
    }

    public void setGol_squadra_di_casa(int gol_squadra_di_casa) {
        this.gol_squadra_di_casa = gol_squadra_di_casa;
    }

    public int getGol_squadra_ospite() {
        return gol_squadra_ospite;
    }

    public void setGol_squadra_ospite(int gol_squadra_ospite) {
        this.gol_squadra_ospite = gol_squadra_ospite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadra_di_casa='" + squadra_di_casa + '\'' +
                ", getSquadra_ospite='" + getSquadra_ospite + '\'' +
                ", getSquadra_vincente='" + getSquadra_vincente + '\'' +
                ", gol_squadra_di_casa=" + gol_squadra_di_casa +
                ", gol_squadra_ospite=" + gol_squadra_ospite +
                '}';
    }
}
