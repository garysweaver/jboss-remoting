/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.remoting3.remote;

import java.io.IOException;
import org.jboss.remoting3.spi.ConnectionProvider;
import org.jboss.remoting3.spi.ConnectionProviderContext;
import org.jboss.remoting3.spi.ConnectionProviderFactory;
import org.xnio.OptionMap;
import org.xnio.Xnio;

/**
 * A {@link ConnectionProviderFactory} for the {@code remote} protocol.
 *
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public final class RemoteConnectionProviderFactory implements ConnectionProviderFactory {

    private final Xnio xnio;

    /**
     * Construct a new instance.
     *
     * @param xnio the XNIO provider to use
     */
    public RemoteConnectionProviderFactory(final Xnio xnio) {
        this.xnio = xnio;
    }

    /** {@inheritDoc} */
    public ConnectionProvider createInstance(final ConnectionProviderContext context, final OptionMap optionMap) throws IOException {
        return new RemoteConnectionProvider(xnio, optionMap, context);
    }
}