package com.infinities.neutron.ports.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "port")
public class Port implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static final class Ip implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@XmlElement(name = "ip_address")
		private String address;

		@XmlElement(name = "subnet_id")
		private String subnetId;


		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}

		/**
		 * @param address
		 *            the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * @return the subnetId
		 */
		public String getSubnetId() {
			return subnetId;
		}

		/**
		 * @param subnetId
		 *            the subnetId to set
		 */
		public void setSubnetId(String subnetId) {
			this.subnetId = subnetId;
		}

		@Override
		public String toString() {
			return "ip_addresses [ip_address=" + address + ", subnet_id=" + subnetId + "]";
		}

	}

	public static final class Binding {

		/**
		 * The host on which the port will be allocated.
		 */
		@XmlElement(name = "binding:host_id")
		private String hostId;

		/**
		 * The vif type for the specific port.
		 */
		@XmlElement(name = "binding:vif_type")
		private String vifType;

		/**
		 * The type of vnic that this port should be attached to
		 */
		@XmlElement(name = "binding:vnic_type")
		private String vnicType;

		/**
		 * A map containing additional information needed by the interface
		 * driver
		 */
		@XmlElement(name = "binding:vif_details")
		private Map<String, String> vifDetails;

		/**
		 * A map to enable applications running on the specific host to pass and
		 * receive vif port specific information to the plugin.
		 */
		@XmlElement(name = "binding:profile")
		private Map<String, String> profile;


		public String getHostId() {
			return hostId;
		}

		public void setHostId(String hostId) {
			this.hostId = hostId;
		}

		public String getVifType() {
			return vifType;
		}

		public void setVifType(String vifType) {
			this.vifType = vifType;
		}

		public String getVnicType() {
			return vnicType;
		}

		public void setVnicType(String vnicType) {
			this.vnicType = vnicType;
		}

		public Map<String, String> getVifDetails() {
			return vifDetails;
		}

		public void setVifDetails(Map<String, String> vifDetails) {
			this.vifDetails = vifDetails;
		}

		public Map<String, String> getProfile() {
			return profile;
		}

		public void setProfile(Map<String, String> profile) {
			this.profile = profile;
		}

		@Override
		public String toString() {
			return "Binding [hostId=" + hostId + ", vifType=" + vifType + ", vnicType=" + vnicType + ", vifDetails="
					+ vifDetails + ", profile=" + profile + "]";
		}
	}


	@XmlElement(name = "admin_state_up")
	private Boolean adminStateUp;

	@XmlElement(name = "device_id")
	private String deviceId;

	@XmlElement(name = "device_owner")
	private String deviceOwner;

	@XmlElement(name = "fixed_ips")
	private List<Ip> list;

	private String id;

	@XmlElement(name = "mac_address")
	private String macAddress;

	private String name;

	@XmlElement(name = "network_id")
	private String networkId;

	private String status;

	@XmlElement(name = "tenant_id")
	private String tenantId;

	@XmlElement(name = "security_groups")
	private List<String> securityGroups;

	private Binding binding;


	/**
	 * @return the adminStateUp
	 */
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
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the deviceOwner
	 */
	public String getDeviceOwner() {
		return deviceOwner;
	}

	/**
	 * @param deviceOwner
	 *            the deviceOwner to set
	 */
	public void setDeviceOwner(String deviceOwner) {
		this.deviceOwner = deviceOwner;
	}

	/**
	 * @return the list
	 */
	public List<Ip> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Ip> list) {
		this.list = list;
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

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress
	 *            the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the associated security group IDs
	 */
	public List<String> getSecurityGroups() {
		return securityGroups;
	}

	/**
	 * @param securityGroups
	 *            IDs of security groups to associate to the port
	 */
	public void setSecurityGroups(List<String> securityGroups) {
		this.securityGroups = securityGroups;
	}

	/**
	 * @return the binding of the port
	 */
	public Binding getBinding() {
		return binding;
	}

	/**
	 * @param binding
	 *            The port bindings by which the port is bind to network on host
	 */
	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	@Override
	public String toString() {
		return "Port [id=" + id + ", name=" + name + ", mac_address=" + macAddress + ", admin_state_up=" + adminStateUp
				+ ", device_id=" + deviceId + ", device_owner=" + deviceOwner + ", fixed_ips=" + list + ", network_id="
				+ networkId + ", status=" + status + ", tenant_id=" + tenantId + ", securityGroups=" + securityGroups
				+ ", binding=" + binding + "]";
	}
}