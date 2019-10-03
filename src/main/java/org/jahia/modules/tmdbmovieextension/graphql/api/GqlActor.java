package org.jahia.modules.tmdbmovieextension.graphql.api;

import com.uwetrottmann.tmdb2.entities.CastMember;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

@GraphQLName("Actor")
public class GqlActor {
    private CastMember castMember;

    public GqlActor(CastMember castMember) {
        this.castMember = castMember;
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the name of an actor")
    public String getName() {
        return castMember.name;
    }
}
