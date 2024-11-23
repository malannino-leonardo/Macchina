import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String marca;
        String modello;
        String colore;
        String targa;
        int nPorte;
        String carburante;
        int velMax;
        int capienza;
        double consumo;
        double kmTot;
        int kmParx;
        int capacitaSerb;
        int livelloSerb;
        boolean accSpent = false;
        int velAttuale;

        int scelta;
        String scelta2;
        String scelta3;
        String scelta4;

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Inserisci marca auto: ");
        marca = tastiera.nextLine();
        System.out.print("Inserisci modello auto: ");
        modello = tastiera.nextLine();
        System.out.print("Inserisci colore auto: ");
        colore = tastiera.nextLine();
        System.out.print("Inserisci targa auto: ");
        targa = tastiera.nextLine();
        System.out.print("Inserisci n porte auto: ");
        nPorte = Integer.parseInt(tastiera.nextLine());
        System.out.print("Inserisci capienza auto (persone): ");
        capienza = Integer .parseInt(tastiera.nextLine());
        System.out.print("Inserisci tipo carburante auto: ");
        carburante = tastiera.nextLine();
        System.out.print("Inserisci velocità max auto: ");
        velMax = Integer.parseInt(tastiera.nextLine());
        System.out.print("Inserisci consumo auto (l/100km o kw/100km): ");
        consumo = Double.parseDouble(tastiera.nextLine());
        System.out.print("Inserisci km totali macchina: ");
        kmTot = Double.parseDouble(tastiera.nextLine());
        System.out.print("Inserisci capacità serbatoio macchina: ");
        capacitaSerb = Integer.parseInt(tastiera.nextLine());

        System.out.print("--------------------------------------------------");
        System.out.println("");

        Car macchina = new Car(marca, modello, colore, targa, nPorte, capienza, carburante, velMax, consumo, kmTot, capacitaSerb, accSpent);
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

        System.out.print("Inserisci livello serbatoio: ");
        livelloSerb = Integer.parseInt(tastiera.nextLine());

        System.out.print("Inserisci di quanti km ti devi spostare: ");
        kmParx = Integer.parseInt(tastiera.nextLine());

        System.out.print("Inserisci valocità attuale: ");
        velAttuale = Integer.parseInt(tastiera.nextLine());
            
        if(velAttuale > velMax) {
            System.err.println("ATTENZIONE! La macchina sta eccedendo la velocità massima");
        }
        
        if(macchina.muovi(kmParx, velAttuale) == true){

            System.out.println("La macchina si sta muovendo..");
            System.out.println("Hai raggiunto la tua destinazione!");
            System.out.println("Carburante rimasto: " + livelloSerb + "l");

            //livelloSerb -= ((int)((kmParx/100)*consumo));
            //kmTot += kmParx;

        }else{

            do{
                System.out.println("La macchina non ha abbastanza carburante per effettuare il viaggio desiderato. Vuoi fare rifornimento?");
                scelta2 = tastiera.nextLine();

                if (scelta2 == "si") {

                    macchina.rifornimento();
                    

                } else if (scelta2 == "no"){

                    System.out.println("Effettuare il viaggio lo stesso? ");
                    System.out.println("...");
                    do{
                        scelta3 = tastiera.nextLine();

                        switch (scelta3) {
                            case "si":
                                System.out.println("La macchina si è spenta per mancanza di carburante prima del raggiungimento della destinazione");
                                System.out.println("Vuoi chiamare il carro attrezzi? ");
                                
                                do{
                                    scelta4 = tastiera.nextLine();
                                    if (scelta4 == "si") {
                                        macchina.chiamataCarroAttrezzi();
                                    } else if (scelta4 == "no") {
                                        System.out.println("La macchina è rimasta ferma in strada.");
                                    } else {
                                        System.err.println("Valore inserito non valido!");
                                    }
    
                                    
                                }while(scelta4 != "si" && scelta4 != "no");
                                break;
                            
                            case "no":
                                
                                break;
                        
                            default:
                                System.err.println("Valore inserito non valido!");
                                break;
                        }
                    }while(scelta3 != "si" && scelta3 != "no");

                } else {

                    System.err.println("Valore inserito non valido!");

                }
            }while(scelta2 == "si" || scelta2 == "no");
            
        }
        

        tastiera.close();
    }
}
