package uz.jt17.tutorialforsardor.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uz.jt17.tutorialforsardor.data.local.MyDao
import uz.jt17.tutorialforsardor.domain.mapper.toCurrentDataEntity
import uz.jt17.tutorialforsardor.domain.mapper.toCurrentDataModel
import uz.jt17.tutorialforsardor.domain.model.CurrentDataModel

class MyRepositoryImpl(private val dao: MyDao) : MyRepository {

    override fun getAllData(): Flow<List<CurrentDataModel>> =
        dao.getAllDataFromDb().map { entity ->
            entity.map {
                it.toCurrentDataModel()
            }
        }

    override suspend fun insertCurrentData(data: CurrentDataModel) {
        val currentDataEntity = data.toCurrentDataEntity()
        dao.insertData(currentDataEntity)
    }

    override suspend fun deleteData(id: Int) = dao.deleteItem(id)

    override suspend fun clearAllData() = dao.clearAll()
}