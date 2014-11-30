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
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Base API for accessing a repository using an Eclipse p2 client.
 */
public class P2RepositoryResource {

	@GET
	@Path("artifacts.xml.gz")
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
	public String getArtifactsXml() {
		throw new WebApplicationException(404);
	}

	@GET
	@Path("content.xml.gz")
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
	public String getContentXml() {
		throw new WebApplicationException(404);
	}

	@GET
	@Path("p2.index")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public String getP2Index() {
		throw new WebApplicationException(404);
	}

	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public String getRepositoryInfoAsHtml() {
		throw new WebApplicationException(404);
	}
}
