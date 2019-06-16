package io.kaeawc.motiontablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager?.apply {
            adapter = MainAdapter(supportFragmentManager)
            tab_layout?.setupWithViewPager(this)
            addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
                override fun onPageSelected(position: Int) {
                    if (root_layout?.progress != 0f) {
                        root_layout?.transitionToStart()
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        view_pager?.clearOnPageChangeListeners()
    }

    internal fun onVerticalScroll(scroll: Int) {
        root_layout?.progress = Math.min(scroll / 1000f, 1f)
    }
}
