package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class CalendarTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val calendar = Calendar()
    private val claimPage = ClaimPage()
    private val mainPage = MainPage()
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
    fun testSelectDate() {
        mainPage.newClaimButtonClick().waitClaimsCreatingPage()
            .dateClick().waitAnimator().headerYearClick().selectYear()
            .nextMonth().prevMonth().selectDay().clickButtonOk()
        val date = claimPage.waitClaimsCreatingPage().getDate()
        assertEquals(calendar.day + "." + calendar.currentMonth + "." + calendar.year, date)
        claimPage.clickCancelButton().waitMessage().clickButtonOk()
        appBarAllPage.waitTrademark()
    }
}