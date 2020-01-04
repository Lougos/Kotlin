package goulet.romain.iimdemo

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import goulet.romain.iimdemo.fragment.AuthorFragment
import goulet.romain.iimdemo.fragment.CommentFragment
import goulet.romain.iimdemo.fragment.TextFragment
import goulet.romain.iimdemo.model.Comment
import goulet.romain.iimdemo.model.Post
import goulet.romain.iimdemo.model.User

class PostActivity : AppCompatActivity() {

    private lateinit var post: Post
    private lateinit var user: User
    private lateinit var comment: Comment



    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_text -> {

                val textFragment = TextFragment()
                val args = Bundle()
                title = "Text"
                args.putString("text", post.body)
                textFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, textFragment)
                    .commit()
            }

            R.id.navigation_comment -> {
                val commentFragment = CommentFragment()
                val args = Bundle()
                args.putString("Comment_name", comment.name)
                args.putString("Comment_email", comment.email)
                args.putString("Comment_body", comment.body)



                title = "Comments"

                commentFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, commentFragment)
                    .commit()
            }

            R.id.navigation_author -> {

                val authorFragment = AuthorFragment()
                val args = Bundle()
                args.putString("Author_username", user.username)
                args.putString("Author_name", user.name)
                args.putString("Author_email", user.email)
                args.putString("Author_phone", user.phone)
                args.putString("Author_website", user.website)
                args.putString("Author_suite", user.address.suite)
                args.putString("Author_city", user.address.city)
                args.putString("Author_street", user.address.street)
                args.putString("Author_zipcode", user.address.zipcode)
                args.putString("Author_company", user.company.name)
                args.putString("Author_catchphrase", user.company.catchPhrase)
                args.putString("Author_lat", user.address.geo.lat)
                args.putString("Author_lng", user.address.geo.lng)
                args.putString("Author_bs", user.company.bs)

                title = "Author"


                authorFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, authorFragment)
                    .commit()
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        post = intent.getSerializableExtra("post") as Post
        user = intent.getSerializableExtra("user") as User
        comment = intent.getSerializableExtra("comment") as Comment


        title = "Text"

        setContentView(R.layout.activity_post)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val textFragment = TextFragment()
        val args = Bundle()
        args.putString("text", post.body)
        textFragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, textFragment)
            .commit()
    }
}
