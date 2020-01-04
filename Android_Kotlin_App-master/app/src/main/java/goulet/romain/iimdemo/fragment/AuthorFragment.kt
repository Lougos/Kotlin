package goulet.romain.iimdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import goulet.romain.iimdemo.R
import kotlinx.android.synthetic.main.author_fragment_layout.*

class AuthorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.author_fragment_layout, container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authorUsername = arguments!!.getString("Author_username")
        val authorName = arguments!!.getString("Author_name")
        val authorEmail = arguments!!.getString("Author_email")
        val authorPhone = arguments!!.getString("Author_phone")
        val authorWebsite = arguments!!.getString("Author_website")
        val authorSuite = arguments!!.getString("Author_suite")
        val authorCity = arguments!!.getString("Author_city")
        val authorStreet = arguments!!.getString("Author_street")
        val authorZipcode = arguments!!.getString("Author_zipcode")
        val authorCompany = arguments!!.getString("Author_company")
        val authorCatchphrase = arguments!!.getString("Author_catchphrase")
        val authorLat = arguments!!.getString("Author_lat")
        val authorLng = arguments!!.getString("Author_lng")
        val authorBs = arguments!!.getString("Author_bs")



        body_author_username.text = authorUsername
        body_author_name.text = authorName
        body_author_email.text = authorEmail
        body_author_phone.text = authorPhone
        body_author_website.text = authorWebsite
        body_author_suite.text = authorSuite
        body_author_city.text = authorCity
        body_author_street.text = authorStreet
        body_author_zipcode.text = authorZipcode
        body_author_company.text = authorCompany
        body_author_catchphrase.text = authorCatchphrase
        body_author_lat.text = authorLat
        body_author_lng.text = authorLng
        body_author_bs.text = authorBs


    }
}