package com.infinities.neutron.subnets.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@XmlRootElement(name = "subnet")
public class Subnet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	@XmlElement(name = "enable_dhcp")
	private Boolean enableDHCP;

	@XmlElement(name = "network_id")
	private String networkId;

	@XmlElement(name = "tenant_id")
	private String tenantId;

	@XmlElement(name = "dns_nameservers")
	private List<String> dnsNames;

	@XmlElement(name = "allocation_pools")
	private List<Pool> list;

	@XmlElement(name = "host_routes")
	private List<String> hostRoutes;

	@XmlElement(name = "ip_version")
	private IpVersion ipversion;

	@XmlElement(name = "gateway_ip")
	private String gw;

	private String cidr;

	private String id;


	public static enum IpVersion implements Serializable {
		IPV4(4), IPV6(6);

		private int code;


		IpVersion(int code) {
			this.code = code;
		}

		@JsonValue
		public int code() {
			return code;
		}

		@JsonCreator
		public static IpVersion valueOf(int value) {
			for (IpVersion ipVersion : IpVersion.values()) {
				if (ipVersion.code() == value) {
					return ipVersion;
				}
			}
			return IPV4;
		}

		@Override
		public String toString() {
			return String.valueOf(code);
		}
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enableDHCP
	 */
	@XmlTransient
	public boolean isEnableDHCP() {
		return enableDHCP;
	}

	@XmlElement(name = "enableDHCP")
	public Boolean getEnableDHCP() {
		return enableDHCP;
	}

	/**
	 * @param enableDHCP
	 *            the enableDHCP to set
	 */
	public void setEnableDHCP(Boolean enableDHCP) {
		this.enableDHCP = enableDHCP;
	}

	/**
	 * @return the networkId
	 */
	public String getNetworkId() {
		return networkId;
	}

	/**
	 * @param networkId
	 *            the networkId to set
	 */
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId
	 *            the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the dnsNames
	 */
	public List<String> getDnsNames() {
		return dnsNames;
	}

	/**
	 * @param dnsNames
	 *            the dnsNames to set
	 */
	public void setDnsNames(List<String> dnsNames) {
		this.dnsNames = dnsNames;
	}

	/**
	 * @return the list
	 */
	public List<Pool> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Pool> list) {
		this.list = list;
	}

	/**
	 * @return the hostRoutes
	 */
	public List<String> getHostRoutes() {
		return hostRoutes;
	}

	/**
	 * @param hostRoutes
	 *            the hostRoutes to set
	 */
	public void setHostRoutes(List<String> hostRoutes) {
		this.hostRoutes = hostRoutes;
	}

	/**
	 * @return the ipversion
	 */
	public IpVersion getIpversion() {
		return ipversion;
	}

	/**
	 * @param ipversion
	 *            the ipversion to set
	 */
	public void setIpversion(IpVersion ipversion) {
		this.ipversion = ipversion;
	}

	/**
	 * @return the gw
	 */
	public String getGw() {
		return gw;
	}

	/**
	 * @param gw
	 *            the gw to set
	 */
	public void setGw(String gw) {
		this.gw = gw;
	}

	/**
	 * @return the cidr
	 */
	public String getCidr() {
		return cidr;
	}

	/**
	 * @param cidr
	 *            the cidr to set
	 */
	public void setCidr(String cidr) {
		this.cidr = cidr;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subnet [id=" + id + ", name=" + name + ", network_id=" + networkId + ", tenant_id=" + tenantId
				+ ", allocation_pools=" + list + ", gateway_ip=" + gw + ", ip_version=" + ipversion + ", cidr=" + cidr
				+ ", enable_dhcp=" + enableDHCP + ", dns_nameservers=" + dnsNames + ", host_routes=" + hostRoutes + "]";
	}

}
