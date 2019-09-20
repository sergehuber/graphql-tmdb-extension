package org.jahia.modules.graphqltmdbextension;

import org.jahia.modules.graphql.provider.dxm.DXGraphQLExtensionsProvider;
import org.jahia.modules.graphqltmdbextension.api.MovieExtension;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.Collection;

@Component(immediate = true, service = DXGraphQLExtensionsProvider.class)
public class GraphQLTMDBExtensionProvider implements DXGraphQLExtensionsProvider {
    @Override
    public Collection<Class<?>> getExtensions() {
        return Arrays.<Class<?>>asList(MovieExtension.class);
    }
}
