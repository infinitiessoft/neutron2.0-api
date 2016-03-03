package com.infinities.neutron.networks.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Networks implements Iterable<Network>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "networks")
	private List<Network> list;


	/**
	 * @return the list
	 */
	public List<Network> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Network> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Networks [list=" + list + "]";
	}

	@Override
	public Iterator<Network> iterator() {
		return list.iterator();
	}

}
