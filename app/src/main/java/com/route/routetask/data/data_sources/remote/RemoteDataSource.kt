package com.route.routetask.data.data_sources.remote

import com.route.routetask.data.data_models.ProductsItem

interface RemoteDataSource {
    suspend fun getProducts(): List<ProductsItem?>?
}