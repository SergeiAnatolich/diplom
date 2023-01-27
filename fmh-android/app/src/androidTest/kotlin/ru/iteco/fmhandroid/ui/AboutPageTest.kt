package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class AboutPageTest {

    private val aboutPage = AboutPage()
    private val appBarAllPage = AppBarAllPage()
    private val chrome = Chrome()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        Device().startLauncher()
        try {
            AuthorizationPage().login()
        } catch (e: Throwable) {
            println("the user is already logged in")
        }
        appBarAllPage.clickButtonMainMenu().waitMenu().clickAbout().waitTrademark()
    }


    @After
    fun afterEachTest() {
        try {
            aboutPage.clickButtonBack().waitPreviousPage().logOut()
        } catch (e: Throwable) {
            println("the authorization image button is not available")
        }
    }

    @Test
    fun testCheckingLinks() {
        val ver = aboutPage.getVersionApp()
        assertEquals(ver, aboutPage.fieldVersion)

        val urlPrivacyPolicy = aboutPage.getUrlPrivacyPolicy()
        assertEquals(urlPrivacyPolicy, aboutPage.fieldUrlPrivacyPolicy)

        val urlTermsOfUse = aboutPage.getUrlTermsOfUse()
        assertEquals(urlTermsOfUse, aboutPage.fieldUrlTermsOfUse)
    }

    @Test
    fun testOpenPrivacyPolicy() {
        aboutPage.privacyPolicyClick().waitChrome()
        val urlPrivacyPolicy = chrome.getUrl()
        assertEquals(aboutPage.fieldUrlPrivacyPolicy, urlPrivacyPolicy)
        device.device.pressBack()
    }

    @Test
    fun testOpenTermsOfUse() {
        aboutPage.termsOfUseClick().waitChrome()
        val urlTermsOfUse = chrome.getUrl()
        assertEquals(aboutPage.fieldUrlTermsOfUse, urlTermsOfUse)
        device.device.pressBack()
    }
}