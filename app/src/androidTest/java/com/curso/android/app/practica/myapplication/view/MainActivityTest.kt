package com.curso.android.app.practica.myapplication.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.myapplication.R
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareInitialization() {
        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales.")
            )
        )
    }

    @Test
    fun mainActivity_compareSameTexts() {

        Espresso.onView(
            ViewMatchers.withId(R.id.texto1)
        ).perform(
            ViewActions.typeText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.texto2)
        ).perform(
            ViewActions.typeText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.texto2)
        ).perform(
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales.")
            )
        )
    }

    @Test
    fun mainActivity_compareDistinct() {

        Espresso.onView(
            ViewMatchers.withId(R.id.texto1)
        ).perform(
            ViewActions.typeText("Hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.texto2)
        ).perform(
            ViewActions.typeText("Hola Mundo")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.texto2)
        ).perform(
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son distintos.")
            )
        )
    }
}