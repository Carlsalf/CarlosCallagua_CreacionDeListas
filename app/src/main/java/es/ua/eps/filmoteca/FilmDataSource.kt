// app/src/main/java/es/ua/eps/filmoteca/FilmDataSource.kt
package es.ua.eps.filmoteca

object FilmDataSource {

    /** Intenta usar el drawable indicado y cae al launcher si no existe. */
    private fun posterOrDefault(tryRes: Int): Int =
        runCatching { tryRes }.getOrElse { R.drawable.ic_launcher_foreground }

    val films: MutableList<Film> = mutableListOf(
        Film(
            imageResId = posterOrDefault(R.drawable.poster_back_to_the_future),
            title = "Regreso al futuro",
            director = "Robert Zemeckis",
            year = 1985,
            genre = Film.GENRE_SCIFI,
            format = Film.FORMAT_ONLINE,
            imdbUrl = "https://www.imdb.com/title/tt0088763/"
        ),
        Film(
            imageResId = posterOrDefault(R.drawable.poster_blade_runner),
            title = "Blade Runner",
            director = "Ridley Scott",
            year = 1982,
            genre = Film.GENRE_SCIFI,
            format = Film.FORMAT_BLURAY,
            imdbUrl = "https://www.imdb.com/title/tt0083658/"
        ),
        Film(
            imageResId = posterOrDefault(R.drawable.poster_matrix),
            title = "The Matrix",
            director = "Lana & Lilly Wachowski",
            year = 1999,
            genre = Film.GENRE_SCIFI,
            format = Film.FORMAT_DVD,
            imdbUrl = "https://www.imdb.com/title/tt0133093/"
        ),
        Film(
            imageResId = posterOrDefault(R.drawable.poster_godfather),
            title = "El Padrino",
            director = "Francis Ford Coppola",
            year = 1972,
            genre = Film.GENRE_DRAMA,
            format = Film.FORMAT_BLURAY,
            imdbUrl = "https://www.imdb.com/title/tt0068646/"
        ),
        Film(
            imageResId = posterOrDefault(R.drawable.poster_toy_story),
            title = "Toy Story",
            director = "John Lasseter",
            year = 1995,
            genre = Film.GENRE_COMEDY,
            format = Film.FORMAT_ONLINE,
            imdbUrl = "https://www.imdb.com/title/tt0114709/"
        )
    )
}
