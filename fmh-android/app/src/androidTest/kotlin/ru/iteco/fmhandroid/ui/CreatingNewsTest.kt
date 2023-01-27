package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.*
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class CreatingNewsTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
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
        appBarAllPage.clickButtonMainMenu().waitMenu().clickNews().waitNewsPage().checkingPage()
        newsPage.clickEditNewsButton().waitControlPanel()
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
    fun testCreateNews() {
        newsPage.clickAddNews().clickDropList().clickNewsTitle()
        val category = newsPage.getCategory()
        val title = newsPage.getTitleNewsText()
        assertEquals(category, title)
        newsPage.clickPublishDate().waitAnimator().clickButtonOk()
        newsPage.waitCreatingNewsPage().clickPublishTime().waitTimePicker().clickButtonOk()
        newsPage.waitCreatingNewsPage().descriptionInput().clickSaveButton().waitControlPanel()
    }

    @Test
    fun testEditStatusNews() {
        val status = newsPage.getPublished()
        newsPage.clickEditNews().waitEditingNewsPage().clickSwitcher().clickSaveButton()
            .waitControlPanel()
        val newStatus = newsPage.getPublished()
        assertNotEquals(status, newStatus)
    }
}