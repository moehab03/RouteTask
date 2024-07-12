package com.route.routetask.data.repo

import com.route.routetask.data.data_models.ProductsItem
import com.route.routetask.data.data_sources.remote.RemoteDataSource
import com.route.routetask.data.data_sources.remote.RemoteDataSourceImpl
import com.route.routetask.domain.repo.ProductsRepo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductsRepoImplTest {
    private lateinit var remoteDS: RemoteDataSource
    private lateinit var productRepo: ProductsRepo

    @Before
    fun setUp() {
        remoteDS = mockk<RemoteDataSourceImpl>()
        productRepo = ProductsRepoImpl(remoteDS)
    }

    @Test
    fun `getProducts return list of product when remote data source return data`() = runBlocking {
        val expectedProducts = emptyList<ProductsItem>()
        coEvery { remoteDS.getProducts() } returns expectedProducts

        val actualProducts = productRepo.getProducts()
        assertEquals(expectedProducts, actualProducts)
    }
}