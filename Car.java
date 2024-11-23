public class Car {
    private String marca;
    private String modello;
    private String colore;
    private String targa;
    private int nPorte;
    private String Carburante;   //gas, benz, hyb , ele
    private int velMax;
    private int capienza;
    private double consumo;                 // l/100km o kw/100km
    private double kmTot;
    private int kmParx;
    private int capacitaSerb;
    private int livelloSerb;
    private boolean accSpent;
    private int velAttuale;
    private int range;      //km con litro

    //costruttore
    public Car(String marca, String modello, String colore, String targa, int nPorte, int capienza, String Carburante, int velMax, double consumo, double kmTot, int capacitaSerb, boolean accSpent) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.targa = targa;
        this.nPorte = nPorte;
        this.Carburante = Carburante;
        this.velMax = velMax;
        this.capienza = capienza;
        this.consumo = consumo;
        this.kmTot = kmTot;
        this.capacitaSerb = capacitaSerb;
        this.accSpent = false;
    }

    public void accensioneSpegnimento(boolean accSpent) {
        if (accSpent) {
            accSpent = false;
            System.out.println("Spegnimento macchina..");

        } else {
            accSpent = true;
            System.out.println("Accensione macchina..");
        }
    }

    public boolean muovi(int kmParx, int velAttuale) {
        boolean movimento;
        
        range = calcRange(capacitaSerb, kmParx, consumo);

        if(kmParx < range) {
            movimento = true;
        } else {
            movimento = false;
        }
            
        return movimento;
    }

    public int rifornimento() {
        return livelloSerb = 100;
    }

    public int calcRange(int capacitaSerb, int livelloSerb, double consumo) {
        int range;

        range = (int)((livelloSerb/consumo)*100);          //km con attuale livello Serb

        return range;
    }

    public void incrementoDecremento() {
        this.velAttuale = velAttuale;
    }

    public void chiamataCarroAttrezzi() {
        System.out.println("Il carro attrezzi ti ha portato al distributore più vicino..");
        System.out.println("Rifornimento in corso..");
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " Modello: " + modello + " Colore: " + colore + 
        "\nTarga: " + targa + " nPorte: " + nPorte + " Capienza: " + capienza + 
        " Carburante: " + Carburante + "\nVelocità max: " + velMax + " Km totali: " + kmTot;
    }
}
