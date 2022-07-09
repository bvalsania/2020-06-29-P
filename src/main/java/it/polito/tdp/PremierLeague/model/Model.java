package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private PremierLeagueDAO dao;
	private Map<Integer, Match> idMap;
	private Graph<Match, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new PremierLeagueDAO();
		idMap = new HashMap<>();
		this.dao.listAllMatches(idMap);
	}
	
	
	public String creg(int mese, int min) {
		
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, this.dao.getvert(mese, idMap));
		
		for(Coppia c : this.dao.geta(mese, min, idMap)) {
			Graphs.addEdge(this.grafo, c.getM1(), c.getM2(), c.getPeso());

		}
		
		return "Il grafo creato ha vertici e archi :  "+this.grafo.vertexSet().size()+"  "+ this.grafo.edgeSet().size();
	}
	
	
	public List<Coppia> getConnessioneMax(int mese,int min){
		List<Coppia> result = new ArrayList<>();
		int max = 0;
		
		for(Coppia c : this.dao.geta(mese, min, idMap)) {
			if(c.getPeso()>max) {
				max = c.getPeso();
				result.clear();
				result.add(c);
			}else if(c.getPeso() == max) {
				result.add(c);
			}
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	private PremierLeagueDAO dao;
	private Graph<Match, DefaultWeightedEdge> grafo;
	private Map<Integer, Match> idMap;
	
	private List<Match> ottimo;
	private int lOttimo;
	

	public List<Match> cercaMax(Match start, Match end) {
		List<Match> parziale = new ArrayList<>();
		ottimo = new ArrayList<>();
		
		parziale.add(start);
		cerca(parziale,0, end);
		
		return ottimo;
		
	}
	
	
	private void cerca(List<Match> parziale, int l, Match end) {

		
		// condizione di terminazione
		if(parziale.get(parziale.size()-1).equals(end)) {
			if(l > lOttimo) {
				lOttimo= l;
				ottimo = new ArrayList<>(parziale);
			}
			return ;
		}
		
		Match last = parziale.get(parziale.size()-1);
		List<Match> vicini = Graphs.neighborListOf(this.grafo, last);
		
		for(Match m : vicini) {
			DefaultWeightedEdge e = this.grafo.getEdge(m, last);
			
			if(!parziale.contains(m) && e!=null) {
				if(last.getTeamHomeID()!= m.getTeamHomeID() || last.getTeamAwayID()!= m.getTeamAwayID() 
						|| last.getTeamHomeID()!=m.getTeamAwayID() || last.getTeamAwayID()!=m.getTeamHomeID()  ) {
					parziale.add(m);
					l += this.grafo.getEdgeWeight(e); // per incrementare livello (peso)
					cerca(parziale, l, end);
					parziale.remove(m);
					l -= this.grafo.getEdgeWeight(e); 
					
				}
			}
		}
		
	}
	
	public int geLivOttimo() {
		return lOttimo;
	}


	public Model () {
		dao = new PremierLeagueDAO();
		idMap = new HashMap<>();
		this.dao.listAllMatches(idMap);
		
	}
	
	public void creaGrafo(int mese, int min) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//aggiugni i vertici 
		
		Graphs.addAllVertices(grafo, this.dao.getVertici(mese, idMap));
		
		//aggiugniamo archi
		for(Coppia c: this.dao.getArchi(mese, min, idMap)) {
		Graphs.addEdgeWithVertices(grafo, c.getM1(), c.getM2(), c.getPeso());
		
		
		}
	}
	
	public int nVertici(){
		return this.grafo.vertexSet().size();
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	public List<Match> getVertici(){
		return new ArrayList<>(this.grafo.vertexSet());
	}
	
	public List<Coppia> getMaxConnessione(int mese, int min){
		
		List<Coppia> coppia = new ArrayList<>();
		int max = 0;
		
		for(Coppia c : this.dao.getArchi(mese, min, idMap)) {
			if(c.getPeso()> max) {
				max = c.getPeso();
				coppia.clear();
				coppia.add(c);
				
			}else if (c.getPeso()== max) {
				coppia.add(c);
			}
		}
		return coppia;
	}
	
*/	
}
