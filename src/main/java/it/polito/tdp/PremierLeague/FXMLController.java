/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.PremierLeague.model.Coppia;
import it.polito.tdp.PremierLeague.model.Match;
import it.polito.tdp.PremierLeague.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnConnessioneMassima"
    private Button btnConnessioneMassima; // Value injected by FXMLLoader

    @FXML // fx:id="btnCollegamento"
    private Button btnCollegamento; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinuti"
    private TextField txtMinuti; // Value injected by FXMLLoader

    @FXML // fx:id="cmbMese"
    private ComboBox<Integer> cmbMese; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM1"
    private ComboBox<Match> cmbM1; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM2"
    private ComboBox<Match> cmbM2; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doConnessioneMassima(ActionEvent event) {
    	
  
txtResult.clear();
    	
    	try {
    		
    		int min = Integer.parseInt(this.txtMinuti.getText());
    		int mese = this.cmbMese.getValue();
    		if(min>90 ||min<1) {
    			txtResult.appendText("inserire un valore tra 1 e 90");
    		}
    		
    		if(mese == 0) {
    			txtResult.appendText("Selezionare un mese!!");
    		}
    		
    		List<Coppia> r =this.model.getConnessioneMax(mese, min);
    		txtResult.appendText("Coppi con conn max :\n"+r);
    		
    	}catch(NumberFormatException e) {
    		txtResult.appendText("errore, inserire un valore");
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*	txtResult.clear();
    	
    	int m = this.cmbMese.getValue();
    	
		txtResult.appendText("Connessione massima trovata: \n"+this.model.getMaxConnessione(m, Integer.parseInt(txtMinuti.getText())));
		
    	
    	
    */
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	try {
    		
    		int min = Integer.parseInt(this.txtMinuti.getText());
    		int mese = this.cmbMese.getValue();
    		if(min>90 ||min<1) {
    			txtResult.appendText("inserire un valore tra 1 e 90");
    		}
    		
    		if(mese == 0) {
    			txtResult.appendText("Selezionare un mese!!");
    		}
    		
    		String msg = this.model.creg(mese, min);
    		txtResult.appendText(msg);
    		
    	}catch(NumberFormatException e) {
    		txtResult.appendText("errore, inserire un valore");
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*	txtResult.clear();
    	int m = this.cmbMese.getValue();
    	
    	
    	try {
    		
    		int minuti = Integer.parseInt(txtMinuti.getText()) ;
    		this.model.creaGrafo(m,minuti);
    		
    	}catch(NumberFormatException e) {
    		txtResult.appendText("Inserisci un numero di minuti valido");
    	}
    	
    	
    
    	txtResult.appendText("Grafo creato!! \n");
    	txtResult.appendText("#vertici: "+ this.model.nVertici()+"\n");
    	txtResult.appendText("# archi: " +this.model.nArchi());
    	
    	this.cmbM1.getItems().addAll(this.model.getVertici());
    	this.cmbM2.getItems().addAll(this.model.getVertici());
    	
    	*/
    }

    @FXML
    void doCollegamento(ActionEvent event) {
  
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/* 	
    	Match m1 = this.cmbM1.getValue();
    	Match m2 = this.cmbM2.getValue();
    	
    	if(m1== null || m2 == null) {
    		txtResult.appendText("Seleziona i matchi");
    		return;
    	}
    	txtResult.clear();
    	List<Match > lista = this.model.cercaMax(m1, m2);
    	
    	for(Match m: lista) {
    		txtResult.appendText(this.model.geLivOttimo()+"Cammino trovato : "+ m.toString()+"\n ");
    	}
    	*/
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnConnessioneMassima != null : "fx:id=\"btnConnessioneMassima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCollegamento != null : "fx:id=\"btnCollegamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinuti != null : "fx:id=\"txtMinuti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbMese != null : "fx:id=\"cmbMese\" was not injected: check your FXML file 'Scene.fxml'.";        assert cmbM1 != null : "fx:id=\"cmbM1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbM2 != null : "fx:id=\"cmbM2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	for(int i =1;i<=12;i++) {
    		this.cmbMese.getItems().addAll(i);
    	}
    }
    
    
}
