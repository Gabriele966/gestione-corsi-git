package model;

import java.time.LocalDate;

public class Discente {
    private int id;
    private String nome;
    private String cognome;
    private int matricola ;
    private LocalDate dataNascita;

    //Getter e Setter id
    public int getId() {return id;}
    public void setId(int id) { this.id = id;}

    //Getter e Setter nome
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    //Getter e Setter Cognome
    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    //Getter e Setter matricola
    public int getMatricola() {return matricola;}
    public void setMatricola(int matricola) {this.matricola = matricola;}

    //Getter e Setter Data
    public LocalDate getDataNascita() {return dataNascita;}
    public void setDataNascita(LocalDate dataNascita) {this.dataNascita = dataNascita;}
}
