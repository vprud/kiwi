package io.github.vprud

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class AppTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testAppInitialState() {
        composeRule.setContent {
            App()
        }

        // Проверяем наличие кнопки
        composeRule.onNodeWithText("Click me!").assertExists()

        // Контент изначально скрыт
        composeRule
            .onNodeWithContentDescription("")
            .assertDoesNotExist()
    }

    @Test
    fun testContentVisibilityToggle() {
        composeRule.setContent {
            App()
        }

        // Нажимаем кнопку
        composeRule.onNodeWithText("Click me!").performClick()

        // Проверяем, что контент стал видимым
        composeRule.onNodeWithText("Compose: ", substring = true).assertExists()
    }
}
