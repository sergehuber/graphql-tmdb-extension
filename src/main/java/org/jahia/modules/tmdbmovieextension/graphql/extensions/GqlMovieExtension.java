package org.jahia.modules.tmdbmovieextension.graphql.extensions;

import com.uwetrottmann.tmdb2.entities.CastMember;
import com.uwetrottmann.tmdb2.entities.Movie;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLTypeExtension;
import org.jahia.modules.tmdbmovieextension.graphql.api.GqlActor;
import org.jahia.modules.tmdbprovider.api.TMDBService;
import org.jahia.modules.tmdbprovider.graphql.api.GqlMovie;
import org.jahia.osgi.BundleUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@GraphQLTypeExtension(GqlMovie.class)
public class GqlMovieExtension {
    private GqlMovie gqlMovie;
    private TMDBService tmdbService = null;

    public GqlMovieExtension(GqlMovie gqlMovie) {
        this.gqlMovie = gqlMovie;
        this.tmdbService = BundleUtils.getOsgiService(TMDBService.class, null);
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the list of actors of a movie")
    public Collection<GqlActor> getActors() throws IOException {
        List<GqlActor> gqlActors = new ArrayList<>();
        Movie tmdbMovie = tmdbService.getMovie(gqlMovie.getTmdbMovie().id);
        if (tmdbMovie.credits != null
                && tmdbMovie.credits.cast != null
                && !tmdbMovie.credits.cast.isEmpty()) {
            for (CastMember castMember : tmdbMovie.credits.cast) {
                gqlActors.add(new GqlActor(castMember));
            }
        }
        return gqlActors;
    }
}
