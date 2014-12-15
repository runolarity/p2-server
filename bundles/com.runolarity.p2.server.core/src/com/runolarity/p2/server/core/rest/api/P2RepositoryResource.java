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

import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * Base API for accessing a repository using an Eclipse p2 client.
 */
public class P2RepositoryResource {

	private static final String P2_INDEX = "version = 1\nmetadata.repository.factory.order = content.xml,\\!\nartifact.repository.factory.order = artifacts.xml,\\!\n";

	private CacheControl cacheWithMaxAgeOf(final int maxAge, final TimeUnit unit) {
		final CacheControl c = new CacheControl();
		c.setMaxAge((int) unit.toSeconds(maxAge));
		return c;
	}

	@GET
	@Path("artifacts.jar")
	public Response getArtifactsJar(@Context final Request request) {
		throw new WebApplicationException(404);
	}

	@GET
	@Path("content.jar")
	public Response getContentJar(@Context final Request request) {
		//		final File contentJar = null;
		//
		//		ResponseBuilder builder = request.evaluatePreconditions(new Date(contentJar.lastModified()));
		//		if (builder != null)
		//
		//			if (builder == null) {
		//				// cached resource changed, build new jar
		//				builder = Response.ok(new StreamingOutput() {
		//
		//					@Override
		//					public void write(final OutputStream output) throws IOException, WebApplicationException {
		//						try (final FileChannel source = FileChannel.open(contentJar.toPath(), StandardOpenOption.READ)) {
		//							try (WritableByteChannel target = Channels.newChannel(output)) {
		//								source.transferTo(0, source.size(), target);
		//							}
		//						}
		//					}
		//				});
		//				builder.lastModified(new Date(contentJar.lastModified()));
		//			}
		//
		//		builder.cacheControl(cacheWithMaxAgeOf(24, TimeUnit.HOURS));
		//		return builder.build();

		throw new WebApplicationException(404);
	}

	@GET
	@Path("p2.index")
	public Response getP2Index() {
		return Response.ok(P2_INDEX, MediaType.TEXT_PLAIN).cacheControl(cacheWithMaxAgeOf(90, TimeUnit.DAYS)).build();
	}

	@GET
	@Path("")
	@Produces(MediaType.TEXT_HTML)
	public String getRepositoryInfoAsHtml() {
		throw new WebApplicationException(404);
	}

	//	private StreamingOutput streamContentJar() {
	//		return new StreamingOutput() {
	//
	//			@Override
	//			public void write(final OutputStream output) throws IOException, WebApplicationException {
	//				final BufferedOutputStream out = new BufferedOutputStream(output);
	//
	//				java.nio.file.Files.newByteChannel(null).tcopyTo(out);
	//			}
	//		};
	//	}
}
