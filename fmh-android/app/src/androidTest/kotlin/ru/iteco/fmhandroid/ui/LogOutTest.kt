package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class LogOutTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        device.startLauncher()
        try {
            authorizationPage.login()
        } catch (e: Throwable) {
            println("the user is already logged in")
        }
    }

    @Test
    fun testLogOutOnPressButtonLogOut() {
        appBarAllPage.clickAuthorizationButton().waitDropMenu().clickLogOutButton()
            .waitAuthorizationPage().checkingPage()
    }
}