package com.infinities.neutron.subnets.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Subnets implements Serializable, Iterable<Subnet> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "subnets")
	private List<Subnet> list;


	/**
	 * @return the list
	 */
	public List<Subnet> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Subnet> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Subnets [list=" + list + "]";
	}

	@Override
	public Iterator<Subnet> iterator() {
		return list.iterator();
	}

}
