package com.arch.qvikapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseTest {
    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    abstract fun setUp()

    @After
    abstract fun tearDown()

}