package view;

import model.Discente;
import model.Docente;
import service.CorsoService;
import service.DiscenteService;
import service.DocenteService;
import java.time.*;
import java.time.format.DateTimeFormatter;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int type;
        int choice;

        do {

            System.out.println("Inserisci scelta entita da creare");
            System.out.println("1. Docente");
            System.out.println("2. Discente");
            System.out.println("3. Corso");

            type = scanner.nextInt();

            System.out.println("Classe docente");

            System.out.println("***Menu***");
            System.out.println("1. Crea una nuova entita ");
            System.out.println("2. Aggiorna entita");
            System.out.println("3. Visualizza la lista delle entita");
            System.out.println("4. Elimina un entita");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create(type);
                    break;
                case 2:
                    update(type);
                    break;
                case 3:
                    read(type);
                    break;
                case 4:
                    delete(type);
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();


    }

    private static void read(int i) {
        if (i == 1) {
            System.out.println("ecco la lista dei docenti: ");
            DocenteService oDocenteService = new DocenteService();
            List<Docente> listaDocenti= oDocenteService.readDocente();
            for(int n = 0; n < listaDocenti.size(); n++){
                System.out.println(listaDocenti.get(n).getid()+" "+listaDocenti.get(n).getCognome()+" "+listaDocenti.get(n).getNome());
                }

        }else{
            System.out.println("ecco la lista dei discenti: ");
            DiscenteService oDiscenteService = new DiscenteService();
            List<Discente> listaDiscente= oDiscenteService.readDiscente();
            for(int n = 0; n < listaDiscente.size(); n++){
                System.out.println(listaDiscente.get(n).getId()+" "+listaDiscente.get(n).getNome() +" "+listaDiscente.get(n).getCognome() +" "+listaDiscente.get(n).getMatricola() + " "+ listaDiscente.get(n).getDataNascita());
            }
        }
    }


        private static void create (int i ) {
            Scanner scanner = new Scanner(System.in);
            if(i == 1){

                System.out.println("inserisci il nome:");
                String nome = scanner.next();
                System.out.println("inserisci il cognome:");
                String cognome = scanner.next();
                DocenteService oDocenteService = new DocenteService();
                oDocenteService.create(nome, cognome);

            }else if(i == 2){
                System.out.println("inserisci il nome:");
                String nome = scanner.next();
                System.out.println("inserisci il cognome:");
                String cognome = scanner.next();
                System.out.println("inserisci matricola:");
                int matricola = scanner.nextInt();
                System.out.println("inserisci la Data di nascita nel formato dd/MM/yyyy:");
                String data = scanner.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascita = LocalDate.parse(data, formatter);
                DiscenteService oDiscenteService = new DiscenteService();
                oDiscenteService.create(nome, cognome, matricola, dataNascita);

            }else{
                System.out.println("inserisci il nome:");
                String nomeCorso = scanner.next();
                System.out.println("inserisci la Data di inizio del corso nel formato dd/MM/yyyy:");
                String data = scanner.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataInizioCorso = LocalDate.parse(data, formatter);
                System.out.println("Iserire la durata del corso: ");
                String durata = scanner.next();
                System.out.println("ecco la lista dei docenti: ");
                DocenteService oDocenteService = new DocenteService();
                List<Docente> listaDocenti= oDocenteService.readDocente();
                for(int n = 0; n < listaDocenti.size(); n++){
                    System.out.println(listaDocenti.get(n). getid()+" "+listaDocenti.get(n).getCognome()+" "+listaDocenti.get(n).getNome());
                }
                System.out.println("Inserisci id del docente da inserire: ");
                int id = scanner.nextInt();
                for(int m = 0; m < listaDocenti.size(); m++){
                    if(listaDocenti.get(m).getid() == id){
                        Docente doc = listaDocenti.get(m);
                        CorsoService oCrosoService = new CorsoService();
                        oCrosoService.create(nomeCorso, dataInizioCorso, durata, doc);
                    }
                }
            }
        }

        private static void delete (int i ) {
            if(i == 1){
                System.out.println("Elimina il docente con id: ");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                DocenteService oDocenteService = new DocenteService();
                oDocenteService.delete(id);

            }else{
                System.out.println("Elimina il discente con id: ");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                DiscenteService oDiscenteService = new DiscenteService();
                oDiscenteService.delete(id);
            }

        }

        private static void update (int i ) {
            Scanner scanner = new Scanner(System.in);
            if(i == 1){

                System.out.println("inserisci l'id del docente da modificare:");
                int id = scanner.nextInt();
                System.out.println("inserisci il nuovo nome:");
                String nome = scanner.next();
                System.out.println("inserisci il nuovo cognome:");
                String cognome = scanner.next();
                DocenteService oDocenteService = new DocenteService();
                oDocenteService.update(id, nome, cognome);

            }else{
                System.out.println("inserisci l'id del discente da modificare:");
                int id = scanner.nextInt();
                System.out.println("inserisci il nuovo nome:");
                String nome = scanner.next();
                System.out.println("inserisci il nuovo cognome:");
                String cognome = scanner.next();
                System.out.println("inserisci nuova matricola:");
                int matricola = scanner.nextInt();
                System.out.println("inserisci nuova Data di nascita nel formato dd/MM/yyyy:");
                String data = scanner.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascita = LocalDate.parse(data, formatter);
                DiscenteService oDiscenteService = new DiscenteService();
                oDiscenteService.update(id, nome, cognome, matricola, dataNascita);

            }


        }

}
