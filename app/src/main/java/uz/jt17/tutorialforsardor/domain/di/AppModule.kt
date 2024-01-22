package uz.jt17.tutorialforsardor.domain.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.jt17.tutorialforsardor.domain.repository.MyRepository
import uz.jt17.tutorialforsardor.domain.repository.MyRepositoryImpl
import uz.jt17.tutorialforsardor.domain.use_case.GetAllDataUseCase
import uz.jt17.tutorialforsardor.feature.MainViewModel

val appModule = module {

    single {
        MyRepositoryImpl(get())
    } bind MyRepository::class

    singleOf(::GetAllDataUseCase)

}

val viewModelModule = module {
    viewModel<MainViewModel> {
        MainViewModel(get(), get())
    }
}