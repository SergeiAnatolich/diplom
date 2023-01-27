// Generated by Dagger (https://dagger.dev).
package ru.iteco.fmhandroid.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.iteco.fmhandroid.repository.claimRepository.ClaimRepository;
import ru.iteco.fmhandroid.repository.userRepository.UserRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ClaimCardViewModel_Factory implements Factory<ClaimCardViewModel> {
  private final Provider<ClaimRepository> claimRepositoryProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  public ClaimCardViewModel_Factory(Provider<ClaimRepository> claimRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider) {
    this.claimRepositoryProvider = claimRepositoryProvider;
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public ClaimCardViewModel get() {
    return newInstance(claimRepositoryProvider.get(), userRepositoryProvider.get());
  }

  public static ClaimCardViewModel_Factory create(Provider<ClaimRepository> claimRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider) {
    return new ClaimCardViewModel_Factory(claimRepositoryProvider, userRepositoryProvider);
  }

  public static ClaimCardViewModel newInstance(ClaimRepository claimRepository,
      UserRepository userRepository) {
    return new ClaimCardViewModel(claimRepository, userRepository);
  }
}