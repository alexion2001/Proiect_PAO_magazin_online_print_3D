package ro.arthursplaytime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import ro.arthursplaytime.gui.angajati.angajati;
import ro.arthursplaytime.gui.angajati.angajatiService;
import ro.arthursplaytime.gui.angajati.angajatiServiceMemory;
import ro.arthursplaytime.gui.clienti.clienti;
import ro.arthursplaytime.gui.clienti.clientiService;
import ro.arthursplaytime.gui.clienti.clientiServiceMemory;
import ro.arthursplaytime.gui.clienti.singletonClientiServiceCSV;
import ro.arthursplaytime.gui.comenzi.*;
import ro.arthursplaytime.gui.comenzi.*;
import ro.arthursplaytime.gui.produse.*;
import ro.arthursplaytime.gui.tehnologii.*;
import ro.arthursplaytime.gui.produse.*;
import ro.arthursplaytime.gui.tehnologii.*;

public class Main {
     private tehnologiiService tehnologiiService = new tehnologiiServiceDb();


    public static void main(String[] args) throws IOException,SQLException {

        serviceAudit serviceAudit = ro.arthursplaytime.serviceAudit.getInstance();


        produseService produseService = new produseServiceMemory();
        singletonProduseServiceCSV singletonProduseServiceCSV = ro.arthursplaytime.gui.produse.singletonProduseServiceCSV.getInstance();
        ro.arthursplaytime.gui.produse.produseService produseCitite = singletonProduseServiceCSV.getAllFromCSV();

        for (int i = 0; i < produseCitite.getAll().size(); i++) {
            produseService.save(produseCitite.getAll().get(i));
        }


        //adaugare produse
//        produse produs_nou1 = new ProduseStandard("Lampa","PLA", 100.5, 50.0);
//        produseService.save(produs_nou1);
//        produse produs_nou2 = new produse("Cub_puzzle","TPU", 20.25);
//        produseService.save(produs_nou2);
//        produse produs_nou3 = new produse("Tablou","PLA", 145.0);
//        produseService.save(produs_nou3);

        singletonProduseServiceCSV.saveInCSV(produseService.getAll());





        angajatiService angajatiService = new angajatiServiceMemory();

        //adaugare angajati
        angajati angajat_nou1 = new angajati("Silviu","Ana", 2000);
        angajatiService.save(angajat_nou1);

        angajati angajat_nou2 = new angajati("Dinu","Cristian", 5000);
        angajatiService.save(angajat_nou2);






        //adaugare clienti


        clientiService clientiService = new clientiServiceMemory();

        singletonClientiServiceCSV singletonClientiServiceCSV = ro.arthursplaytime.gui.clienti.singletonClientiServiceCSV.getInstance();
        ro.arthursplaytime.gui.clienti.clientiService clientiCitite = singletonClientiServiceCSV.getAllFromCSV();

        for (int i = 0; i < clientiCitite.getAll().size(); i++) {
            clientiService.save(clientiCitite.getAll().get(i));
        }


//        Clienti client_nou1 = new Clienti("Rotaru","Cristina", "0785212833");
//        clientiService.save(client_nou1);
//        Clienti client_nou2 = new Clienti("dinu","Cristian", "0724702368");
//        clientiService.save(client_nou2);

         singletonClientiServiceCSV.saveInCSV(clientiService.getAll());


        //filament
        this.tehnologiiService = new tehnologiiServiceDb();


        filament filament_nou1 = new filament("PLA", 200, "alb");
        tehnologiiService.saveFilament(filament_nou1);


        //imprimante

        //singletonImprimanteServiceCSV singletonImprimanteServiceCSV = ro.arthursplaytime.gui.tehnologii.singletonImprimanteServiceCSV.getInstance();
        //ro.arthursplaytime.gui.tehnologii.tehnologiiService imprCitite = singletonImprimanteServiceCSV.getAllFromCSV();

        for (int i = 0; i < produseCitite.getAll().size(); i++) {
            produseService.save(produseCitite.getAll().get(i));
        }

        List<filament> fil_impr1 = new ArrayList<>();
        filament fil1 = tehnologiiService.getByTip("PLA");
        fil_impr1.add(fil1);

        imprimante impr_noua1 = new imprimante("Odis", fil_impr1, 22.0, 50., 35.0);
        tehnologiiService.saveImprimanta(impr_noua1);

        //singletonImprimanteServiceCSV.saveInCSV(tehnologiiService.getAll());


        //adaugare comanda
        comenziService comenziService = new comenziServiceMemory();


        singletonComenziServiceCSV singletonComenziServiceCSV = ro.arthursplaytime.gui.comenzi.singletonComenziServiceCSV.getInstance();
        ro.arthursplaytime.gui.comenzi.comenziService comenziCitite = singletonComenziServiceCSV.getAllFromCSV();

        for (int i = 0; i < comenziCitite.getAll().size(); i++) {
            comenziService.save(comenziCitite.getAll().get(i));
        }



        List<produse> produse_comanda1 = new ArrayList<>();

        produse produs_comanda1 = produseService.getById(1);
        produse produs_comanda2 = produseService.getById(2);

        produse_comanda1.add(produs_comanda1);
        produse_comanda1.add(produs_comanda2);

        comenzi comanda_noua1 = new comenzi(1, 1, "25/04/2022", produse_comanda1);
        comenziService.save(comanda_noua1);


        singletonComenziServiceCSV.saveInCSV(comenziService.getAll());


        // meniu interactiv
        Scanner comanda = new Scanner(System.in);
        int comanda1 = 1;
        int comanda2 = 0;

        while (comanda1 == 1 || comanda1 == 2){
            System.out.println("Introdu numarul comenzii \n [1 - Adaugare; 2 - Interogare; 3 - Modificare; altceva - EXIT] \n Comanda ->");
            comanda1 = comanda.nextInt();

            switch(comanda1) {
                case 1:
                    System.out.println("Ce adaugi ? \n [1 - Produs; 2 - Client; 3 - Comanda; 4 - Filament] \n Comanda ->");
                    comanda2 = comanda.nextInt();
                    break;
                case 2:
                    System.out.println("Ce interoghezi ? \n [1 - Produs dupa id ; 2 - Client dupa telefon; 3 - Comanda dupa id client; 4 - comenzi dupa data; 5 - Imprimante disponibile] \n Comanda ->");
                    comanda2 = comanda.nextInt();
                    break;
                case 3:
                    System.out.println("Ce modifici ? \n [1 - Pret produs; 2 - Status imprimanta;  3 - Status comanda] \n Comanda ->");
                    comanda2 = comanda.nextInt();
                    break;
                default:
                    System.out.println("La revedere");
                    break;
            }

            int comanda_finala = comanda1 * 10 + comanda2;
            //System.out.println(comanda_finala);

            switch(comanda_finala) {
                case 11:

                    BufferedReader comanda22 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Adaugare produs");
                    System.out.println("Ce fel de produs ? 1 - Standard; 2 - Custom ->");
                    int tip = Integer.parseInt(comanda22.readLine());

                    System.out.println("Nume ->");
                    String nume_prod = comanda22.readLine();

                    System.out.println("Tip filament ->");
                    String filament = comanda22.readLine();

                    System.out.println("Cost productie ->");
                    Double cost_productie = Double.valueOf(comanda22.readLine());


                    if (tip == 1){
                        System.out.println("Volum ->");
                        Double volum = Double.valueOf(comanda22.readLine());
                        produse produs_nou = new produseStandard( nume_prod ,filament, cost_productie, volum);
                        produseService.save(produs_nou);
                    }
                    else if (tip == 2) {
                        System.out.println("Lungime ->");
                        Double L = Double.valueOf(comanda22.readLine());
                        System.out.println("Latime ->");
                        Double l = Double.valueOf(comanda22.readLine());
                        System.out.println("Inaltime ->");
                        Double h = Double.valueOf(comanda22.readLine());
                        produse produs_nou = new produseCustom( nume_prod ,filament, cost_productie, L,l,h);
                        produseService.save(produs_nou);
                    }
                    singletonProduseServiceCSV.saveInCSV(produseService.getAll());
                    break;

                case 12:
                    BufferedReader comanda23 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Adaugare client");
                    System.out.println("Nume ->");
                    String nume_client = comanda23.readLine();

                    System.out.println("Prenume ->");
                    String prenume_client = comanda23.readLine();

                    System.out.println("Telefon ->");
                    String tel_client = comanda23.readLine();

                    clienti client_nou = new clienti(nume_client,prenume_client,tel_client);
                    clientiService.save(client_nou);

                    singletonClientiServiceCSV.saveInCSV(clientiService.getAll());

                    break;

                case 13:
                    BufferedReader comanda24 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Adaugare comanda");
                    System.out.println("Ce fel de comanda ? 1 - Standard; 2 - Custom ->");
                    int tip_comanda = comanda.nextInt();


                    // String data, List<produse> produse

                    System.out.println("Id Client ->");
                    int id_client = Integer.parseInt(comanda24.readLine());

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println(dtf.format(now));

                    System.out.println("Id-uri produse ->");
                    String id_uri_produse =comanda24.readLine();
                    String[] splited_id = id_uri_produse.split(" ");

                    List<produse> produse_comanda = new ArrayList<>();
                    for(int i = 0; i < splited_id.length; i++) {

                            int id_prod =Integer.parseInt(splited_id[i]);
                            produse produs_comanda = produseService.getById(id_prod);
                            produse_comanda.add(produs_comanda);



                    }
                    System.out.println(produse_comanda);


                    if (tip_comanda == 1){
                        comenzi comanda_noua = new comenzi(id_client,1,dtf.format(now),produse_comanda);
                        comenziService.save(comanda_noua);
                    }
                    else if (tip_comanda == 2) {
                        System.out.println("Detalii comanda ->");
                        String detalii = comanda.nextLine();
                        comenzi comanda_noua = new comenziCustom(id_client,1,dtf.format(now),produse_comanda,detalii);
                        comenziService.save(comanda_noua);
                    }
                    singletonComenziServiceCSV.saveInCSV(comenziService.getAll());
                    break;

                case 14:
                    BufferedReader comanda25 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Adaugare filament");
                    System.out.println("Tip ->");
                    String tip_fil = comanda25.readLine();

                    System.out.println("Temperatura ->");
                    int temp = Integer.parseInt(comanda25.readLine());

                    System.out.println("Culoare ->");
                    String culoare = comanda25.readLine();

                    ro.arthursplaytime.gui.tehnologii.filament filament_nou = new filament(tip_fil,temp,culoare);
                    tehnologiiService.saveFilament(filament_nou);

                    break;

                case 21:
                    serviceAudit.save("Interogare produs");
                    System.out.println("Id-ul produsului ->");
                    int id = comanda.nextInt();
                    System.out.println(produseService.getById(id));
                    break;

                case 22:
                    BufferedReader comanda26 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Interogare client");
                    System.out.println("Telefonul clientului ->");
                    String tel = comanda26.readLine();
                    System.out.println(clientiService.getByTelefon(tel));
                    break;

                case 23:
                    serviceAudit.save("interogare comanda dupa telefon");
                    System.out.println("Id-ul clientului pt comanda ->");
                    int id_client_com = comanda.nextInt();
                    System.out.println(comenziService.getByIdClient(id_client_com));
                    break;

                case 24:
                    BufferedReader comanda27 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Interogare comanda dupa data");
                    System.out.println("Data comenzii ->");
                    String data_com = comanda27.readLine();
                    System.out.println(comenziService.getByData(data_com));
                    break;
                case 25:
                    serviceAudit.save("Interogare imprimante");
                    tehnologiiService.getByStatus();
                    break;
                case 31:
                    BufferedReader comanda31 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Modificare pret");
                    System.out.println("Id-ul produsului ->");
                    int id_produs_modif = Integer.parseInt(comanda31.readLine());
                    System.out.println("Noul pret ->");
                    double pret_produs_modif = Double.parseDouble(comanda31.readLine());
                    produseService.modificarePret(id_produs_modif,pret_produs_modif);
                    System.out.println(produseService.getById(id_produs_modif));
                    singletonProduseServiceCSV.saveInCSV(produseService.getAll());
                    break;
                case 32:
                    BufferedReader comanda32 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Modificare status imprimanta");
                    System.out.println("Numele imprimantei ->");
                    String nume_impr_modif =  comanda32.readLine();
                    tehnologiiService.modificareStatus(nume_impr_modif);

                    //singletonImprimanteServiceCSV.saveInCSV(tehnologiiService.getAll());
                    break;
                case 33:
                    BufferedReader comanda33 = new BufferedReader(new InputStreamReader(System.in));
                    serviceAudit.save("Modificare status comanda");
                    System.out.println("Data comenzii ->");
                    String data_modif =  comanda33.readLine();

                    System.out.println("Id client ->");
                    int id_client_modif = Integer.parseInt(comanda33.readLine());
                    comenziService.modificareStatus(id_client_modif,data_modif);

                    singletonComenziServiceCSV.saveInCSV(comenziService.getAll());
                    break;


               }

            }
        comanda.close();

        }

    }

