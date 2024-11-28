package repository;

import config.DbConnection;
import model.Discente;

import java.sql.*;
import java.util.*;

public class DiscenteRepository {
        public void createDiscente(Discente oDiscente) {

            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione riuscita!");
                Statement stmt = c.createStatement();
                stmt.execute("INSERT INTO DiscenteTest VALUES ('" + oDiscente.getNome() + "','" + oDiscente.getCognome() + "'," + oDiscente.getMatricola() + ",'" + oDiscente.getDataNascita() + "')");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }


        }

        public ArrayList<Discente> readDiscente() {
            ArrayList<Discente> listaDiscenti = new ArrayList<>();
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione riuscita!");
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DiscenteTest ORDER BY id asc");
                while (rs.next()) {

                    Discente oDiscente = new Discente();
                    oDiscente.setId(rs.getInt("id"));
                    oDiscente.setNome(rs.getString("nome"));
                    oDiscente.setCognome(rs.getString("cognome"));
                    oDiscente.setMatricola(rs.getInt("matricola"));
                    oDiscente.setDataNascita(rs.getDate("dataNascita").toLocalDate());
                    listaDiscenti.add(oDiscente);

                };

            }catch (ClassNotFoundException | SQLException e)
            {
                System.err.println(e.getMessage());
                System.exit(0);
            }
            return listaDiscenti;
        }

        public void deleteDiscente(Discente oDiscente) {
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione riuscita!");
                Statement stmt = c.createStatement();
                stmt.execute("DELETE FROM DiscenteTest WHERE id ='"+ oDiscente.getId() +"'");
            }catch (ClassNotFoundException | SQLException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }


        public void updateDiscente(Discente oDiscente) {
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione riuscita!");
                Statement stmt = c.createStatement();
                stmt.execute("UPDATE DiscenteTest SET nome = '" + oDiscente.getNome() +
                        "', cognome = '" + oDiscente.getCognome() +
                        "', matricola = " + oDiscente.getMatricola() +
                        ", dataNascita = '" + oDiscente.getDataNascita() +
                        "' WHERE id = " + oDiscente.getId());
                System.out.println("model.dao.Discente aggiornato");
            }catch (ClassNotFoundException | SQLException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }

        }

}
