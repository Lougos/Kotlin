package goulet.romain.iimdemo

import android.content.Intent
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import goulet.romain.iimdemo.model.Comment
import goulet.romain.iimdemo.model.Post
import goulet.romain.iimdemo.model.User
import kotlinx.android.synthetic.main.cell.view.*



class MyListAdapter : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {



    var posts: List<Post> = emptyList()
    var users: List<User> = emptyList()
    var comments: List<Comment> = emptyList()
   /* var comments1: List<Comment> = emptyList()*/

    override fun getItemCount(): Int = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val post = posts[position]
        val user = users[post.userId-1]
        val comment = comments.first{it.postId == post.id}
       /* val comment2 = comments.first{it.id == comment1.id+1}*/


        holder.itemView.cellTitle.text = post.title
        holder.itemView.cellUser.text = users.first { it.id == post.userId} .username


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PostActivity::class.java)

            intent.putExtra("post", post)
            intent.putExtra("user", user)
            intent.putExtra("comment", comment)

            holder.itemView.context.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
