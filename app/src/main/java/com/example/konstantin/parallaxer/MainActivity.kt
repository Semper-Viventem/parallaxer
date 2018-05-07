package com.example.konstantin.parallaxer

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*


/**
 * @author Semper-Viventem
 * @since 07.05.2018
 */
class MainActivity : AppCompatActivity() {

    private val pages = listOf(
            R.layout.layout_page_title,
            R.layout.layout_page_2,
            R.layout.layout_page_1
    )

    private val pageAdapter = object : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            val pageView = container.inflate(pages[position])
            container.addView(pageView)
            return pageView
        }

        override fun isViewFromObject(view: View, any: Any): Boolean = view == any

        override fun getCount(): Int = pages.size

    }

    private val parallaxHelper = ParallaxHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
    }

    private fun initViewPager() {
        with(viewPager) {
            adapter = pageAdapter
            offscreenPageLimit = pages.size - 1
        }
        indicator.setViewPager(viewPager)
        with(parallaxHelper) {
            attachViewPager(viewPager)

            addParallaxView(R.id.oval1, 0.7F)
            addParallaxView(R.id.oval2, 0.4F)
            addParallaxView(R.id.oval3, 0.2F)
            addParallaxView(R.id.titleText, -0.2F)
            addParallaxView(R.id.titleText, -0.5F)

            addParallaxView(R.id.view1, 0.8F)
            addParallaxView(R.id.view2, 0.6F)
            addParallaxView(R.id.view3, 0.4F)
            addParallaxView(R.id.view4, 0.2F)
            addParallaxView(R.id.view5, 0.0F)
            addParallaxView(R.id.view6, -0.2F)
            addParallaxView(R.id.view7, -0.4F)
            addParallaxView(R.id.view8, -0.6F)
            addParallaxView(R.id.view9, -0.8F)
            addParallaxView(R.id.view10, -1.0F)
            addParallaxView(R.id.view1_2, 0.8F)
            addParallaxView(R.id.view2_2, 0.6F)
            addParallaxView(R.id.view3_2, 0.4F)
            addParallaxView(R.id.view4_2, 0.2F)
            addParallaxView(R.id.view5_2, 0.0F)
            addParallaxView(R.id.view6_2, -0.2F)
            addParallaxView(R.id.view7_2, -0.4F)
            addParallaxView(R.id.view8_2, -0.6F)
            addParallaxView(R.id.view9_2, -0.8F)
            addParallaxView(R.id.view10_2, -1.0F)
            addParallaxView(R.id.textDepth, 0.2F)

            addParallaxView(R.id.imageBackground, 0.7F)
            addParallaxView(R.id.accentOval1, 0.5F)
            addParallaxView(R.id.accentOval2, -0.5F)
            addParallaxView(R.id.textParallax, -0.8F)
        }
    }

    override fun onDestroy() {
        parallaxHelper.detachViewPager()
        super.onDestroy()
    }
}
