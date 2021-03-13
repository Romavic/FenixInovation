package ao.fenixinovation.romavicdosanjos.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photos")
data class ModelsPhotosItem(
    @SerializedName("albumId")
    var albumId: Int = 0,
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String = ""
)