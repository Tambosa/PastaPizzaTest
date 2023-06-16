package com.example.pastapizzatest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pastapizzatest.domain.model.Pasta

@Entity(tableName = RoomConst.TABLE_PASTA)
data class PastaEntity(
    @PrimaryKey(autoGenerate = false) val pastaId: String,
    val pastaName: String,
    val pastaImageUrl: String
)

fun PastaEntity.toPasta() = Pasta(
    id = this.pastaId,
    pastaName = this.pastaName,
    pastaImageUrl = this.pastaImageUrl
)