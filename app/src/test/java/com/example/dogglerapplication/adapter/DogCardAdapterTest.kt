package com.example.dogglerapplication.adapter

import android.content.Context
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.lang.Exception


class DogCardAdapterTest{
    private lateinit var adapter: DogCardAdapter
    @Before
    @Throws(Exception::class)
    fun setUp() {
        adapter = mock(DogCardAdapter::class.java)
        `when`(adapter.hasStableIds()).thenReturn(true)
    }

}