package ru.iteco.fmhandroid.ui.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import ru.iteco.fmhandroid.ui.Device

open class NewsPage : Device() {
    val news = "News"
    val newsList = "container_list_news_include"
    val newsRefresh = "news_list_swipe_refresh"
    val title = "news_item_title_text_view"
    val sort = "sort_news_material_button"
    val card = "news_item_material_card_view"
    val description = "news_item_description_text_view"
    val viewNews = "view_news_item_image_view"
    val editNewsButton = "edit_news_material_button"
    val swipeToRefresh = "news_control_panel_swipe_to_refresh"
    val addNews = "add_news_image_view"
    val dropList = "text_input_end_icon"
    val newsTitle = "news_item_title_text_input_edit_text"
    val newsCategory = "news_item_category_text_auto_complete_text_view"
    val publishDate = "news_item_publish_date_text_input_edit_text"
    val publishTime = "news_item_publish_time_text_input_edit_text"
    val publishedText = "news_item_published_text_view"
    val saveButton = "save_button"
    val descriptionInput = "news_item_description_text_input_edit_text"
    val comment = "test comment"
    val editNews = "edit_news_item_image_view"
    val appBarTitle = "custom_app_bar_title_text_view"
    val switcher = "switcher"

    fun waitNewsPage(): NewsPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, newsList)), TIMEOUT)
        return this
    }

    fun checkingPage() {
        device.findObject(By.res(MODEL_PACKAGE, newsRefresh)).isChecked
    }

    fun checkingNewsList() {
        device.findObject(By.res(MODEL_PACKAGE, newsList)).isChecked
    }

    fun getTitleNews(): String {
        return device.findObject(By.res(MODEL_PACKAGE, title)).text
    }

    fun clickSort() {
        device.findObject(By.res(MODEL_PACKAGE, sort)).click()
    }

    fun clickViewNews(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, viewNews)).click()
        return this
    }

    fun clickEditNewsButton(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, editNewsButton)).click()
        return this
    }

    fun waitControlPanel() {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, swipeToRefresh)), TIMEOUT)
    }

    fun clickAddNews(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, addNews)).click()
        return this
    }

    fun clickDropList(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, dropList)).click()
        return this
    }

    fun clickNewsTitle() {
        device.findObject(By.res(MODEL_PACKAGE, newsTitle)).click()
    }

    fun getCategory(): String {
        return device.findObject(By.res(MODEL_PACKAGE, newsCategory)).text
    }

    fun getTitleNewsText(): String {
        return device.findObject(By.res(MODEL_PACKAGE, newsTitle)).text
    }

    fun clickPublishDate(): Calendar {
        device.findObject(By.res(MODEL_PACKAGE, publishDate)).click()
        return Calendar()
    }

    fun clickPublishTime(): Clock {
        device.findObject(By.res(MODEL_PACKAGE, publishTime)).click()
        return Clock()
    }

    fun waitCreatingNewsPage(): NewsPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, saveButton)), TIMEOUT)
        return this
    }

    fun descriptionInput(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, descriptionInput)).text = NewsPage().comment
        return this
    }

    fun clickSaveButton(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, saveButton)).click()
        return this
    }

    fun getPublished(): String {
        return device.findObject(By.res(MODEL_PACKAGE, publishedText)).text
    }

    fun clickEditNews(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, editNews)).click()
        return this
    }

    fun waitEditingNewsPage(): NewsPage {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, appBarTitle)), TIMEOUT)
        return this
    }

    fun clickSwitcher(): NewsPage {
        device.findObject(By.res(MODEL_PACKAGE, switcher)).click()
        return this
    }
}