package com.infinities.neutron.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.infinities.api.openstack.commons.context.OpenstackRequestContext;
import com.infinities.neutron.ports.controller.PortsController;
import com.infinities.neutron.ports.model.PortForCreateTemplate;
import com.infinities.neutron.ports.model.PortTemplate;
import com.infinities.neutron.ports.model.Ports;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PortsResource {

	private PortsController controller;


	@Inject
	public PortsResource(PortsController controller) {
		this.controller = controller;
	}

	@GET
	public Ports index(@Context ContainerRequestContext requestContext) throws Exception {
		OpenstackRequestContext novaContext = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		String projectId = novaContext.getProjectId();
		return controller.index(requestContext, projectId);
	}

	@GET
	@Path("{portId}")
	public PortTemplate show(@PathParam("portId") String portId, @Context ContainerRequestContext requestContext)
			throws Exception {
		OpenstackRequestContext novaContext = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		String projectId = novaContext.getProjectId();
		return controller.show(requestContext, projectId, portId);
	}

	@POST
	public PortTemplate create(@Context ContainerRequestContext requestContext, PortForCreateTemplate portForCreateTemplate)
			throws Exception {
		OpenstackRequestContext novaContext = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		String projectId = novaContext.getProjectId();
		return controller.create(requestContext, projectId, portForCreateTemplate);
	}

	@PUT
	@Path("{portId}")
	public PortTemplate update(@PathParam("portId") String portId, @Context ContainerRequestContext requestContext,
			PortForCreateTemplate portForCreateTemplate) throws Exception {
		OpenstackRequestContext novaContext = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		String projectId = novaContext.getProjectId();
		return controller.update(requestContext, projectId, portId, portForCreateTemplate);
	}

	@DELETE
	@Path("{portId}")
	public Response delete(@PathParam("portId") String portId, @Context ContainerRequestContext requestContext)
			throws Exception {
		OpenstackRequestContext novaContext = (OpenstackRequestContext) requestContext.getProperty("nova.context");
		String projectId = novaContext.getProjectId();
		controller.delete(projectId, portId, requestContext);
		return Response.status(Status.NO_CONTENT).build();
	}
}
