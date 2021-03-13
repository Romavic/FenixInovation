package ao.fenixinovation.romavicdosanjos.app.database

import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun insertPhotos(listPhotos: MutableList<ModelsPhotosItem>) {
        return appDatabase.photoDao().insertPhotos(listPhotos)
    }

    override suspend fun loadPhotos(): MutableList<ModelsPhotosItem> {
        return appDatabase.photoDao().loadPhotos()
    }
}