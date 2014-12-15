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
package com.runolarity.p2.server.ui.internal.application;

import org.eclipse.gyrex.context.IRuntimeContext;
import org.eclipse.gyrex.rap.application.RapApplicationConfiguration;
import org.eclipse.gyrex.rap.application.http.RapApplicationProvider;

/**
 * p2 Server UI provider.
 */
public class P2ServerUiApplicationProvider extends RapApplicationProvider {

	public static final String PROVIDER_ID = "com.runolarity.p2.server.ui.rap";

	public P2ServerUiApplicationProvider() {
		super(PROVIDER_ID);
	}

	@Override
	protected RapApplicationConfiguration getApplicationConfiguration(final String applicationId, final IRuntimeContext context) {
		return new P2ServerUiApplicationConfiguration(context);
	}

}
