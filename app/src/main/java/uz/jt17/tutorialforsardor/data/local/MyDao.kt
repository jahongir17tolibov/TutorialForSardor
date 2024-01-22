package uz.jt17.tutorialforsardor.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.jt17.tutorialforsardor.data.entity.CurrentDataEntity

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(entity: CurrentDataEntity)

    @Query("SELECT * FROM ${CurrentDataEntity.TABLE_NAME} ORDER BY id")
    fun getAllDataFromDb(): Flow<List<CurrentDataEntity>>

    @Query("DELETE FROM ${CurrentDataEntity.TABLE_NAME} WHERE id = :id")
    suspend fun deleteItem(id: Int)

    @Query("DELETE FROM ${CurrentDataEntity.TABLE_NAME}")
    suspend fun clearAll()

}