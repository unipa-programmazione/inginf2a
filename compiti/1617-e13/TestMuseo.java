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

class Opera {
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

class Scultura extends Opera {
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

class Dipinto extends Opera {
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

		Scanner keyboard = new Scanner(System.in);
		List<Opera
		> opere = new ArrayList<>();
		Museo nuovomuseo = new Museo();

		nuovomuseo.SetNome("Galleria degli Uffizi");
		nuovomuseo.SetIndirizzo("Firenze, Piazzale degli Uffizi, 6");
	
		do {
			System.out.println("benvenuto nel sistema di gestione delle opere del museo "+nuovomuseo.GetNome()+" sito  "+nuovomuseo.GetIndirizzo());
			System.out.println("1: aggiungi nuova opera d'arte");
			System.out.println("2: stampa le opere d'arte");
			System.out.println("3: trova un'opera d'arte in base al titolo");
			System.out.println("4: elimina un'opera d'arte");

			String input = keyboard.nextLine();
			switch (input) {
				case "1":
					System.out.println("inserisci il tipo di opera (scultura|dipinto)");
					String tastiera = keyboard.nextLine();
					switch(tastiera){
						case "scultura":
							opere.add(CreaScultura());
							System.out.println("Fatto.");
							break;
						case "dipinto":
							opere.add(CreaDipinto());
							System.out.println("Fatto.");
							break;
					}
					break;
				case "2":
					StampaDipinti(opere);
					StampaSculture(opere);
					break;
				case "3":
					CercaOpere(opere);
					break;
				}
		}
		while(true);
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
		return dipinto1;
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
		return scultura1;
	}
	
	public static void StampaDipinti(List<Opera> opere) {
		List<Dipinto> dipinti = new ArrayList<>();
		for(Opera s:opere) {
			if(s.getClass().getName().equalsIgnoreCase("dipinto")) {
				dipinti.add((Dipinto) s);
			}
		}
		for(Dipinto s:dipinti) {
			System.out.println("Titolo: "+s.GetTitolo());
			System.out.println("\tAutore "+s.GetAutore());
			System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
			System.out.println("\tTecnica:"+(s.GetTecnica()));
			System.out.println("\tDimensioni:"+(s.GetDimensione()));
		}
	}

	public static void StampaSculture(List<Opera> opere) {
		List<Scultura> sculture = new ArrayList<>();
		for(Opera s:opere) {
			if(s.getClass().getName().equalsIgnoreCase("scultura")) {
				sculture.add((Scultura) s);
			}
		}
		for(Opera s:sculture) {
			System.out.println("Titolo: "+s.GetTitolo());
			System.out.println("\tAutore "+s.GetAutore());
			System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
			System.out.println("\tMateriale:"+((Scultura)s).GetMateriale());
			System.out.println("\tAltezza:"+((Scultura)s).GetAltezza());
		}
	}

	public static void CercaOpere(List<Opera> opere) {
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			System.out.println("inserisci titolo dell'opera");
			String titoloOpera = keyboard.nextLine();

			for(Opera s:opere){
				if(s.GetTitolo().equalsIgnoreCase(titoloOpera)) {
					if(s.getClass().getName().equalsIgnoreCase("dipinto")) {
						System.out.println("Titolo: "+s.GetTitolo());
						System.out.println("\tAutore "+s.GetAutore());
						System.out.println("\tData di Creazione: "+s.GetdatadiCreazione());
						System.out.println("\tTecnica:"+((Dipinto) s).GetTecnica());
						System.out.println("\tDimensioni:"+((Dipinto) s).GetDimensione());
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
}
