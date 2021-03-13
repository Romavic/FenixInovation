package ao.fenixinovation.romavicdosanjos.app.database

import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem

interface DatabaseHelper {

    suspend fun insertPhotos(listPhotos: MutableList<ModelsPhotosItem>)

    suspend fun loadPhotos(): MutableList<ModelsPhotosItem>

}