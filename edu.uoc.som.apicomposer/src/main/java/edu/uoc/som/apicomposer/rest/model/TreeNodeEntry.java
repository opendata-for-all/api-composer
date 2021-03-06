package edu.uoc.som.apicomposer.rest.model;

import java.io.Serializable;

public class TreeNodeEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nodeName;
	private String nodeDescription;
	
	public TreeNodeEntry(String nodeName, String nodeDescription) {
		super();
		this.nodeName = nodeName;
		this.nodeDescription = nodeDescription;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeDescription() {
		return nodeDescription;
	}
	public void setNodeDescription(String nodeDescription) {
		this.nodeDescription = nodeDescription;
	}
	
}