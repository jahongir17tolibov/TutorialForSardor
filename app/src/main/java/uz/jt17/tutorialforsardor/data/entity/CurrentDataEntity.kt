package uz.jt17.tutorialforsardor.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CurrentDataEntity.TABLE_NAME)
data class CurrentDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val currentMillis: String
) {

    companion object {
        const val TABLE_NAME: String = "current_data_table"
    }

}
