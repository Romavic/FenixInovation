@file:Suppress("UNCHECKED_CAST")

package ao.fenixinovation.romavicdosanjos.app.data.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ao.fenixinovation.romavicdosanjos.app.data.repository.Repository
import ao.fenixinovation.romavicdosanjos.app.data.viewmodels.ViewModelPhotos
import ao.fenixinovation.romavicdosanjos.app.database.DatabaseHelper

class ViewModelFactory(
    private val repository: Repository,
    private val dbHelper: DatabaseHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(ViewModelPhotos::class.java) -> {
                return ViewModelPhotos(repository, dbHelper) as T
            }
            else -> {
                throw  IllegalArgumentException("Class not found")
            }
        }
    }
}