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



}
