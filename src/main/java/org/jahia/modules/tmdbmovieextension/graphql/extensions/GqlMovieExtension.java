package org.jahia.modules.tmdbmovieextension.graphql.extensions;

import com.uwetrottmann.tmdb2.entities.CastMember;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLTypeExtension;
import org.jahia.modules.tmdbmovieextension.graphql.api.GqlActor;
import org.jahia.modules.tmdbprovider.graphql.api.GqlMovie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@GraphQLTypeExtension(GqlMovie.class)
public class GqlMovieExtension {
    private GqlMovie gqlMovie;

    public GqlMovieExtension(GqlMovie gqlMovie) {
        this.gqlMovie = gqlMovie;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the list of actors of a movie")
    public Collection<GqlActor> getActors() {
        List<GqlActor> gqlActors = new ArrayList<>();
        if (gqlMovie.getTmdbMovie().credits != null
                && gqlMovie.getTmdbMovie().credits.cast != null
                && !gqlMovie.getTmdbMovie().credits.cast.isEmpty()) {
            for (CastMember castMember : gqlMovie.getTmdbMovie().credits.cast) {
                gqlActors.add(new GqlActor(castMember));
            }
        }
        return gqlActors;
    }
}
