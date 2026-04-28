package tests

import api.ProductApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import utils.Assertions

class ProductApiTest : BaseTest() {

    @Test
    fun testStatusCode() {
        val status = api.getStatusCode()
        assertEquals(200, status)
    }

    @Test
    fun testResponseNotEmpty() {
        val response = api.getAllProducts()
        assertTrue(response.isNotEmpty())
    }
    /*@Test
    fun testContainsProductTitle() {
        val response = api.getAllProducts()
        assertTrue(response.contains("title"))
    }*/
    @Test
    fun testProductsNotEmpty() {
        val products = api.getAllProducts()
        assertTrue(products.isNotEmpty())
    }
    @Test
    fun testFirstProductHasTitle() {
        val products = api.getAllProducts()
        assertTrue(products[0].title.isNotEmpty())
    }
    @Test
    fun testGetProductById() {
        val product = api.getProductById(1)

        assertEquals(1, product.id)
        assertTrue(product.title.isNotEmpty())
        assertTrue(product.price > 0)
    }
    @Test
    fun testProductPricePositive() {
        val products = api.getAllProducts()
        products.forEach {
            Assertions.assertPositivePrice(it.price)
        }
    }
}