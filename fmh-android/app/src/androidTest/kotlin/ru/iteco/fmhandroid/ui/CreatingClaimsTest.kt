package ru.iteco.fmhandroid.ui

import io.qameta.allure.android.runners.AllureAndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.pages.*

@RunWith(AllureAndroidJUnit4::class)
class CreatingClaimsTest {

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
        claimPage.clickAddNewClaimButton().waitClaimsCreatingPage()
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
    fun testEnteringTextInTheTitleField() {
        claimPage.titleEdit(claimPage.latin)
        val textLatin = claimPage.getTitleInput()
        assertEquals(claimPage.latin, textLatin)

        claimPage.titleEdit(claimPage.cyrillic)
        val textCyrillic = claimPage.getTitleInput()
        assertEquals(claimPage.cyrillic, textCyrillic)

        claimPage.titleEdit(claimPage.digits)
        val textDigits = claimPage.getTitleInput()
        assertEquals(claimPage.digits, textDigits)

        claimPage.titleEdit(claimPage.specSymbols)
        val textSpecSymbols = claimPage.getTitleInput()
        assertEquals(claimPage.specSymbols, textSpecSymbols)
    }

    @Test
    fun testEnteringTextInTheExecutorField() {
        claimPage.inputExecutor(claimPage.latin)
        val textLatin = claimPage.getExecutorText()
        assertEquals(claimPage.latin, textLatin)

        claimPage.inputExecutor(claimPage.cyrillic)
        val textCyrillic = claimPage.getExecutorText()
        assertEquals(claimPage.cyrillic, textCyrillic)

        claimPage.inputExecutor(claimPage.digits)
        val textDigits = claimPage.getExecutorText()
        assertEquals(claimPage.digits, textDigits)

        claimPage.inputExecutor(claimPage.specSymbols)
        val textSpecSymbols = claimPage.getExecutorText()
        assertEquals(claimPage.specSymbols, textSpecSymbols)
    }

    @Test
    fun testSelectExecutor() {
        claimPage.clickDropMenuExecutor().dateClick()
        val textExecutorField = claimPage.getTextDropMenuExecutor()
        assertEquals(claimPage.executor, textExecutorField)
    }

    @Test
    fun testEnteringTextInTheDescriptionField() {
        claimPage.inputDescription(claimPage.latin)
        val textLatin = claimPage.getTextDescription()
        assertEquals(claimPage.latin, textLatin)

        claimPage.inputDescription(claimPage.cyrillic)
        val textCyrillic = claimPage.getTextDescription()
        assertEquals(claimPage.cyrillic, textCyrillic)

        claimPage.inputDescription(claimPage.digits)
        val textDigits = claimPage.getTextDescription()
        assertEquals(claimPage.digits, textDigits)

        claimPage.inputDescription(claimPage.specSymbols)
        val textSpecSymbols = claimPage.getTextDescription()
        assertEquals(claimPage.specSymbols, textSpecSymbols)
    }

    @Test
    fun testCreateClaimsAllFieldsEmpty() {
        claimPage.clickSaveButton().waitMessage()
        val textMessage = claimPage.getMessageText()
        assertEquals(claimPage.textMessageEmpty, textMessage)
    }

    @Test
    fun testCreateClaimsSuccess() {
        claimPage.titleEdit(claimPage.latin)
        claimPage.clickDropMenuExecutor().dateClick()
        claimPage.dateClick().waitAnimator().headerYearClick().selectYear().selectDay()
            .clickButtonOk()
        claimPage.waitClaimPage().clickTimeInput().waitTimePicker().clickToggleMode()
            .waitTimePicker().inputHour().inputMinute().clickButtonOk()
        claimPage.waitClaimsCreatingPage().inputDescription(claimPage.latin)
        claimPage.clickSaveButton().waitClaimPage().checkingPage()
    }
}