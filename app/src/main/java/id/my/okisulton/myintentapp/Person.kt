package id.my.okisulton.myintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *Created by Oki Sulton on 18/10/21.
 **/
@Parcelize
data class Person (
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
    ) : Parcelable
