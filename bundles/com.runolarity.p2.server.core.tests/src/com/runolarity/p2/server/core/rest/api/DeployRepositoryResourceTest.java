package com.runolarity.p2.server.core.rest.api;

import javax.ws.rs.WebApplicationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DeployRepositoryResourceTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void getListOfAllVersionsAsHtml() throws Exception {
		exceptionRule.expect(WebApplicationException.class);

		new DeployRepositoryResource().getListOfAllVersionsAsHtml();
	}

}
