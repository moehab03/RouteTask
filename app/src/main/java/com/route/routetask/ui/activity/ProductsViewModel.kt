package com.route.routetask.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.routetask.data.data_models.ProductsItem
import com.route.routetask.domain.use_cases.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsUseCase: ProductsUseCase) :
    ViewModel() {

    private val _list = MutableLiveData<List<ProductsItem?>?>()
    val list: LiveData<List<ProductsItem?>?> = _list
    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading
    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun getProducts() {
        viewModelScope.launch {
            try {
                _list.value = productsUseCase.execute()
                _loading.value = false
            } catch (t: Throwable) {
                //loading.value = false
                if (t.localizedMessage == "Unable to resolve host \"dummyjson.com\": No address associated with hostname")
                    _errorMsg.value = "No internet connection"
                else
                    _errorMsg.value = t.localizedMessage
            }
        }
    }

}