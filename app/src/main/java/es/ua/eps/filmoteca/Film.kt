// app/src/main/java/es/ua/eps/filmoteca/Film.kt
package es.ua.eps.filmoteca

import java.io.Serializable

// Usamos data class para tener toString, equals, etc.
data class Film(
    // === Campos editables: tienen que ser var, no val ===
    var title: String? = null,
    var director: String? = null,
    var year: Int = 0,
    var genre: Int = 0,
    var format: Int = 0,
    var imdbUrl: String? = null,
    var imageResId: Int = 0,
    var comments: String? = null
) : Serializable {

    companion object {
        // Ajusta estos índices al orden de tu array R.array.genres
        const val GENRE_SCIFI  = 0
        const val GENRE_DRAMA  = 1
        const val GENRE_COMEDY = 2
        const val GENRE_ACTION = 3
        // añade más si los tienes en el array

        // Ajusta estos índices al orden de tu array R.array.formats
        const val FORMAT_DVD    = 0
        const val FORMAT_BLURAY = 1
        const val FORMAT_ONLINE = 2
        // añade más si hace falta
    }
}
