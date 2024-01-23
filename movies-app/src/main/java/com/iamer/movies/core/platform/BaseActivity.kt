package com.iamer.movies.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


/**
 * Created by Amer Elsayed.
 *12/25/2021
 *dev.amer.elsayed@gmail.com
 */

abstract class BaseActivity<VB : ViewBinding?> : AppCompatActivity() {

    protected var viewBinding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = viewBinding()

        if (viewBinding?.root != null)
            setContentView(viewBinding?.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }


    abstract fun viewBinding(): VB
}