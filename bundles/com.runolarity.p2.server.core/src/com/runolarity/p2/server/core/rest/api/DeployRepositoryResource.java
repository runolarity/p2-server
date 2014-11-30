/**
 * Copyright (c) 2014 <company> and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     <author> - initial API and implementation
 */
package com.runolarity.p2.server.core.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Additional API for deep-linking into a deploy repository.
 */
public class DeployRepositoryResource extends P2RepositoryResource {

	@GET
	@Path("versions")
	@Produces(MediaType.TEXT_HTML)
	public String getListOfAllVersionsAsHtml() {
		throw new WebApplicationException(404);
	}

	@GET
	@Path("versions/{version}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
	public P2RepositoryResource getSpecificVersion(@PathParam("version")
	final String version) {
		throw new WebApplicationException(404);
	}
}
