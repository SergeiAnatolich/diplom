package ru.iteco.fmhandroid.ui.pages

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.uiautomator.*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.Device

open class MainPage : Device() {
    val main = "Main"
    val allNews = "ALL NEWS"
    val allClaims = "ALL CLAIMS"
    val newsListMain = "container_list_news_include_on_fragment_main"
    val viewNews = "view_news_item_image_view"
    val allNewsCardsBlock = "all_news_cards_block_constraint_layout"
    val newsDescription = "news_item_description_text_view"
    val descriptionText = "description_material_text_view"
    val descriptionCard = "description_material_card_view"
    val refreshMain = "main_swipe_refresh"
    val appBarMain = "container_custom_app_bar_include_on_fragment_main"
    val addNewClaimButton = "add_new_claim_material_button"
    val claimListCard = "claim_list_card"
    val titleText = "title_text_view"
    val addCommentButton = "add_comment_image_button"
    val closeButton = "close_image_button"
    val allNewsButton = "all_news_text_view"
    val allClaimsButton = "all_claims_text_view"

    fun newClaimButtonClick(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, addNewClaimButton)).click()
        return ClaimPage()
    }

    fun waitMainPage(): MainPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, newsListMain)), TIMEOUT)
        return this
    }

    fun checkingPage() {
        device.findObject(By.res(MODEL_PACKAGE, refreshMain)).isChecked
    }

    fun swipePage(): MainPage {
        device.findObject(By.res(MODEL_PACKAGE, NewsPage().card)).swipe(Direction.UP, 0.0f)
        return this
    }

    fun waitDescription() {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, NewsPage().description)), TIMEOUT)
    }

    fun getGroupNews(): ViewInteraction {
        return Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.all_news_cards_block_constraint_layout),
                ViewMatchers.withParent(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.container_list_news_include_on_fragment_main),
                        ViewMatchers.withParent(IsInstanceOf.instanceOf(LinearLayout::class.java))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
    }

    fun clickArrowButtonNewsSection() {
        val materialButton = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.expand_material_button),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.container_list_news_include_on_fragment_main),
                        0
                    ),
                    4
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton.perform(ViewActions.click())
    }

    fun getTextViewNews(): ViewInteraction {
        return Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.all_news_text_view),
                ViewMatchers.withText(allNews),
                ViewMatchers.withParent(
                    Matchers.allOf(
                        ViewMatchers.withId(R.id.container_list_news_include_on_fragment_main),
                        ViewMatchers.withParent(IsInstanceOf.instanceOf(LinearLayout::class.java))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
    }

    fun clickArrowButtonNews(): MainPage {
        device.findObject(By.res(MODEL_PACKAGE, viewNews)).click()
        return this
    }

    fun waitAllNewsCardsBlock() {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, allNewsCardsBlock)), TIMEOUT)
    }

    fun checkingNewsDescription(): Boolean {
        return device.hasObject(By.res(MODEL_PACKAGE, newsDescription))
    }

    fun clickArrowButtonClaimsSection() {
        val materialButton2 = onView(
            Matchers.allOf(
                withId(R.id.expand_material_button),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.container_list_claim_include_on_fragment_main),
                        0
                    ),
                    3
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton2.perform(ViewActions.click())
    }

    fun getViewGroupClaims(): ViewInteraction {
        return onView(
            Matchers.allOf(
                withId(R.id.all_claims_cards_block_constraint_layout),
                ViewMatchers.withParent(
                    Matchers.allOf(
                        withId(R.id.container_list_claim_include_on_fragment_main),
                        ViewMatchers.withParent(IsInstanceOf.instanceOf(LinearLayout::class.java))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
    }

    fun getTextViewClaims(): ViewInteraction {
        return onView(
            Matchers.allOf(
                withId(R.id.all_claims_text_view), ViewMatchers.withText(allClaims),
                ViewMatchers.withParent(
                    Matchers.allOf(
                        withId(R.id.container_list_claim_include_on_fragment_main),
                        ViewMatchers.withParent(IsInstanceOf.instanceOf(LinearLayout::class.java))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
    }

    fun getTopic(): String {
        return device.findObject(By.res(MODEL_PACKAGE, descriptionText)).text
    }

    fun clickClaimListCard(): MainPage {
        device.findObject(By.res(MODEL_PACKAGE, claimListCard)).click()
        return this
    }

    fun waitDescriptionCard() {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, descriptionCard)), TIMEOUT)
    }

    fun scrollPage(res: String): MainPage {
        val page = UiScrollable(UiSelector().scrollable(true))
        page.scrollIntoView(UiSelector().resourceId(res))
        return this
    }

    fun getTitleClaim(): String {
        return device.findObject(By.res(MODEL_PACKAGE, titleText)).text
    }

    fun clickCloseButton() {
        device.findObject(By.res(MODEL_PACKAGE, closeButton)).click()
    }

    fun clickAllNewsButton(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, allNewsButton)).click()
        return NewsPage()
    }

    fun clickAllClaimsButton(): ClaimPage {
        device.findObject(By.res(MODEL_PACKAGE, allClaimsButton)).click()
        return ClaimPage()
    }


    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}