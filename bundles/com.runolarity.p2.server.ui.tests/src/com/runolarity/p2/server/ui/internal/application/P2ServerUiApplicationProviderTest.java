package com.runolarity.p2.server.ui.internal.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.eclipse.gyrex.context.IRuntimeContext;
import org.eclipse.gyrex.rap.application.RapApplicationConfiguration;

import org.junit.Test;

public class P2ServerUiApplicationProviderTest {

	@Test
	public void getApplicationConfiguration() throws Exception {
		final IRuntimeContext context = mock(IRuntimeContext.class);
		final RapApplicationConfiguration configuration = new P2ServerUiApplicationProvider().getApplicationConfiguration("myid", context);

		assertNotNull(configuration);
	}

	@Test
	public void uses_correct_id() throws Exception {
		assertEquals("The id is public API and must not be changed anymore!", "com.runolarity.p2.server.ui.rap", new P2ServerUiApplicationProvider().getId());
	}

}
