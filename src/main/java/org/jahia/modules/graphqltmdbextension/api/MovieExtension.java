package org.jahia.modules.graphqltmdbextension.api;

import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLTypeExtension;
import org.jahia.modules.graphqltmdbprovider.api.Movie;
import org.jahia.modules.graphqltmdbprovider.api.TMDBService;
import org.jahia.osgi.BundleUtils;

import java.io.IOException;

@GraphQLTypeExtension(Movie.class)
public class MovieExtension {
    private Movie movie;
    private String homepage;

    private TMDBService tmdbService = null;

    public MovieExtension(Movie movie) {
        this.movie = movie;
        this.tmdbService = BundleUtils.getOsgiService(TMDBService.class, null);
    }

    @GraphQLField
    @GraphQLDescription("Retrieve the homepage of the movie")
    public String getHomepage() throws IOException {
        com.uwetrottmann.tmdb2.entities.Movie tmdbMovie = tmdbService.getMovie(movie.getId());
        return tmdbMovie.homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
