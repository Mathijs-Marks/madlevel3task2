package com.example.madlevel3task2

import android.os.Parcel
import android.os.Parcelable

data class Portal(
        var portalText: String?,
        var portalUrlText: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
           portalText = parcel.readString(),
           portalUrlText = parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(portalText)
        parcel.writeString(portalUrlText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Portal> {
        override fun createFromParcel(parcel: Parcel): Portal {
            return Portal(parcel)
        }

        override fun newArray(size: Int): Array<Portal?> {
            return arrayOfNulls(size)
        }
    }

}