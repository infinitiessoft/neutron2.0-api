package com.infinities.neutron.ports.api;

import java.util.List;

import com.infinities.api.openstack.commons.context.OpenstackRequestContext;
import com.infinities.neutron.ports.model.Port;
import com.infinities.neutron.ports.model.PortForCreateTemplate;

public interface PortsApi {

	/**
	 * @param context
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	List<Port> getPorts(OpenstackRequestContext context, String projectId) throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param portId
	 * @return
	 * @throws Exception
	 */
	Port getPort(OpenstackRequestContext context, String projectId, String portId) throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param portForCreateTemplate
	 * @return
	 * @throws Exception
	 */
	Port createPort(OpenstackRequestContext context, String projectId, PortForCreateTemplate portForCreateTemplate)
			throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param portId
	 * @param portForCreateTemplate
	 * @return
	 * @throws Exception
	 */
	Port updatePort(OpenstackRequestContext context, String projectId, String portId,
			PortForCreateTemplate portForCreateTemplate) throws Exception;

	/**
	 * @param context
	 * @param projectId
	 * @param portId
	 * @throws Exception
	 */
	void deletePort(OpenstackRequestContext context, String projectId, String portId) throws Exception;
}
