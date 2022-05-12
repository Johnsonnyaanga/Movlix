import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.johnson.commons.utils.Constants
import com.johnson.domain.models.Actors.Cast
import com.johnson.movlix.R
import com.johnson.movlix.databinding.ActorsViewBinding


class ActorsListAdapter(val list:List<Cast>): RecyclerView.Adapter<ActorsListAdapter.ActorsListViewHolder>() {


    class ActorsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val actorProfileImage: ImageView = itemView.findViewById(R.id.actor_image)
        val actorName: TextView = itemView.findViewById(R.id.actor_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsListViewHolder {
        return ActorsListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.actors_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorsListViewHolder, position: Int) {
        val ctx = holder.itemView.context
        val currentItem = list[position]
        holder.apply {
            actorName.text = currentItem.original_name
            Glide.with(ctx)
                .load(Constants.IMG_URL_INIT_PATH + currentItem.profile_path)
                .into(actorProfileImage)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }}




