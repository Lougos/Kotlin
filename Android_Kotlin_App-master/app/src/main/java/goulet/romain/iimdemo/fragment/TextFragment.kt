package goulet.romain.iimdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import goulet.romain.iimdemo.R
import kotlinx.android.synthetic.main.text_fragment_layout.*

class TextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.text_fragment_layout, container,false)
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val text = arguments!!.getString("text")
      body_text.text = text


  }
}


