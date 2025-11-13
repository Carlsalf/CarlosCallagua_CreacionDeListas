package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.ua.eps.filmoteca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Insets opcionales si tu root tiene id @id/main en activity_main.xml
        runCatching {
            ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
                val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                insets
            }
        }

        fun launchOrToast(intent: Intent) {
            runCatching { startActivity(intent) }
                .onFailure {
                    Toast.makeText(
                        this,
                        "No pude abrir la pantalla. Revisa el Manifest / clase.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

        // === Botones presentes en activity_main.xml ===
        binding.btnAbout.setOnClickListener {
            launchOrToast(Intent(this, AboutActivity::class.java))
        }

        binding.btnListaXml.setOnClickListener {
            launchOrToast(Intent(this, FilmListActivity::class.java))
        }

        binding.btnListaCompose.setOnClickListener {
            try {
                startActivity(Intent(this, FilmListComposeActivity::class.java))
            } catch (t: Throwable) {
                android.util.Log.e("NAV", "Fallo al abrir FilmListComposeActivity", t)
                Toast.makeText(
                    this,
                    "Error al abrir Lista (Compose): ${t::class.simpleName}: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // ===== XML =====
        binding.btnDetailXml.setOnClickListener {
            val i = Intent(this, FilmDataActivity::class.java).apply {
                putExtra("film_index", 0) // índice seguro para evitar crash si lo lees en destino
            }
            launchOrToast(i)
        }

        binding.btnEditXml.setOnClickListener {
            val i = Intent(this, FilmEditActivity::class.java).apply {
                putExtra("film_index", 0)
            }
            launchOrToast(i)
        }

        // ===== Compose =====
        binding.btnDetailCompose.setOnClickListener {
            launchOrToast(Intent(this, FilmDetailComposeActivity::class.java))
        }
        binding.btnEditCompose.setOnClickListener {
            launchOrToast(Intent(this, FilmEditComposeActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_about -> { startActivity(Intent(this, AboutActivity::class.java)); true }
        R.id.action_web -> {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Carlsalf"))); true
        }
        R.id.action_share -> {
            val i = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Prueba la app Filmoteca")
            }
            startActivity(Intent.createChooser(i, "Compartir vía")); true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
