package io.kaeawc.motiontablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.content_layout.*

class PageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.content_layout, container, false)
    }

    override fun onResume() {
        super.onResume()
        scrolling_view?.setOnScrollChangeListener {
                _: NestedScrollView?,
                _: Int,
                scrollY: Int,
                _: Int,
                _: Int ->

            onVerticalScroll(scrollY)
        }
    }

    override fun onPause() {
        super.onPause()
        resetScrollPosition()
    }

    private fun onVerticalScroll(scrollY: Int) {
        (activity as? MainActivity)?.onVerticalScroll(scrollY)
    }

    private fun resetScrollPosition() {
        scrolling_view?.setOnScrollChangeListener { _: NestedScrollView?, _: Int, _: Int, _: Int, _: Int -> }
        scrolling_view?.scrollTo(0, 0)
    }
}
