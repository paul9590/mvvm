package com.example.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel() {

    // MutableLiveData로 선언하여 데이터 변경이 가능한 LiveData를 생성
    private val numberLiveData = MutableLiveData<Int>()

    // LiveData를 불변성을 유지하도록 노출
    fun getNumber(): LiveData<Int> = numberLiveData

    init {
        // 초기값 설정
        numberLiveData.value = 0
    }

    fun incrementNumber() {
        // LiveData의 값을 변경하기 위해선 setValue() 또는 postValue()를 사용
        // setValue()는 UI 스레드에서 호출되어야 하며, postValue()는 백그라운드 스레드에서 호출해야 함
        numberLiveData.value = (numberLiveData.value ?: 0) + 1
    }
}
