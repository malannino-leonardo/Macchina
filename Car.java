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
    private int capacitaSerb;
    private int livelloSerb;
    private boolean accSpent;
    private int velMedia;
    private int range;      //km con litro

    //costruttore
    public Car(String marca, String modello, String colore, String targa, int nPorte, String Carburante, int velMax, int capienza, double consumo, double kmTot, int capacitaSerb, int livelloSerb, boolean accSpent, int velMedia, int range) {
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
        this.livelloSerb = livelloSerb;
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

    public boolean muovi(double kmParx) {
        boolean movimento;
        
        range = calcRange(livelloSerb, consumo);

        if(kmParx <= range) {
            movimento = true;
            this.livelloSerb -= ((consumo/100)*kmParx);
            this.kmTot += kmParx;
        } else {
            movimento = false;
        }

        if(velMedia > velMax) {
            System.err.println("ATTENZIONE! La macchina sta eccedendo la velocità massima");
        }
            
        return movimento;
    }

    public int rifornimento() {
        return livelloSerb = 100;
    }

    public int calcRange(int livelloSerb, double consumo) {
        int range;

        range = (int)((livelloSerb/consumo)*100);          //km con attuale livello Serb

        return range;
    }

    public void incrementoDecremento() {
        this.velMedia = velMedia;
    }

    public void chiamataCarroAttrezzi() {
        System.out.println("Il carro attrezzi ti ha portato al distributore più vicino..");
        System.out.println("Rifornimento in corso..");
        livelloSerb = rifornimento();
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " Modello: " + modello + " Colore: " + colore + 
        "\nTarga: " + targa + " nPorte: " + nPorte + " Capienza: " + capienza + 
        " Carburante: " + Carburante + "\nVelocità max: " + velMax + " Km totali: " + kmTot;
    }

    public String messaggioArrivo() {
        return "Carburante rimasto: " + livelloSerb + "l" +
        "\nKm totali: " + kmTot;
    }
}
