package com.route.routetask.ui.activity

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

    val list = MutableLiveData<List<ProductsItem?>?>()
    val loading = MutableLiveData(true)
    val errorMsg = MutableLiveData<String>()

    fun getProducts() {
        viewModelScope.launch {
            try {
                list.value = productsUseCase.execute()
                loading.value = false
            } catch (t: Throwable) {
                //loading.value = false
                if (t.localizedMessage == "Unable to resolve host \"dummyjson.com\": No address associated with hostname")
                    errorMsg.value = "Connect to internet"
            }
        }
    }

}