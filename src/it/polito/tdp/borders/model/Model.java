package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;
import it.polito.tdp.borders.db.TestDAO;

public class Model {

	SimpleGraph<Country, DefaultEdge> grafo;
	BordersDAO dao = new BordersDAO();
	Map<Integer, Country> idMap = new HashMap<Integer, Country>();
	ConnectivityInspector<Country,DefaultEdge> conan;
	
	public Model() {
		
	}
	
	public void creaGrafo(int anno){
		
		grafo = new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		List<Country> paesi = dao.loadAllCountries();
		for(Country country : paesi)
			idMap.put(country.getCod(), country);
		
		List<Border> confini = dao.getCountryPairs(anno);
		for(Border border : confini) {
			
			grafo.addVertex(idMap.get(border.getCod1()));
			grafo.addVertex(idMap.get(border.getCod2()));
			Country source = idMap.get(border.getCod1());
			Country target = idMap.get(border.getCod2());
			grafo.addEdge(source, target);
		}
		
	}

	public int calcolaConfini() {
		// TODO Auto-generated method stub
		conan = new ConnectivityInspector<Country,DefaultEdge>(grafo);
		
		return conan.connectedSets().size();
	}

	public List<Country> ritornaStati() {
		// TODO Auto-generated method stub
		List<Country> result = new ArrayList<Country>();
		
		result.addAll(grafo.vertexSet());
		
		return result;
	}
	
	public int getConnessi(Country c) {
		
		return grafo.degreeOf(c);
	}
	
	public int vertici() {
		return grafo.vertexSet().size();
	}
	
	public int archi() {
		return grafo.edgeSet().size();
	}

}
