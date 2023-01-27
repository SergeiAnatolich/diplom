package ru.iteco.fmhandroid.ui

import androidx.test.uiautomator.By
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.*
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class NewsPageTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val mainPage = MainPage()
    private val newsPage = NewsPage()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        device.startLauncher()
        try {
            authorizationPage.login()
        } catch (e: Throwable) {
            println("the user is already logged in")
        }
        appBarAllPage.clickButtonMainMenu().waitMenu().clickNews().waitNewsPage()
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
    fun testChangeSort() {
        val firstNews = newsPage.getTitleNews()
        newsPage.clickSort()
        val newFirstNews = newsPage.getTitleNews()
        assertNotEquals(firstNews, newFirstNews)
    }

    @Test
    fun testCollapsingAndUnfoldingTheNews() {
        mainPage.swipePage().waitDescription()
        assertTrue(device.device.hasObject(By.res(device.MODEL_PACKAGE, newsPage.description)))

        newsPage.clickViewNews().waitNewsPage()
        assertFalse(device.device.hasObject(By.res(device.MODEL_PACKAGE, newsPage.description)))
    }
}