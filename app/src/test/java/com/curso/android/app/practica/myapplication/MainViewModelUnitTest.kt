package com.curso.android.app.practica.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.myapplication.view.MainViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparison.value?.boolean
        assertEquals(false, value)
    }

    @Test
    fun mainViewModel_TestSameTexts() = runTest {
        launch {
            viewModel.compare("Hola", "Hola")
        }
        advanceUntilIdle()
        val value = viewModel.comparison.value?.boolean
        assertEquals(true, value)
    }

    @Test
    fun mainViewModel_TestDifferentTexts() = runTest {
        launch {
            viewModel.compare("Hola", "Hola Mundo")
        }
        advanceUntilIdle()
        val value = viewModel.comparison.value?.boolean
        assertEquals(false, value)
    }
}