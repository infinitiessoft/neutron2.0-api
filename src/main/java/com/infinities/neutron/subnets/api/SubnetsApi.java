package com.infinities.neutron.subnets.api;

import java.util.List;

import com.infinities.api.openstack.commons.context.OpenstackRequestContext;
import com.infinities.neutron.subnets.model.Subnet;
import com.infinities.neutron.subnets.model.SubnetForCreateTemplate;

public interface SubnetsApi {

	/**
	 * @param context
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	List<Subnet> getSubnets(OpenstackRequestContext context, String projectId) throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param subnetId
	 * @return
	 * @throws Exception
	 */
	Subnet getSubnet(OpenstackRequestContext context, String projectId, String subnetId) throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param subnetForCreateTemplate
	 * @return
	 * @throws Exception
	 */
	Subnet createSubnet(OpenstackRequestContext context, String projectId, SubnetForCreateTemplate subnetForCreateTemplate)
			throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param subnetId
	 * @param subnetForCreateTemplate
	 * @return
	 * @throws Exception
	 */
	Subnet updateSubnet(OpenstackRequestContext context, String projectId, String subnetId,
			SubnetForCreateTemplate subnetForCreateTemplate) throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param subnetId
	 * @throws Exception
	 */
	void deleteSubnet(OpenstackRequestContext context, String projectId, String subnetId) throws Exception;
}
