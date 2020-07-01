package com.danielvilha.luasapp

import com.danielvilha.luasapp.data.remote.Building
import com.danielvilha.luasapp.data.repository.MiddlewareRepository
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by danielvilha on 01/07/20
 * https://github.com/danielvilha
 */
class GetDataUnitTest {
    @Test
    fun testGetMarlboroughCall_Outbound() {
        val api = Building.create("https://luasforecasts.rpa.ie/")
        val request = MiddlewareRepository(api).doMarlboroughCall("forecast", "mar", false)

        assertEquals("Outbound", request.blockingGet()[1].name)
    }

    @Test
    fun testGetStillorganCall_Inbound() {
        val api = Building.create("https://luasforecasts.rpa.ie/")
        val request = MiddlewareRepository(api).doMarlboroughCall("forecast", "sti", false)

        assertEquals("Inbound", request.blockingGet()[0].name)
    }
}