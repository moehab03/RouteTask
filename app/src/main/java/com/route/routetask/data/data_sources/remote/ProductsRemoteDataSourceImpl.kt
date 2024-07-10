package com.route.routetask.data.data_sources.remote

import com.route.routetask.data.api.WebServices
import com.route.routetask.data.data_models.ProductsItem
import com.route.routetask.data.data_models.ProductsResponse
import javax.inject.Inject

class ProductsRemoteDataSourceImpl @Inject constructor(private val webServices: WebServices) : ProductsRemoteDataSource {
    override suspend fun getProducts(): List<ProductsItem?>? {
        return webServices.getProducts().products
    }
}