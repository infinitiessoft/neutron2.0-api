package com.infinities.neutron.networks.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "network")
public class Network implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;

	private List<String> subnets;

	private String name;

	@XmlElement(name = "admin_state_up")
	private Boolean adminStateUp;

	@XmlElement(name = "tenant_id")
	private String tenantId;

	@XmlElement(name = "provider:physical_network")
	private String providerPhysicalNetwork;

	@XmlElement(name = "provider:network_type")
	private String providerNetworkType;

	@XmlElement(name = "provider:segmentation_id")
	private Integer providerSegmentationId;

	@XmlElement(name = "router:external")
	private Boolean routerExternal;

	private String id;

	private Boolean shared;


	/**
	 * @return the status
	 */
	@XmlTransient
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the subnets
	 */
	public List<String> getSubnets() {
		return subnets;
	}

	/**
	 * @param subnets
	 *            the subnets to set
	 */
	public void setSubnets(List<String> subnets) {
		this.subnets = subnets;
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

	@XmlTransient
	public String getProviderPhyNet() {
		return getProviderPhysicalNetwork();
	}

	@XmlTransient
	public void setProviderPhyNet(String providerPhyNet) {
		setProviderPhysicalNetwork(providerPhyNet);
	}

	public Boolean getAdminStateUp() {
		return adminStateUp;
	}

	/**
	 * @param adminStateUp
	 *            the adminStateUp to set
	 */
	public void setAdminStateUp(Boolean adminStateUp) {
		this.adminStateUp = adminStateUp;
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
	 * @return the routerExternal
	 */
	public Boolean getRouterExternal() {
		return routerExternal;
	}

	/**
	 * @param routerExternal
	 *            the routerExternal to set
	 */
	public void setRouterExternal(Boolean routerExternal) {
		this.routerExternal = routerExternal;
	}

	/**
	 * @return the id
	 */
	@XmlTransient
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@JsonProperty
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the shared
	 */
	public Boolean getShared() {
		return shared;
	}

	/**
	 * @param shared
	 *            the shared to set
	 */
	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	public String getProviderNetworkType() {
		return providerNetworkType;
	}

	public void setProviderNetworkType(String providerNetworkType) {
		this.providerNetworkType = providerNetworkType;
	}

	public String getProviderPhysicalNetwork() {
		return providerPhysicalNetwork;
	}

	public void setProviderPhysicalNetwork(String providerPhysicalNetwork) {
		this.providerPhysicalNetwork = providerPhysicalNetwork;
	}

	public Integer getProviderSegmentationId() {
		return providerSegmentationId;
	}

	public void setProviderSegmentationId(Integer providerSegmentationId) {
		this.providerSegmentationId = providerSegmentationId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Network [id=" + id + ", name=" + name + ", subnets=" + subnets + ", status=" + status + ", admin_state_up="
				+ adminStateUp + ", tenant_id=" + tenantId + ", shared=" + shared + ", provider:physical_network="
				+ providerPhysicalNetwork + ", provider:network_type=" + providerNetworkType + ", router:external="
				+ routerExternal + ", provider:segmentation_id=" + providerSegmentationId + "]";
	}
}
