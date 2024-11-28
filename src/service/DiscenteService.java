package service;

import model.Discente;
import repository.DiscenteRepository;

import java.time.LocalDate;
import java.util.*;

public class DiscenteService {
    DiscenteRepository discenteRepository = new DiscenteRepository();

    public void create(String nome, String cognome, int matricola, LocalDate dataNascita ) {
        Discente oDiscente = new Discente();
        oDiscente.setNome(nome);
        oDiscente.setCognome(cognome);
        oDiscente.setMatricola(matricola);
        oDiscente.setDataNascita(dataNascita);
        discenteRepository.createDiscente(oDiscente);
    }

    public List<Discente> readDiscente() {return discenteRepository.readDiscente(); }


    public void delete(int id){
        Discente oDiscente = new Discente();
        oDiscente.setId(id);
        discenteRepository.deleteDiscente(oDiscente);
    }

    public void update(int id, String nome, String cognome, int matricola, LocalDate dataNascita) {
        Discente oDiscente = new Discente();
        oDiscente.setId(id);
        oDiscente.setNome(nome);
        oDiscente.setCognome(cognome);
        oDiscente.setMatricola(matricola);
        oDiscente.setDataNascita(dataNascita);
        discenteRepository.updateDiscente(oDiscente);
    }




}
