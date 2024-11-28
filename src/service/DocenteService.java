package service;

import model.Docente;
import repository.DocenteRepository;

import java.util.List;

public class DocenteService {
    DocenteRepository docenteRepository = new DocenteRepository();



    public void create(String nome, String cognome) {
        Docente oDocente = new Docente();
        oDocente.setCognome(cognome);
        oDocente.setNome(nome);
        docenteRepository.createDocente(oDocente);
    }


    public List<Docente>  readDocente(){
            return docenteRepository.readDocente();
    }


    public void delete(int id) {
        Docente oDocente = new Docente();
        oDocente.setid(id);
        docenteRepository.deleteDocente(oDocente);
    }

    public void update(int id, String nome, String cognome) {
        Docente oDocente = new Docente();
        oDocente.setNome(nome);
        oDocente.setCognome(cognome);
        oDocente.setid(id);
        docenteRepository.updateDocente(oDocente);
    }


}


