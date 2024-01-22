package uz.jt17.tutorialforsardor.domain.mapper

import uz.jt17.tutorialforsardor.data.entity.CurrentDataEntity
import uz.jt17.tutorialforsardor.domain.model.CurrentDataModel

fun CurrentDataModel.toCurrentDataEntity(): CurrentDataEntity = CurrentDataEntity(
    id = id,
    currentMillis = currentDate,
)

fun CurrentDataEntity.toCurrentDataModel(): CurrentDataModel = CurrentDataModel(
    id = id,
    currentDate = currentMillis,
)