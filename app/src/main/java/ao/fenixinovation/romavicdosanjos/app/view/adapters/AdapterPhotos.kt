package ao.fenixinovation.romavicdosanjos.app.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import ao.fenixinovation.romavicdosanjos.R
import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem
import com.squareup.picasso.Picasso

class AdapterPhotos() : RecyclerView.Adapter<AdapterPhotos.AdapterHolder>() {

    private var listPhotos: MutableList<ModelsPhotosItem> = mutableListOf()

    inner class AdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemImage: AppCompatImageView = itemView.findViewById(R.id.itemImage)
        private val itemTitle: AppCompatTextView = itemView.findViewById(R.id.itemTitle)

        fun bind(modelsPhotosItem: ModelsPhotosItem) {
            Picasso.get().load(modelsPhotosItem.thumbnailUrl).into(itemImage)
            itemTitle.text = modelsPhotosItem.title.capitalize()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        return AdapterHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photos, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.bind(listPhotos[position])
    }

    override fun getItemCount(): Int {
        return listPhotos.size
    }

    fun addAll(item: MutableList<ModelsPhotosItem>) {
        listPhotos = item
        notifyDataSetChanged()
    }
}