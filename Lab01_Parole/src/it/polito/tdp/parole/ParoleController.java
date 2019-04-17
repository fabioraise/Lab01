package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtTempi"
    private TextArea txtTempi; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	long t1 = System.nanoTime();
    	String p = txtParola.getText();
    	elenco.addParola(p);
    	
    	txtResult.clear();
    	
    	for(String s : elenco.getElenco()) {
    		txtResult.appendText(s + "\n");
    	}
    	long t2 = System.nanoTime();
    	txtTempi.appendText((t2-t1)/1e6 + " ms\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	long t1 = System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	long t2 = System.nanoTime();
    	txtTempi.appendText((t2-t1)/1e6 + " ms\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long t1 = System.nanoTime();
    	String p = txtParola.getText();
    	if(elenco.cancella(p)) {
    		txtResult.clear();
    		for(String s : elenco.getElenco())
    			txtResult.appendText(s + "\n");
    	}
    	else
    		txtResult.appendText(String.format("La parola %s non è presente nell'elenco di parole\n", p));
    	long t2 = System.nanoTime();
    	txtTempi.appendText((t2-t1)/1e6 + " ms\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
