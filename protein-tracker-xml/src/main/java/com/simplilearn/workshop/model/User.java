package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class User {

	private int id;
	private String name;
	
	
	// hibernate uses this no arg constructor
	public User(){
		super();
	}

	//
	private ProteinData proteinData = new ProteinData();
	
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}
	
	public ProteinData getProteinData() {
		return proteinData;
	}
	
	//value type using Set collection
	/*private Set<UserHistory> history = new HashSet<>();
	
	public Set<UserHistory> getHistory() {
		return history;
	}
	
	public void setHistory(Set<UserHistory> history) {
		this.history = history;
	}*/
	
	/*private List<UserHistory> history = new ArrayList<>();
	
	public List<UserHistory> getHistory() {
		return history;
	}
	
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	*/
	
	/*private Map<String, UserHistory> history = new HashMap<>();
	
	public Map<String, UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Map<String, UserHistory> history) {
		this.history = history;
	}
	*/
	
	private Collection<UserHistory> history = new ArrayList<UserHistory>();
	
	public Collection<UserHistory> getHistory() {
		return history;
	}
	
	public void setHistory(Collection<UserHistory> history) {
		this.history = history;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
