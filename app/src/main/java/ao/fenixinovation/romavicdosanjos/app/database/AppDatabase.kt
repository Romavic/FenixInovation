package ao.fenixinovation.romavicdosanjos.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem

@Database(entities = [ModelsPhotosItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao
}