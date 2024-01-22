package uz.jt17.tutorialforsardor.domain.use_case

import kotlinx.coroutines.flow.Flow
import uz.jt17.tutorialforsardor.domain.model.CurrentDataModel
import uz.jt17.tutorialforsardor.domain.repository.MyRepository

class GetAllDataUseCase(private val repository: MyRepository) {

    operator fun invoke(): Flow<List<CurrentDataModel>> = repository.getAllData()

}