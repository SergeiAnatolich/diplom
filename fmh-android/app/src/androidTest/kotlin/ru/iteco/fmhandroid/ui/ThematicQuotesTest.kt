package ru.iteco.fmhandroid.ui

import androidx.test.espresso.assertion.ViewAssertions
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class ThematicQuotesTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val thematicQuotesPage = ThematicQuotesPage()
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
    fun testOpenThematicQuotesPage() {
        appBarAllPage.clickThematicQuotes().waitThematicQuotesPage()
        thematicQuotesPage
        thematicQuotesPage.checkingPage()
    }

    @Test
    fun testCollapsingAndUnfoldingTheThematicQuotes() {
        appBarAllPage.clickThematicQuotes().waitThematicQuotesPage().clickButton().checkingText()
        val textView = thematicQuotesPage.textView()
        thematicQuotesPage.clickButton()
        textView.check(ViewAssertions.doesNotExist())
    }
}