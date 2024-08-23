package com.example.appwithkoin.feature.note.data.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class CreateNoteModelBody(
    val id:String  ,
    val title:String,
    val description:String,
    val color:String
):Parcelable
