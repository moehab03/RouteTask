package com.route.routetask.data.data_sources.remote

import com.route.routetask.data.data_models.ProductsItem

interface ProductsRemoteDataSource {
    suspend fun getProducts(): List<ProductsItem?>?
}