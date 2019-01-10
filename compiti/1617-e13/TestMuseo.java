import java.io.*;
import java.util.*;
import java.util.Scanner;


class Museo {
	private String nome;
	private String indirizzo;

	public String GetNome() {
		return this.nome;
	}
	public String GetIndirizzo() {
		return this.indirizzo;
	}

	public void SetNome(String nome) {
		this.nome = nome;
	}
	public void SetIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}

class OperaArte {
	String titolo;
	String autore;
	String datadiCreazione;

	public String GetTitolo() {
		return this.titolo;
	}
	public String GetAutore() {
		return this.autore;
	}
	public String GetdatadiCreazione(){
		return this.datadiCreazione;
	}
	public void SetTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void SetAutore(String autore) {
		this.autore = autore;
	}
	public void SetdatadiCreazione(String datadiCreazione) {
		this.datadiCreazione = datadiCreazione;
	}
}

class Scultura extends OperaArte {
	String materiale;
	int altezza;

	public String GetMateriale(){
		return this.materiale;
	}
	public int GetAltezza() {
		return this.altezza;
	}
	public void SetMateriale(String materiale) {
		this.materiale = materiale;
	}
	public void SetAltezza(int altezza) {
		this.altezza = altezza;
	}
}

class Dipinto extends OperaArte {
	String tecnica;
	String dimensione;

	public String GetTecnica() {
		return this.tecnica;
	}
	public String GetDimensione() {
		return this.dimensione;
	}
	public void SetTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public void SetDimensione(String dimensione){
		this.dimensione = dimensione;
	}
}

public class TestMuseoo {
	public static void main(String[] args) {
		List<Dipinto> dipinti = new ArrayList<>();
		List<Scultura> sculture = new ArrayList<>();


		Museo nuovomuseo = new Museo();
		nuovomuseo.SetNome("Galleria degli Uffizi");
		nuovomuseo.SetIndirizzo("Firenze, Piazzale degli Uffizi, 6");
	
		Scanner keyboard = new Scanner(System.in);
		for(int i=0; i<=2; i++) {
			System.out.println("benvenuto nel sistema di gestione delle opere del museo "+nuovomuseo.GetNome()+" sito  "+nuovomuseo.GetIndirizzo());
			System.out.println("1: aggiungi nuova opera d'arte");
			System.out.println("2: stampa le opere d'arte");
			System.out.println("3: trova un'opera d'arte in base al titolo");
			System.out.println("4: elimina un'opera d'arte");

			int input = keyboard.nextInt();
			switch (input) {
				case 1:
					System.out.println("inserisci il tipo di opera");
					String tastiera = keyboard.nextLine();
					switch(tastiera){
						case "scultura":
							sculture.add(CreaScultura());
							System.out.println("Fatto.");
							break;
						case "dipinto":
							dipinti.add(CreaDipinto());
							System.out.println("Fatto.");
							break;
					}
					break;
				case 2:
					StampaDipinti(dipinti);
					StampaSculture(sculture);
					break;
				}
				// case 3:
					// CercaOpere(opere);
					// break;
		}
	}

	public static Dipinto CreaDipinto() {
	Scanner keyboard = new Scanner(System.in);
		Dipinto dipinto1 = new Dipinto();
		System.out.println("inserisci il titolo dell'opera:");
		dipinto1.SetTitolo(keyboard.nextLine());
		System.out.println("inserisci autore dell'opera:");
		dipinto1.SetAutore(keyboard.nextLine());
		System.out.println("inserisci data di creazione:");
		dipinto1.SetdatadiCreazione(keyboard.nextLine());
		System.out.println("inserisci la tecnica:");
		dipinto1.SetTecnica(keyboard.nextLine());
		System.out.println("inserisci dimensioni:");
		dipinto1.SetDimensione(keyboard.nextLine());
		return null;
	}

	

	public static Scultura CreaScultura(){
		Scanner keyboard = new Scanner(System.in);
		Scultura scultura1 = new Scultura();
		System.out.println("inserisci il titolo dell'opera:");
		scultura1.SetTitolo(keyboard.nextLine());
		System.out.println("inserisci autore dell'opera:");
		scultura1.SetAutore(keyboard.nextLine());
		System.out.println("inserisci data di creazione:");
		scultura1.SetdatadiCreazione(keyboard.nextLine());
		System.out.println("inserisci tipo di materiale:");
		scultura1.SetMateriale(keyboard.nextLine());
		System.out.println("inserisci altezza:");
		scultura1.SetAltezza(keyboard.nextInt());
		return null;
	}
	
	public static void StampaDipinti(List<Dipinto> dipinti) {
		for(Dipinto s:dipinti) {
			System.out.println("Titolo: "+s.GetTitolo());
			System.out.println("\tAutore "+s.GetAutore());
			System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
			System.out.println("\tTecnica:"+(s.GetTecnica()));
			System.out.println("\tDimensioni:"+(s.GetDimensione()));
		}
	}

	public static void StampaSculture(List<Scultura> sculture) {
		for(Scultura s:sculture) {
			System.out.println("Titolo: "+s.GetTitolo());
			System.out.println("\tAutore "+s.GetAutore());
			System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
			System.out.println("\tMateriale:"+((Scultura)s).GetMateriale());
			System.out.println("\tAltezza:"+((Scultura)s).GetAltezza());
		}
	}
}
/*

	public static void CercaOpere(List<OperaArte> opere) {
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			System.out.println("inserisci titolo dell'opera");
			String TitoloOpera = keyboard.nextLine();

			for(OperaArte s:opere){
				if(s.GetTitolo().equals(TitoloOpera)) {
					if(s.getClass().getName().equals(Dipinto) {
						System.out.println("Titolo: "+s.GetTitolo());
						System.out.println("\tAutore "+s.GetAutore());
						System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
						System.out.println("\tTecnica:"+((Dipinto)s).GetTecnica());
						System.out.println("\tDimensioni:"+((Dipinto)s).GetDimensione());
					}
					else {
						System.out.println("Titolo: "+s.GetTitolo());
						System.out.println("\tAutore "+s.GetAutore());
						System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
						System.out.println("\tMateriale:"+((Scultura)s).GetMateriale());
						System.out.println("\tAltezza:"+((Scultura)s).GetAltezza());
					}
				}
			}
		}
	}
} */


