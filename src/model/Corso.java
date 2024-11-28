package model;

import java.time.LocalDate;

public class Corso {
    private String nomeCorso;
    private LocalDate dataInizio;
    private String durata;
    private Docente docente;
    private int idCorso;

    public String getNomeCorso() {return nomeCorso;}
    public void setNomeCorso(String nomeCorso) {this.nomeCorso = nomeCorso; }

    public LocalDate getDataInizio() {return dataInizio;}
    public void setDataInizio(LocalDate dataInizio) {this.dataInizio = dataInizio;}

    public String getDurata() {return durata;}
    public void setDurata(String durata) {this.durata = durata;}

    public int getIdCorso() {return idCorso;}
    public void setIdCorso(int idCorso) {this.idCorso = idCorso;}

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

}
