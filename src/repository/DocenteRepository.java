package repository;

import config.DbConnection;
import model.Docente;

import java.sql.*;
import java.util.ArrayList;

public class DocenteRepository {
    public void createDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO DocenteTest VALUES('" + oDocente.getNome() + "','" + oDocente.getCognome() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }



    public ArrayList<Docente> readDocente () {
            ArrayList<Docente> listaDocenti = new ArrayList<>();
            try {
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione riuscita!");
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DocenteTest ORDER BY id asc");
                while (rs.next()) {
                    Docente oDocente = new Docente();
                    oDocente.setNome(rs.getString("nome"));
                    oDocente.setCognome(rs.getString("cognome"));
                    oDocente.setid(rs.getInt("id"));
                    listaDocenti.add(oDocente);
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
            return listaDocenti;
        }
    public void deleteDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM DocenteTest WHERE id = '" + oDocente.getid() + "'");
            System.out.println("model.dao.Docente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DocenteTest SET nome='"+oDocente.getNome()+"', cognome='"+oDocente.getCognome()+"' WHERE id ="  + oDocente.getid());
            System.out.println("model.dao.Docente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }








}




