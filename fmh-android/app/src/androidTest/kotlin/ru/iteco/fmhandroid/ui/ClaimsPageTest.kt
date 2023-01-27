package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class ClaimsPageTest {

    private val appBarAllPage = AppBarAllPage()
    private val authorizationPage = AuthorizationPage()
    private val claimPage = ClaimPage()
    private val device = Device()

    @Before
    fun beforeEachTest() {
        device.startLauncher()
        try {
            authorizationPage.login()
        } catch (e: Throwable) {
            println("the user is already logged in")
        }
        appBarAllPage.clickButtonMainMenu().waitMenu().clickClaims().waitClaimPage().checkingPage()
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
    fun testOpenFilter() {
        val text = claimPage.clickFiltersButton().waitFiltering().getFiltering()
        assertEquals(claimPage.filter, text)
    }

    @Test
    fun testCreateNewClaims() {
        claimPage.clickAddNewClaimButton().waitClaimsCreatingPage()
        val text1 = claimPage.getCreatingTitle()
        assertEquals(claimPage.creating, text1)
        val text2 = claimPage.getClaimsTitle()
        assertEquals(claimPage.claims, text2)
    }

    @Test
    fun testOpenClaims() {
        val topic = claimPage.getTopic()
        claimPage.clickClaimListCard().waitDescriptionCard()
        val title = claimPage.getTitleClaim()
        assertEquals(topic, title)
    }
}