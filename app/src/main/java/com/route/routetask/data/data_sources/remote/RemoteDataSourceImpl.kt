package com.route.routetask.data.data_sources.remote

import com.route.routetask.data.api.WebServices
import com.route.routetask.data.data_models.ProductsItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    RemoteDataSource {
    override suspend fun getProducts(): List<ProductsItem?>? {
        return webServices.getProducts().products
    }
}