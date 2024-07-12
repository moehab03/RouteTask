package com.route.routetask.data.data_sources.remote

import com.route.routetask.data.api.WebServices
import com.route.routetask.data.data_models.ProductsResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RemoteDataSourceImplTest {
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var webServices: WebServices
    @BeforeEach
    fun setUp() {
        webServices = mockk<WebServices>()
        remoteDataSource = RemoteDataSourceImpl(webServices)
    }

    @Test
    fun `getProducts return list of product when web services return data`() {
        
    }
}