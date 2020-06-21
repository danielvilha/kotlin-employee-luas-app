package com.danielvilha.luasapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielvilha.luasapp.R
import com.danielvilha.luasapp.di.component.ActivityComponent
import com.danielvilha.luasapp.ui.base.BaseActivity
import com.danielvilha.luasapp.utils.view.TramAdapter
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by danielvilha on 21/06/20
 */
class HomeActivity : BaseActivity<HomeViewModel>() {

    lateinit var tramAdapter: TramAdapter

    override fun provideLayoutId(): Int = R.layout.activity_home

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        /**
          *
         **/
        tramAdapter = TramAdapter(ArrayList())
        recycler.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = tramAdapter
        }

        button_refresh.setOnClickListener {
            viewModel.refresh()
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.getForecastData().observe(this, Observer {
            tramAdapter.update(it?.trams)
        })

        viewModel.getDestination().observe(this, Observer {
            txv_stop?.text = it
        })

        viewModel.getDirection().observe(this, Observer {
            txv_name?.text = it
        })

        viewModel.getLoadVisibility().observe(this, Observer {
            progress_bar?.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}