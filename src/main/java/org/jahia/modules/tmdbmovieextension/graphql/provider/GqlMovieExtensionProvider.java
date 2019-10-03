package org.jahia.modules.tmdbmovieextension.graphql.provider;

import org.jahia.modules.graphql.provider.dxm.DXGraphQLExtensionsProvider;
import org.jahia.modules.tmdbmovieextension.graphql.extensions.GqlMovieExtension;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.Collection;

@Component(immediate = true, service = DXGraphQLExtensionsProvider.class)
public class GqlMovieExtensionProvider implements DXGraphQLExtensionsProvider {
    @Override
    public Collection<Class<?>> getExtensions() {
        return Arrays.<Class<?>>asList(GqlMovieExtension.class);
    }
}
