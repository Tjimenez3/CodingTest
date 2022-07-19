package com.vogella.android.codingtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vogella.android.codingtest.ui.main.EmailModel
import kotlinx.coroutines.launch

class EmailViewModel(private val api: ApiRequest): ViewModel() {

    private val _responseEmailItems : MutableLiveData<List<EmailModel>> = MutableLiveData()
    val responseNewsItems : LiveData<List<EmailModel>>
        get() {
        return _responseEmailItems
    }



    fun makeApiRequest(){
        viewModelScope.launch {
            runCatching {
                api.getEmails()
            }.onSuccess {
                processWithNewsResponse(it)
            }.onFailure {
                processWithError(it)
            }
        }
    }
    private fun processWithNewsResponse(newsResponse: List<EmailModel>?) {
        var sortedEmailResponse = newsResponse?.filter {
            it.emailShortDesc.isNullOrEmpty() == false
        }?.sortedBy {
            it.fromDate
        }
        _responseEmailItems.postValue(sortedEmailResponse)

    }

    private fun processWithError(t: Throwable) {
        println("ERROR")
        //error
    }
}