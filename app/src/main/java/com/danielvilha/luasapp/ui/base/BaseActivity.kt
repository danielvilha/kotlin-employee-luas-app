package com.danielvilha.luasapp.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.danielvilha.luasapp.AppApplication
import com.danielvilha.luasapp.di.component.ActivityComponent
import com.danielvilha.luasapp.di.component.DaggerActivityComponent
import com.danielvilha.luasapp.di.module.ActivityModule
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject

/**
 * Created by danielvilha on 21/06/20
 */
abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onCreate()
    }

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    private fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()

    private fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as AppApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
}