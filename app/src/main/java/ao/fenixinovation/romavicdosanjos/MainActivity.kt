package ao.fenixinovation.romavicdosanjos

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ao.fenixinovation.romavicdosanjos.app.data.Status
import ao.fenixinovation.romavicdosanjos.app.data.api.ApiClient
import ao.fenixinovation.romavicdosanjos.app.data.repository.Repository
import ao.fenixinovation.romavicdosanjos.app.data.viewmodels.ViewModelPhotos
import ao.fenixinovation.romavicdosanjos.app.data.viewmodels.factory.ViewModelFactory
import ao.fenixinovation.romavicdosanjos.app.database.DatabaseBuilder
import ao.fenixinovation.romavicdosanjos.app.database.DatabaseHelper
import ao.fenixinovation.romavicdosanjos.app.database.DatabaseHelperImpl
import ao.fenixinovation.romavicdosanjos.app.utility.hide
import ao.fenixinovation.romavicdosanjos.app.utility.show
import ao.fenixinovation.romavicdosanjos.app.view.adapters.AdapterPhotos

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelPhotos
    private lateinit var adapterPhotos: AdapterPhotos
    private lateinit var recyclerPhotos: RecyclerView
    private lateinit var progressPhotos: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        viewModel = ViewModelProvider(
            this, ViewModelFactory(
                Repository(ApiClient.RetrofitBuilder.endpoints),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(this))
            )
        )[ViewModelPhotos::class.java]

        recyclerPhotos = findViewById(R.id.recyclerPhotos)
        progressPhotos = findViewById(R.id.progressPhotos)

        recyclerPhotos.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )

        requestData()
    }

    private fun requestData() {
        adapterPhotos = AdapterPhotos()

        viewModel.getPhotos().observe(this, { callback ->

            when (callback.status) {
                Status.Loading -> {
                    progressPhotos.show()
                    recyclerPhotos.hide()
                }
                Status.Success -> {
                    progressPhotos.hide()
                    recyclerPhotos.show()

                    callback.let { response ->
                        adapterPhotos.addAll(response.data!!)
                        recyclerPhotos.adapter = adapterPhotos
                    }
                }
                Status.Error -> {
                    progressPhotos.hide()
                    recyclerPhotos.hide()
/*
                    Toast.makeText(this, "Error to load the data.", Toast.LENGTH_SHORT).show()
*/
                }
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}