import android.view.LayoutInflater
<<<<<<< HEAD
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
=======
import android.view.ViewGroup
>>>>>>> f7111c087b7bb7e9fca9cf9a3219ae2f9442ff0f
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.johnson.commons.utils.Constants
<<<<<<< HEAD
import com.johnson.domain.models.Actors.Cast
import com.johnson.domain.models.Actors.Crew
import com.johnson.movlix.R
import com.johnson.movlix.databinding.ActorsViewBinding


class ActorsListAdapter(val list:List<Cast>):RecyclerView.Adapter<ActorsListAdapter.ActorsListViewHolder>() {


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
    }

=======
import com.johnson.domain.models.Actors.Crew
import com.johnson.movlix.databinding.ActorsViewBinding


class ActorsListAdapter: RecyclerView.Adapter<ActorsListAdapter.ActorsListViewHolder>() {
    class ActorsListViewHolder(val binding: ActorsViewBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Crew>() {
        override fun areItemsTheSame(oldItem: Crew, newItem: Crew): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Crew, newItem: Crew): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ActorsViewBinding = ActorsViewBinding.inflate(layoutInflater, parent,false)
        return ActorsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorsListViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            Glide.with(this.root)
                .load(Constants.IMG_URL_INIT_PATH + item.profile_path)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(actorImage)
            actorName.text = item.name

        }


    }

    override fun getItemCount() = differ.currentList.size
>>>>>>> f7111c087b7bb7e9fca9cf9a3219ae2f9442ff0f

}