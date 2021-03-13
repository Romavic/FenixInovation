package ao.fenixinovation.romavicdosanjos.app.database

import androidx.room.*
import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(listPhotos: MutableList<ModelsPhotosItem>)

    @Update()
    suspend fun updatePhotos(listPhotos: MutableList<ModelsPhotosItem>)

    @Query("SELECT * From photos")
    suspend fun loadPhotos(): MutableList<ModelsPhotosItem>

}