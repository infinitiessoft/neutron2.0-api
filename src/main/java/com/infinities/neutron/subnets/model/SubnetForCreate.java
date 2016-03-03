package com.infinities.neutron.subnets.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Please use {@link Subnet} directly.
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "subnet")
public class SubnetForCreate extends Subnet {

	/**
	 * @return the ipVersion
	 */
	@XmlTransient
	public int getIpVersion() {
		return getIpversion().code();
	}

	/**
	 * @param ipVersion
	 *            the ipVersion to set
	 */
	@XmlTransient
	public void setIpVersion(int ipVersion) {
		setIpversion(IpVersion.valueOf(ipVersion));
	}
}
