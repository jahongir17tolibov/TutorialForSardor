package uz.jt17.tutorialforsardor.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.jt17.tutorialforsardor.domain.model.CurrentDataModel
import uz.jt17.tutorialforsardor.domain.repository.MyRepository
import uz.jt17.tutorialforsardor.domain.use_case.GetAllDataUseCase

class MainViewModel(
    private val repository: MyRepository,
    private val useCase: GetAllDataUseCase,
) : ViewModel() {

    init {
        getAllDataFromDb()
    }

    private val _getData = MutableStateFlow<List<CurrentDataModel>>(emptyList())
    val getData: StateFlow<List<CurrentDataModel>> get() = _getData.asStateFlow()

    private fun getAllDataFromDb() {
        viewModelScope.launch {
            useCase().collect { list ->
                _getData.value = list
            }
        }
    }

    fun insertData(currentDataMillis: String) {
        val model = CurrentDataModel(id = 0, currentDate = currentDataMillis)
        viewModelScope.launch(IO) {
            repository.insertCurrentData(model)
        }
    }

    fun deleteItem(id: Int) {
        viewModelScope.launch(IO) {
            repository.deleteData(id)
        }
    }

    fun clearAllData() {
        viewModelScope.launch(IO) {
            repository.clearAllData()
        }
    }

}