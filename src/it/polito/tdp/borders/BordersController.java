package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;
	
	void setModel(Model m) {
		this.model = m;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnno;

    @FXML
    private Button btnCalcola;

    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private Button btnTrova;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaConfini(ActionEvent event) {

    	txtResult.clear();

    	try {
    		
    		model.creaGrafo(Integer.parseInt(txtAnno.getText()));
    		txtResult.appendText("Stato    Numero paesi confinanti\n");
    		for(Country c : model.ritornaStati())
    			txtResult.appendText(c.getStateAbb()+"     "+model.getConnessi(c)+"\n");
    		txtResult.appendText("Componenti connesse nel grafo: "+model.calcolaConfini());
    		txtResult.appendText("\nVertici: "+model.vertici()+"    Archi: "+model.archi());
    		
    		for(Country country : model.getGrafo().vertexSet())
    			this.ComboBox.getItems().add(country.getStateAbb());
    		
    	} catch(NumberFormatException n) {
    		txtResult.appendText("Inserisci un valore valido per l'anno");
    	}
    	
    }

    @FXML
    void doTrova(ActionEvent event) {

    	List<Country> raggiungibili = model.getConfinanti(ComboBox.getValue());
    	txtResult.clear();
    	txtResult.appendText("Paesi confinanti: "+raggiungibili.size()+"\n");
    	for(Country country : raggiungibili) {
    		txtResult.appendText(country.getStateAbb()+"\n");
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Borders.fxml'.";
        assert ComboBox != null : "fx:id=\"ComboBox\" was not injected: check your FXML file 'Borders.fxml'.";
        assert btnTrova != null : "fx:id=\"btnTrova\" was not injected: check your FXML file 'Borders.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";

    }
}


