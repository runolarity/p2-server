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
import org.eclipse.gyrex.rap.application.InjectingPageProvider;
import org.eclipse.gyrex.rap.application.RapApplicationConfiguration;
import org.eclipse.gyrex.rap.application.RapApplicationEntryPoint;

import com.runolarity.p2.server.ui.internal.application.pages.Dashboard;

/**
 *
 */
public class P2ServerUiApplicationConfiguration extends RapApplicationConfiguration {

	private final IRuntimeContext context;

	public P2ServerUiApplicationConfiguration(final IRuntimeContext context) {
		this.context = context;
	}

	@Override
	protected RapApplicationEntryPoint createEntryPoint() {
		final RapApplicationEntryPoint entryPoint = new RapApplicationEntryPoint();
		entryPoint.setPageProvider(createPageProvider());
		return entryPoint;
	}

	private InjectingPageProvider createPageProvider() {
		final InjectingPageProvider pageProvider = new InjectingPageProvider(context);

		pageProvider.newCategory("repositories").name("Repositories").sortKey("1000").register();

		pageProvider.newPage("dashboard").name("Dashboard").sortKey("0000").categoryId("repositories").pageClass(Dashboard.class).register();

		return pageProvider;
	}

}
