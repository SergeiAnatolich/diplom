package ru.iteco.fmhandroid.ui.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.hamcrest.Matchers
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.Device

open class AuthorizationPage : Device() {

    val fieldLogin = "Login"
    val fieldPassword = "Password"
    val successLogin = "login2"
    val failLogin = "Log"
    val successPassword = "password2"
    val failPassword = "pass"
    val failLoginOrPassword = "Wrong login or password"
    val emptyLoginOrPassword = "Login and password cannot be empty"
    val authorization = "Authorization"
    val textInput = "login_text_input_layout"
    val enterButton = "enter_button"

    fun inputSuccessLogin(): AuthorizationPage {
        device.findObject(By.text(fieldLogin)).text = successLogin
        return this
    }

    fun inputSuccessPassword(): AuthorizationPage {
        device.findObject(By.text(fieldPassword)).text = successPassword
        return this
    }

    fun clickSignIn(): AppBarAllPage {
        device.findObject(By.res(MODEL_PACKAGE, enterButton)).click()
        return AppBarAllPage()
    }

    fun inputFailLogin(): AuthorizationPage {
        device.findObject(By.text(fieldLogin)).text = failLogin
        return this
    }

    fun inputFailPassword(): AuthorizationPage {
        device.findObject(By.text(fieldPassword)).text = failPassword
        return this
    }

    fun waitAuthorizationPage(): AuthorizationPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, textInput)), TIMEOUT)
        return this
    }

    fun checkingPage() {
        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withText(authorization),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.nav_host_fragment))),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText(authorization)))
    }

    fun login() {
        waitAuthorizationPage()
        inputSuccessLogin()
        inputSuccessPassword()
        clickSignIn()
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, AppBarAllPage().trademark)), TIMEOUT)
    }
}