package goulet.romain.iimdemo




import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import goulet.romain.iimdemo.model.Comment
import goulet.romain.iimdemo.model.Post
import goulet.romain.iimdemo.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyListAdapter()
      recyclerView.adapter = adapter


        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create<API>()

        api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                Log.e("DL", "Download failed : ${t.message}")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                val posts = response.body()!!
                api.getUsers().enqueue(object : Callback<List<User>>{
                    override fun onFailure(call: Call<List<User>>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                        val users = response.body()!!


                        api.getComments().enqueue(object : Callback<List<Comment>>{
                            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {

                            }

                            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                                val comments = response.body()!!

                                adapter.comments= comments
                                adapter.posts = posts
                                adapter.users = users
                                adapter.notifyDataSetChanged()
                            }
                        })


                    }
                })



            }
        })



        }


}

