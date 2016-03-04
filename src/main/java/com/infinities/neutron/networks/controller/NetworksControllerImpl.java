package com.infinities.neutron.networks.controller;

import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;

import com.infinities.api.openstack.commons.context.OpenstackRequestContext;
import com.infinities.neutron.networks.api.NetworksApi;
import com.infinities.neutron.networks.model.Network;
import com.infinities.neutron.networks.model.NetworkForCreate;
import com.infinities.neutron.networks.model.NetworkForUpdate;
import com.infinities.neutron.networks.model.NetworkTemplate;
import com.infinities.neutron.networks.model.Networks;
import com.infinities.neutron.networks.views.ViewBuilder;

public class NetworksControllerImpl implements NetworksController {

	private final NetworksApi networksApi;
	private final ViewBuilder builder = new ViewBuilder();


	public NetworksControllerImpl(NetworksApi networksApi) {
		this.networksApi = networksApi;
	}

	@Override
	public Networks index(ContainerRequestContext requestContext, String projectId) throws Exception {
		OpenstackRequestContext context = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		List<Network> networks = networksApi.getNetworks(context, projectId);
		return builder.index(requestContext, networks);
	}

	@Override
	public NetworkTemplate show(ContainerRequestContext requestContext, String projectId, String networkId) throws Exception {
		OpenstackRequestContext context = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		Network network = networksApi.getNetwork(context, projectId, networkId);
		return builder.show(requestContext, network);
	}

	@Override
	public NetworkTemplate create(ContainerRequestContext requestContext, String projectId, NetworkForCreate networkForCreate)
			throws Exception {
		OpenstackRequestContext context = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		Network network = networksApi.createNetwork(context, projectId, networkForCreate);
		return builder.show(requestContext, network);
	}

	@Override
	public NetworkTemplate update(ContainerRequestContext requestContext, String projectId, String networkId,
			NetworkForUpdate networkForUpdate) throws Exception {
		OpenstackRequestContext context = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		Network network = networksApi.updateNetwork(context, projectId, networkId, networkForUpdate);
		return builder.show(requestContext, network);
	}

	@Override
	public void delete(String projectId, String networkId, ContainerRequestContext requestContext) throws Exception {
		OpenstackRequestContext context = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		networksApi.deleteNetwork(context, projectId, networkId);
	}

}
