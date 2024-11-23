import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean accSpent = false;

        int scelta;
        String scelta2;
        String scelta3;
        String scelta4;

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Inserisci marca auto: ");
        String marca = tastiera.nextLine();
        System.out.print("Inserisci modello auto: ");
        String modello = tastiera.nextLine();
        System.out.print("Inserisci colore auto: ");
        String colore = tastiera.nextLine();
        System.out.print("Inserisci targa auto: ");
        String targa = tastiera.nextLine();
        System.out.print("Inserisci n porte auto: ");
        int nPorte = Integer.parseInt(tastiera.nextLine());
        System.out.print("Inserisci capienza auto (persone): ");
        int capienza = Integer .parseInt(tastiera.nextLine());
        System.out.print("Inserisci tipo carburante auto: ");
        String carburante = tastiera.nextLine();
        System.out.print("Inserisci velocità max auto: ");
        int velMax = Integer.parseInt(tastiera.nextLine());
        System.out.print("Inserisci consumo auto (l/100km o kw/100km): ");
        double consumo = Double.parseDouble(tastiera.nextLine());
        System.out.print("Inserisci km totali macchina: ");
        double kmTot = Double.parseDouble(tastiera.nextLine());
        System.out.print("Inserisci capacità serbatoio macchina: ");
        int capacitaSerb = Integer.parseInt(tastiera.nextLine());
        System.out.print("Inserisci livello serbatoio: ");
        int livelloSerb = Integer.parseInt(tastiera.nextLine());
        System.out.print("Inserisci di quanti km ti devi spostare: ");
        double kmParx = Double.parseDouble(tastiera.nextLine());
        System.out.print("Inserisci valocità media prevista: ");
        int velMedia = Integer.parseInt(tastiera.nextLine());

        Car macchina = new Car(marca, modello, colore, targa, nPorte, capienza, carburante, velMax, consumo, kmTot, capacitaSerb, accSpent, livelloSerb);
        
        System.out.print("--------------------------------------------------");
        System.out.println("");
        System.out.print(macchina.toString());
        System.out.println("");
        System.out.print("--------------------------------------------------");
        System.out.println("");

        System.out.print("Inserisci 1 per accendere la macchina: ");
        do{
            scelta = Integer.parseInt(tastiera.nextLine());

            if(scelta != 1)
                System.err.println("Valore errato");
        }while(scelta != 1);

        macchina.accensioneSpegnimento(accSpent);
        
        if(macchina.muovi(kmParx) == true){

            System.out.println("La macchina si sta muovendo..");
            System.out.println("Hai raggiunto la tua destinazione!");
            System.out.print(macchina.messaggioArrivo());
            
        }else{

            do{
                System.out.print("La macchina non ha abbastanza carburante per effettuare il viaggio desiderato. Vuoi fare rifornimento? ");
                scelta2 = tastiera.nextLine();

                if (scelta2.equals("si")) {

                    macchina.rifornimento();
                    System.out.println("Rifornimento effettuato!");
                    System.out.println("La macchina si sta muovendo..");
                    System.out.println("Hai raggiunto la tua destinazione!");
                    System.out.print(macchina.messaggioArrivo());
                    
                } else if (scelta2.equals("no")){

                    System.out.print("Effettuare il viaggio lo stesso? ");
                    do{
                        scelta3 = tastiera.nextLine();

                        switch (scelta3) {
                            case "si":
                                System.out.println("La macchina si è spenta per mancanza di carburante prima del raggiungimento della destinazione");
                                System.out.print("Vuoi chiamare il carro attrezzi? ");
                                
                                do {
                                    scelta4 = tastiera.nextLine();
                                    if (scelta4.equals("si")) {

                                        macchina.chiamataCarroAttrezzi();
                                        System.out.println("La macchina si sta muovendo..");
                                        System.out.println("Hai raggiunto la tua destinazione!");
                                        System.out.print(macchina.messaggioArrivo());

                                    } else if (scelta4.equals("no")) {

                                        System.out.println("La macchina è rimasta ferma in strada.");

                                    } else {

                                        System.err.println("Valore inserito non valido!");

                                    }
    
                                    
                                } while (!scelta4.equals("si") && !scelta4.equals("no"));
                                break;
                            
                            case "no":
                                
                                break;
                        
                            default:
                                System.err.println("Valore inserito non valido!");
                                break;
                        }
                    }while(!scelta3.equals("si") && !scelta3.equals("no"));

                } else {

                    System.err.println("Valore inserito non valido!");

                }
            }while(!(scelta2.equals("si") || scelta2.equals("no")));
            
        }
        
        tastiera.close();
    }
}
