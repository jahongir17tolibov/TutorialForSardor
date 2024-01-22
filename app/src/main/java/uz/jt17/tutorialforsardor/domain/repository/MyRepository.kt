package uz.jt17.tutorialforsardor.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.jt17.tutorialforsardor.domain.model.CurrentDataModel

interface MyRepository {

    fun getAllData(): Flow<List<CurrentDataModel>>

    suspend fun insertCurrentData(data: CurrentDataModel)

    suspend fun deleteData(id: Int)

    suspend fun clearAllData()

}