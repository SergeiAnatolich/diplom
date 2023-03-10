// Generated by Dagger (https://dagger.dev).
package ru.iteco.fmhandroid.repository.newsRepository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.iteco.fmhandroid.api.NewsApi;
import ru.iteco.fmhandroid.dao.NewsCategoryDao;
import ru.iteco.fmhandroid.dao.NewsDao;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NewsRepositoryImpl_Factory implements Factory<NewsRepositoryImpl> {
  private final Provider<NewsDao> newsDaoProvider;

  private final Provider<NewsCategoryDao> newsCategoryDaoProvider;

  private final Provider<NewsApi> newsApiProvider;

  public NewsRepositoryImpl_Factory(Provider<NewsDao> newsDaoProvider,
      Provider<NewsCategoryDao> newsCategoryDaoProvider, Provider<NewsApi> newsApiProvider) {
    this.newsDaoProvider = newsDaoProvider;
    this.newsCategoryDaoProvider = newsCategoryDaoProvider;
    this.newsApiProvider = newsApiProvider;
  }

  @Override
  public NewsRepositoryImpl get() {
    return newInstance(newsDaoProvider.get(), newsCategoryDaoProvider.get(), newsApiProvider.get());
  }

  public static NewsRepositoryImpl_Factory create(Provider<NewsDao> newsDaoProvider,
      Provider<NewsCategoryDao> newsCategoryDaoProvider, Provider<NewsApi> newsApiProvider) {
    return new NewsRepositoryImpl_Factory(newsDaoProvider, newsCategoryDaoProvider, newsApiProvider);
  }

  public static NewsRepositoryImpl newInstance(NewsDao newsDao, NewsCategoryDao newsCategoryDao,
      NewsApi newsApi) {
    return new NewsRepositoryImpl(newsDao, newsCategoryDao, newsApi);
  }
}
