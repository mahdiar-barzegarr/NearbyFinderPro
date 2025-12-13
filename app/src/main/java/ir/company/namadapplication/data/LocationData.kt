package ir.company.namadapplication.data

import androidx.compose.ui.graphics.Color
import ir.company.namadapplication.R
import ir.company.namadapplication.data.model.LocationModel

object LocationData {

    val locationList = listOf(
        LocationModel("مراکز درمانی", R.drawable.hospital, Color(0xffE4F1FF)),
        LocationModel("سوپرمارکت و فروشگاه\u200Cها", R.drawable.supermarket, Color(0xffE8F9E9)),
        LocationModel("رستوران\u200Cها و کافه\u200Cها", R.drawable.restaurant, Color(0xffFFF2DA)),
        LocationModel("خدمات خودرو و سوخت", R.drawable.mechanic, Color(0xffF2E6FF)),
        LocationModel("هتل ها و مسافرخانه ها", R.drawable.hotel, Color(0xffFFECEC)),
    )

}