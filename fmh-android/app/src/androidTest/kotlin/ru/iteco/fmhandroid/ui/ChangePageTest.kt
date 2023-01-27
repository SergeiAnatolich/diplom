package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class ChangePageTest {

    private val aboutPage = AboutPage()
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

    @After
    fun afterEachTest() {
        try {
            appBarAllPage.logOut()
        } catch (e: Throwable) {
            println("the authorization image button is not available")
        }
    }

    @Test
    fun testChangePage() {
        appBarAllPage.clickButtonMainMenu().waitMenu().clickClaims().waitClaimPage().checkingPage()

        appBarAllPage.clickButtonMainMenu().waitMenu().clickNews().waitNewsPage().checkingPage()

        appBarAllPage.clickButtonMainMenu().waitMenu().clickMain().waitMainPage().checkingPage()

        appBarAllPage.clickButtonMainMenu().waitMenu().clickAbout().waitTrademark()
        aboutPage.checkingPage().clickButtonBack().waitPreviousPage()
    }
}