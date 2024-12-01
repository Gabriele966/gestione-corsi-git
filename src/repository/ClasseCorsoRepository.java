package repository;

import config.DbConnection;
import model.ClasseCorso;
import model.Corso;
import model.Discente;
import model.Docente;
import model.Corso;

import java.sql.*;
import java.util.*;

public class ClasseCorsoRepository {

    public void createClasseCorso(ClasseCorso oclasseCorso) {
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO ClasseCorso VALUES('" + oclasseCorso.getDiscente().getNome() + "', '" +
                    oclasseCorso.getDiscente().getCognome() + "', '" + oclasseCorso.getCorso().getNomeCorso() + "', " +
                    oclasseCorso.getCorso().getIdCorso() + ", " + oclasseCorso.getDiscente().getId() + ")");
        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }


    public List<ClasseCorso> readClasseCorso() {
        List<ClasseCorso> classeCorso = new ArrayList<>();
        Discente oDiscente = new Discente();
        Corso oCorso = new Corso();
        ClasseCorso oClasseCorso = new ClasseCorso();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ClasseCorso");
            while (rs.next()) {
                oDiscente.setNome(rs.getString("nome_discente"));
                oDiscente.setCognome(rs.getString("cognome_discente"));
                oDiscente.setId(rs.getInt("id_discente"));
                oCorso.setNomeCorso(rs.getString("nome_corso"));
                oCorso.setIdCorso(rs.getInt("id_corso"));
                oClasseCorso.setDiscente(oDiscente);
                oClasseCorso.setCorso(oCorso);
                classeCorso.add(oClasseCorso);

            }

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return classeCorso;

    }

    public void deleteClasse(Corso oCorso){
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM ClasseCorso WHERE id_corso = " + oCorso.getIdCorso());

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateClasse(ClasseCorso oclasseCorso){
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE ClasseCorso SET nome_discente = '" + oclasseCorso.getDiscente().getNome() + "', cognome_discente ='" +
                    oclasseCorso.getDiscente().getCognome() + "', nome_corso ='" + oclasseCorso.getCorso().getNomeCorso() + "', id_corso = " +
                    oclasseCorso.getCorso().getIdCorso() + ", id_discente =" + oclasseCorso.getDiscente().getId() + " WHERE id_classe = "+ oclasseCorso.getCorso().getIdCorso());

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }
}
