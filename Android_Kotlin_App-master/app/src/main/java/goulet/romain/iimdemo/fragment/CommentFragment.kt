package goulet.romain.iimdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import goulet.romain.iimdemo.R
import kotlinx.android.synthetic.main.comment_fragment_layout.*

class CommentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.comment_fragment_layout, container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val commentEmail = arguments!!.getString("Comment_email")
        val commentBody = arguments!!.getString("Comment_body")
        val commentName = arguments!!.getString("Comment_name")





        body_comment_body.text = commentBody
        body_comment_email.text = commentEmail
        body_comment_name.text = commentName




    }
}


