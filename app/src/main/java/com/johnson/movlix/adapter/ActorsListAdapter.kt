import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.johnson.commons.utils.Constants
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

}