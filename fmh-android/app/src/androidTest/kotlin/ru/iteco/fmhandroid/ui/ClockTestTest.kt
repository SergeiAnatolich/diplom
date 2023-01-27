package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class ClockTestTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val claimPage = ClaimPage()
    private val clock = Clock()
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
    fun testSelectTime() {
        mainPage.newClaimButtonClick().waitClaimsCreatingPage().clickTimeInput()
            .waitTimePicker().clickToggleMode().waitTimePicker().inputHour().inputMinute()
            .clickButtonOk()
        claimPage.waitClaimsCreatingPage()
        val time = clock.getTime()
        assertEquals(clock.hoursSelect + ":" + clock.minSelect, time)
        claimPage.clickCancelButton().waitMessage().clickButtonOk()
        appBarAllPage.waitTrademark()
    }
}