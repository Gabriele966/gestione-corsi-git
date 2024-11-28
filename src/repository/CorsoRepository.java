package repository;

import config.DbConnection;
import model.Corso;
import model.Docente;

import java.sql.*;
import java.util.*;

public class CorsoRepository {
        public void createCorso(Corso oCorso) {
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione Riuscita");
                Statement stmt = c.createStatement();
                stmt.execute("INSERT INTO CorsoTest VALUES('"+ oCorso.getNomeCorso() + "','"+oCorso.getDataInizio() +"','"+oCorso.getDurata() +"',"
                        + oCorso.getDocente().getid()+",'"+ oCorso.getDocente().getNome() +"','"+oCorso.getDocente().getCognome() +"')");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }


}
