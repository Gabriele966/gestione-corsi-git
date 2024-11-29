package service;

import model.Corso;
import model.Docente;
import repository.CorsoRepository;

import java.time.LocalDate;
import java.util.*;

public class CorsoService {
    private CorsoRepository corsoRepository = new CorsoRepository();

    public void create(String nomeCorso, LocalDate dataInizio, String durata, Docente docente) {
        Corso oCorso = new Corso();
        oCorso.setNomeCorso(nomeCorso);
        oCorso.setDataInizio(dataInizio);
        oCorso.setDurata(durata);
        oCorso.setDocente(docente);
        corsoRepository.createCorso(oCorso);
    }


    public List<Corso> readCorsi() {
        return corsoRepository.readCorso();
    }

    public void delete(int id) {
        Corso oCorso = new Corso();
        oCorso.setIdCorso(id);
        corsoRepository.deleteCorso(oCorso);
    }
    
    public void update(int id, String nomeCorso, LocalDate dataInizio, String durata, Docente docente) {
        Corso oCorso = new Corso();
        oCorso.setNomeCorso(nomeCorso);
        oCorso.setDataInizio(dataInizio);
        oCorso.setDurata(durata);
        oCorso.setDocente(docente);
        oCorso.setIdCorso(id);
        corsoRepository.updateCorso(oCorso);
    }

}
