package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		// this.parole = new LinkedList<String>();
		this.parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(this.parole);
		return this.parole;
	}
	
	public void reset() {
		this.parole.clear();
	}
	
	public boolean cancella(String p) {
		if(parole.contains(p)) {
			this.parole.remove(p);
			return true;
		}
		else
			return false;
	}

}
