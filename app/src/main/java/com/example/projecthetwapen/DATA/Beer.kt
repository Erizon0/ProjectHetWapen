package com.example.projecthetwapen.DATA

import android.os.Parcel
import android.os.Parcelable

class Beer(
    var id: Int,
    var name: String?,
    var description: String?,
    var type: String?,
    var abv: Float,
    var stars: Int,
    var image: String?,
    var brewery: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(type)
        parcel.writeFloat(abv)
        parcel.writeInt(stars)
        parcel.writeString(image)
        parcel.writeString(brewery)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Beer(id=$id, name=$name, description=$description, type=$type, abv=$abv, rating=$stars, imageLink=$image, brewery=$brewery)\n"
    }

    companion object CREATOR : Parcelable.Creator<Beer> {
        override fun createFromParcel(parcel: Parcel): Beer {
            return Beer(parcel)
        }

        override fun newArray(size: Int): Array<Beer?> {
            return arrayOfNulls(size)
        }
    }




}