package ro.arthursplaytime;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import ro.arthursplaytime.Angajati.Angajati;
import ro.arthursplaytime.Angajati.AngajatiService;
import ro.arthursplaytime.Angajati.AngajatiServiceMemory;
import ro.arthursplaytime.Clienti.Clienti;
import ro.arthursplaytime.Clienti.ClientiService;
import ro.arthursplaytime.Clienti.ClientiServiceMemory;
import ro.arthursplaytime.Comenzi.*;
import ro.arthursplaytime.Produse.*;
import ro.arthursplaytime.Tehnologii.Filament;
import ro.arthursplaytime.Tehnologii.Imprimante;
import ro.arthursplaytime.Tehnologii.TehnologiiService;
import ro.arthursplaytime.Tehnologii.TehnologiiServiceMemory;

public class Main {
    public static void main(String[] args){
        ServiceAudit serviceAudit = ServiceAudit.getInstance();


        ProduseService produseService = new ProduseServiceMemory();
        SingletonProduseServiceCSV singletonProduseServiceCSV = SingletonProduseServiceCSV.getInstance();
        ProduseService produseCitite = singletonProduseServiceCSV.getAllFromCSV();

        for (int i = 0; i < produseCitite.getAll().size(); i++) {
            produseService.save(produseCitite.getAll().get(i));
        }


        //adaugare produse
//        Produse produs_nou1 = new ProduseStandard("Lampa","PLA", 100.5, 50.0);
//        produseService.save(produs_nou1);
//        Produse produs_nou2 = new Produse("Cub_puzzle","TPU", 20.25);
//        produseService.save(produs_nou2);
//        Produse produs_nou3 = new Produse("Tablou","PLA", 145.0);
//        produseService.save(produs_nou3);

        singletonProduseServiceCSV.saveInCSV(produseService.getAll());





        AngajatiService angajatiService = new AngajatiServiceMemory();

        //adaugare angajati
        Angajati angajat_nou1 = new Angajati("Silviu","Ana", 2000);
        angajatiService.save(angajat_nou1);

        Angajati angajat_nou2 = new Angajati("Dinu","Cristian", 5000);
        angajatiService.save(angajat_nou2);






        //adaugare clienti
        ClientiService clientiService = new ClientiServiceMemory();
        Clienti client_nou1 = new Clienti("Rotaru","Cristina", "0785212833");
        clientiService.save(client_nou1);
        Clienti client_nou2 = new Clienti("dinu","Cristian", "0724702368");
        clientiService.save(client_nou2);


        //filament
        TehnologiiService tehnologiiService = new TehnologiiServiceMemory();

        Filament filament_nou1 = new Filament("PLA", 200, "alb");
        tehnologiiService.saveFilament(filament_nou1);

        //imprimante

        List<Filament> fil_impr1 = new ArrayList<>();
        Filament fil1 = tehnologiiService.getByTip("PLA");
        fil_impr1.add(fil1);

        Imprimante impr_noua1 = new Imprimante("Odis", fil_impr1, 22.0, 50., 35.0);
        tehnologiiService.saveImprimanta(impr_noua1);




        //adaugare comanda
        ComenziService comenziService = new ComenziServiceMemory();


        SingletonComenziServiceCSV singletonComenziServiceCSV = SingletonComenziServiceCSV.getInstance();
        ComenziService comenziCitite = singletonComenziServiceCSV.getAllFromCSV();

        for (int i = 0; i < comenziCitite.getAll().size(); i++) {
            comenziService.save(comenziCitite.getAll().get(i));
        }



        List<Produse> produse_comanda1 = new ArrayList<>();

        Produse produs_comanda1 = produseService.getById(1);
        Produse produs_comanda2 = produseService.getById(2);

        produse_comanda1.add(produs_comanda1);
        produse_comanda1.add(produs_comanda2);

        Comenzi comanda_noua1 = new Comenzi(1, 1, "25/04/2022", produse_comanda1);
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
                    System.out.println("Ce interoghezi ? \n [1 - Produs dupa id ; 2 - Client dupa telefon; 3 - Comanda dupa id client; 4 - Comenzi dupa data; 5 - Imprimante disponibile] \n Comanda ->");
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
                    serviceAudit.save("Adaugare produs");
                    System.out.println("Ce fel de produs ? 1 - Standard; 2 - Custom ->");
                    int tip = comanda.nextInt();

                    System.out.println("Nume ->");
                    String nume_prod = comanda.nextLine();

                    System.out.println("Tip filament ->");
                    String filament = comanda.nextLine();

                    System.out.println("Cost productie ->");
                    Double cost_productie = comanda.nextDouble();


                    if (tip == 1){
                        System.out.println("Volum ->");
                        Double volum = comanda.nextDouble();
                        Produse produs_nou = new ProduseStandard( nume_prod ,filament, cost_productie, volum);
                        produseService.save(produs_nou);
                    }
                    else if (tip == 2) {
                        System.out.println("Lungime ->");
                        Double L = comanda.nextDouble();
                        System.out.println("Latime ->");
                        Double l = comanda.nextDouble();
                        System.out.println("Inaltime ->");
                        Double h = comanda.nextDouble();
                        Produse produs_nou = new ProduseCustom( nume_prod ,filament, cost_productie, L,l,h);
                        produseService.save(produs_nou);
                    }
                    singletonProduseServiceCSV.saveInCSV(produseService.getAll());
                    break;

                case 12:
                    serviceAudit.save("Adaugare client");
                    System.out.println("Nume ->");
                    String nume_client = comanda.nextLine();

                    System.out.println("Prenume ->");
                    String prenume_client = comanda.nextLine();

                    System.out.println("Telefon ->");
                    String tel_client = comanda.nextLine();

                    Clienti client_nou = new Clienti(nume_client,prenume_client,tel_client);
                    clientiService.save(client_nou);

                    break;

                case 13:
                    serviceAudit.save("Adaugare comanda");
                    System.out.println("Ce fel de comanda ? 1 - Standard; 2 - Custom ->");
                    int tip_comanda = comanda.nextInt();


                    // String data, List<Produse> produse

                    System.out.println("Id Client ->");
                    int id_client = comanda.nextInt();

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println(dtf.format(now));

                    System.out.println("Id-uri produse ->");
                    String id_uri_produse ="1 1 2"; //comanda.nextLine();
                    String[] splited_id = id_uri_produse.split(" ");

                    List<Produse> produse_comanda = new ArrayList<>();
                    for(int i = 0; i < splited_id.length; i++) {

                            int id_prod =Integer.parseInt(splited_id[i]);
                            Produse produs_comanda = produseService.getById(id_prod);
                            produse_comanda.add(produs_comanda);



                    }
                    System.out.println(produse_comanda);


                    if (tip_comanda == 1){
                        Comenzi comanda_noua = new Comenzi(id_client,1,dtf.format(now),produse_comanda);
                        comenziService.save(comanda_noua);
                    }
                    else if (tip_comanda == 2) {
                        System.out.println("Detalii comanda ->");
                        String detalii = comanda.nextLine();
                        Comenzi comanda_noua = new ComenziCustom(id_client,1,dtf.format(now),produse_comanda,detalii);
                        comenziService.save(comanda_noua);
                    }
                    singletonComenziServiceCSV.saveInCSV(comenziService.getAll());
                    break;

                case 14:
                    serviceAudit.save("Adaugare filament");
                    System.out.println("Tip ->");
                    String tip_fil = comanda.nextLine();

                    System.out.println("Temperatura ->");
                    int temp = comanda.nextInt();

                    System.out.println("Culoare ->");
                    String culoare = comanda.nextLine();

                    Filament filament_nou = new Filament(tip_fil,temp,culoare);
                    tehnologiiService.saveFilament(filament_nou);

                    break;

                case 21:
                    serviceAudit.save("Interogare produs");
                    System.out.println("Id-ul produsului ->");
                    int id = comanda.nextInt();
                    System.out.println(produseService.getById(id));
                    break;

                case 22:
                    serviceAudit.save("Interogare client");
                    System.out.println("Telefonul clientului ->");
                    //String tel = comanda.nextLine();
                    String tel = "0785212833";
                    System.out.println(clientiService.getByTelefon(tel));
                    break;

                case 23:
                    serviceAudit.save("interogare comanda dupa telefon");
                    System.out.println("Id-ul clientului pt comanda ->");
                    int id_client_com = comanda.nextInt();
                    System.out.println(comenziService.getByIdClient(id_client_com));
                    break;

                case 24:
                    serviceAudit.save("Interogare comanda dupa data");
                    System.out.println("Data comenzii ->");
                    String data_com = "25/04/2022"; // comanda.nextLine();
                    System.out.println(comenziService.getByData(data_com));
                    break;
                case 25:
                    serviceAudit.save("Interogare imprimante");
                    tehnologiiService.getByStatus();
                    break;
                case 31:
                    serviceAudit.save("Modificare pret");
                    System.out.println("Id-ul produsului ->");
                    int id_produs_modif =  comanda.nextInt();
                    System.out.println("Noul pret ->");
                    double pret_produs_modif =  comanda.nextDouble();
                    produseService.modificarePret(id_produs_modif,pret_produs_modif);
                    System.out.println(produseService.getById(id_produs_modif));
                    singletonProduseServiceCSV.saveInCSV(produseService.getAll());
                    break;
                case 32:
                    serviceAudit.save("Modificare status imprimanta");
                    System.out.println("Numele imprimantei ->");
                    String nume_impr_modif =  comanda.nextLine();
                    tehnologiiService.modificareStatus(nume_impr_modif);
                    break;
                case 33:
                    serviceAudit.save("Modificare status comanda");
                    System.out.println("Data comenzii ->");
                    String data_modif =  comanda.nextLine();

                    System.out.println("Id client ->");
                    int id_client_modif =  comanda.nextInt();
                    comenziService.modificareStatus(id_client_modif,data_modif);

                    singletonComenziServiceCSV.saveInCSV(comenziService.getAll());
                    break;


               }

            }

        }

    }

