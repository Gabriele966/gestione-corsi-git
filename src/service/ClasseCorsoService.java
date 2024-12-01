package service;

import model.Discente;
import model.Corso;
import model.ClasseCorso;
import model.Docente;
import repository.ClasseCorsoRepository;

import javax.print.Doc;
import java.util.List;

public class ClasseCorsoService {
    ClasseCorsoRepository oClasseCorsoRepository = new ClasseCorsoRepository();

    public void createClasse(String nomeDiscente, String cognomeDiscente, String nomeCorso, int idCorso, int idDiscente) {
        ClasseCorso oClasseCorso = new ClasseCorso();
        Corso oCorso = new Corso();
        Discente oDiscente = new Discente();
        oDiscente.setNome(nomeDiscente);
        oDiscente.setCognome(cognomeDiscente);
        oDiscente.setId(idDiscente);
        oCorso.setNomeCorso(nomeCorso);
        oCorso.setIdCorso(idCorso);
        oClasseCorso.setCorso(oCorso);
        oClasseCorso.setDiscente(oDiscente);
        oClasseCorsoRepository.createClasseCorso(oClasseCorso);
    }

    public List<ClasseCorso> readClasse(){return oClasseCorsoRepository.readClasseCorso();}

    public void deleteClasse(int idCorso) {
        Corso oCorso = new Corso();
        oCorso.setIdCorso(idCorso);
        oClasseCorsoRepository.deleteClasse(oCorso);
    }

    public void updateCalsse(Discente oDiscente, Corso oCorso) {
        ClasseCorso oClasseCorso = new ClasseCorso();
        oClasseCorso.setDiscente(oDiscente);
        oClasseCorso.setCorso(oCorso);
        oClasseCorsoRepository.updateClasse(oClasseCorso);

    }
}
