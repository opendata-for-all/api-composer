package edu.uoc.som.apicomposer.rest.model;

import java.io.Serializable;

public class TreeNodeWithTracking implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	private boolean newElement;
	
	
	public TreeNodeWithTracking(String value, boolean newElement) {
		super();
		this.value = value;
		this.newElement = newElement;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isNewElement() {
		return newElement;
	}
	public void setNewElement(boolean newElement) {
		this.newElement = newElement;
	}
	
}
