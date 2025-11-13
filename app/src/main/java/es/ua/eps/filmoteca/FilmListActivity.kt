package es.ua.eps.filmoteca

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class FilmListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

        // ListView del layout
        val listView: ListView = findViewById(R.id.listView)

        // Adapter básico: usa Film.toString() para mostrar el título
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            FilmDataSource.films
        )
        listView.adapter = adapter

        // Al tocar un item, abrimos el detalle y pasamos el índice
        listView.setOnItemClickListener { _, _, position, _ ->
            val i = Intent(this, FilmDataActivity::class.java)
            i.putExtra("film_index", position)
            startActivity(i)
        }
    }
}
