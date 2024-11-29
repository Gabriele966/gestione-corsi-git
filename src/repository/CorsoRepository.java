package repository;

import config.DbConnection;
import model.Corso;
import model.Docente;

import java.sql.*;
import java.time.LocalDate;
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

        public ArrayList<Corso> readCorso() {
            ArrayList<Corso> listaCorso = new ArrayList<>();
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione Riuscita");
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CorsoTest ORDER BY id_corso ASC");
                while (rs.next()) {
                    Corso oCorso = new Corso();
                    Docente oDocente = new Docente();
                     oCorso.setIdCorso(rs.getInt("id_corso"));
                     oCorso.setNomeCorso(rs.getString("nome_corso"));
                     oCorso.setDurata(rs.getString("durata"));
                     oCorso.setDataInizio(LocalDate.parse(rs.getString("data_inizio")));
                     oDocente.setid(rs.getInt("id_docente"));
                     oDocente.setNome(rs.getString("nome_docente"));
                     oDocente.setCognome(rs.getString("cognome_docente"));
                     oCorso.setDocente(oDocente);
                     listaCorso.add(oCorso);
                }
            }catch(ClassNotFoundException | SQLException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }
            return listaCorso;
        }


        public void deleteCorso(Corso oCorso) {
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione Riuscita");
                Statement stmt = c.createStatement();
                stmt.execute("DELETE FROM CorsoTest WHERE id_corso ="+oCorso.getIdCorso());
                System.out.println("model.dao.Corso Eliminato");


            }catch (ClassNotFoundException | SQLException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }

        }


        public void updateCorso(Corso oCorso) {
            try{
                Connection c = DbConnection.openConnection();
                System.out.println("Connessione Riuscita");
                Statement stmt = c.createStatement();
                stmt.execute("UPDATE CorsoTest SET nome_corso = '"+ oCorso.getNomeCorso() + "', data_inizio = '"+oCorso.getDataInizio() +"',durata = '"+oCorso.getDurata() +"',id_docente = "
                        + oCorso.getDocente().getid()+",nome_docente ='"+ oCorso.getDocente().getNome() +"',cognome_docente ='"+oCorso.getDocente().getCognome() +"'WHERE id_corso ="+oCorso.getIdCorso());
                System.out.println("model.dao.Corso aggiornato");
            }catch (ClassNotFoundException | SQLException e){
                System.err.println(e.getMessage());
                System.exit(0);
            }

        }





}
