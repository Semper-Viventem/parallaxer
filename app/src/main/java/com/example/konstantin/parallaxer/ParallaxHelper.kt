package com.example.konstantin.parallaxer

import android.support.annotation.IdRes
import android.support.v4.view.ViewPager
import android.view.View

/**
 * @author Semper-Viventem
 * @since 07.05.2018
 */
class ParallaxHelper {

    companion object {
        const val MAX_OPTICAL_DEPTH = 1f
        const val MIN_OPTICAL_DEPTH = -1f
    }

    private data class ParallaxObject(
        val viewId: Int,
        val depth: Float
    )

    private var viewPager: ViewPager? = null

    private val parallaxObjects: MutableList<ParallaxObject> = mutableListOf()

    private val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            // do nothing
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            parallaxObjects.forEach { parallaxObject ->
                val currentPageView = viewPager!!.getChildAt(position)?.findViewById<View>(parallaxObject.viewId)
                val nextPageView = viewPager!!.getChildAt(position + 1)?.findViewById<View>(parallaxObject.viewId)

                val offset = calculateOffset(positionOffsetPixels, parallaxObject.depth)
                val maxOffset = calculateOffset(viewPager!!.width, parallaxObject.depth)

                currentPageView?.translationX = offset.toFloat()
                nextPageView?.translationX = (offset - maxOffset).toFloat()
            }
        }

        override fun onPageSelected(position: Int) {
            // do nothing
        }
    }

    fun attachViewPager(viewPager: ViewPager) {
        this.viewPager = viewPager
        this.viewPager!!.addOnPageChangeListener(pageChangeListener)
    }

    fun addParallaxView(@IdRes viewId: Int, depth: Float) {
        parallaxObjects.add(ParallaxObject(viewId, depth))
    }

    fun detachViewPager() {
        this.viewPager?.removeOnPageChangeListener(pageChangeListener)
        this.viewPager = null
    }

    private fun calculateOffset(positionOffsetPixels: Int, depth: Float): Double =
        (positionOffsetPixels * depth).toDouble()
}