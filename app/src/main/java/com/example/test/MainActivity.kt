package com.example.test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.test.databinding.ActivityMainBinding
import com.jakewharton.rxbinding3.view.clicks
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val sampleViewModel: SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[NumberViewModel::class.java]

        viewModel.getNumber().observe(this) { number ->
            binding.numberTextView.text = number.toString()
        }

        // 각 버튼의 클릭 이벤트를 Observable로 변환
        val increaseButtonObservable = binding.increaseButton.clicks().map { INCREMENT }
        val increaseButton2Observable = binding.increaseButton2.clicks().map { INCREMENT }
        // 두 Observable을 병합
        val mergedObservable = Observable.merge(increaseButtonObservable, increaseButton2Observable)

        // 병합된 Observable을 구독하여 처리
        val disposable = mergedObservable.subscribe { action ->
            when (action) {
                INCREMENT -> viewModel.incrementNumber()
            }
        }
        compositeDisposable.add(disposable)

        sampleData()
    }

    private fun sampleData() {
        binding.vm = sampleViewModel
        binding.lifecycleOwner = this
        binding.btnHi.setOnClickListener {
            sampleViewModel.fetchUserName()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    companion object {
        private const val INCREMENT = "increment"
    }
}
