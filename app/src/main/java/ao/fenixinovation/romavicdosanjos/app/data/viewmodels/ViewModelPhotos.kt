package ao.fenixinovation.romavicdosanjos.app.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ao.fenixinovation.romavicdosanjos.app.data.Resources
import ao.fenixinovation.romavicdosanjos.app.data.repository.Repository
import ao.fenixinovation.romavicdosanjos.app.database.DatabaseHelper
import kotlinx.coroutines.Dispatchers

class ViewModelPhotos(
    var repository: Repository,
    val dbHelper: DatabaseHelper
) : ViewModel() {

    fun getPhotos() = liveData(Dispatchers.IO) {
        emit(Resources.loading(data = null))
        try {
            emit(Resources.success(data = repository.gePhotosRepository()))
            dbHelper.insertPhotos(repository.gePhotosRepository())
        } catch (exception: Exception) {
            emit(Resources.error(data = null, message = exception.message ?: "Error Ocurred"))
            emit(Resources.success(data = dbHelper.loadPhotos()))
        }
    }
}