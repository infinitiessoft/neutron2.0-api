package com.infinities.neutron.ports.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Ports implements Iterable<Port>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "ports")
	private List<Port> list;


	/**
	 * @return the list
	 */
	public List<Port> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Port> list) {
		this.list = list;
	}

	@Override
	public Iterator<Port> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		return "Ports [list=" + list + "]";
	}

}
