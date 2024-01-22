package uz.jt17.tutorialforsardor.feature

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.jt17.tutorialforsardor.databinding.ItemLyBinding
import uz.jt17.tutorialforsardor.domain.model.CurrentDataModel

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var setList = emptyList<CurrentDataModel>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(private val binding: ItemLyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: CurrentDataModel) {
            binding.apply {
                dataId.text = data.id.toString()
                currentMillis.text = data.currentDate
            }

            binding.deleteButton.setOnClickListener {
                onItemClickListener?.invoke(data.id)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemData = setList[position]
        holder.bind(itemData)
    }

    override fun getItemCount(): Int = setList.size

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: ((Int) -> Unit)? = null) {
        onItemClickListener = listener
    }

}