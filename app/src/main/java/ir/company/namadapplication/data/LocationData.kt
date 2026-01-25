package ir.company.namadapplication.data

import androidx.compose.ui.graphics.Color
import ir.company.namadapplication.R
import ir.company.namadapplication.data.model.LocationModel
import ir.company.namadapplication.data.model.SubCategoriesModel

object LocationData {

    val locationCategoriesList = listOf(
        LocationModel(1, "مراکز درمانی", R.drawable.hospital, Color(0xffE4F1FF)),
        LocationModel(2, "خدمات خودرو و سوخت", R.drawable.supermarket, Color(0xffE8F9E9)),
        LocationModel(
            3,
            "رستوران\u200Cها و کافه\u200Cها",
            R.drawable.restaurant,
            Color(0xffFFF2DA)
        ),
        LocationModel(4, "سوپرمارکت و فروشگاه\u200Cها", R.drawable.mechanic, Color(0xffF2E6FF)),
        LocationModel(5, "هتل ها و مسافرخانه ها", R.drawable.hotel, Color(0xffFFECEC)),
    )

    val locationHospitalList = listOf(
        SubCategoriesModel(
            title = "بیمارستان",
            apiCategory = "healthcare.hospital",
            icon = R.drawable.hospital,
            color = Color(0xffFFECEC)
        ),
        SubCategoriesModel(
            title = "داروخانه",
            apiCategory = "healthcare.parmecy",
            icon = R.drawable.drugstore,
            color = Color(0xffFFF2DA)
        ),
        SubCategoriesModel(
            title = "داروخانه",
            apiCategory = "healthcare.parmecy",
            icon = R.drawable.drugstore,
            color = Color(0xffF2E6FF)
        )
    )

    val restaurantList = listOf(
        SubCategoriesModel(
            title = "رستوران ها",
            apiCategory = "",
            icon = R.drawable.restaurant,
            color = Color(0xffFFECEC),
        ),
        SubCategoriesModel(
            title = "کافه",
            apiCategory = "",
            icon = R.drawable.restaurant,
            color = Color(0xffFFECEC),
        ),
        SubCategoriesModel(
            title = "فست فود",
            apiCategory = "",
            icon = R.drawable.restaurant,
            color = Color(0xffFFECEC),
        ),
    )

//    val carServiceList = listOf(
//        SubCategoriesModel(
//            1,
//            "تعمیرگاه ها",
//            R.drawable.repairshop,
//            Color(0xffFFECEC),
//            apiCategory = "healthcare.hospital"
//        ),
//        SubCategoriesModel(
//            2,
//            "پمپ بنزین و سوخت",
//            R.drawable.gasstation,
//            Color(0xffFFF2DA),
//            apiCategory = "healthcare.hospital"
//        ),
//        SubCategoriesModel(
//            3,
//            "کارواش ها",
//            R.drawable.carwash,
//            Color(0xffF2E6FF),
//            apiCategory = "healthcare.hospital"
//        )
//    )
//
//    val hotelList = listOf(
//        SubCategoriesModel(
//            1,
//            "هتل ها",
//            R.drawable.hotel2,
//            Color(0xffFFECEC),
//            apiCategory = "healthcare.hospital"
//        ),
//        SubCategoriesModel(
//            2,
//            "مهمانسراها",
//            R.drawable.gust,
//            Color(0xffFFF2DA),
//            apiCategory = "healthcare.hospital"
//        ),
//        SubCategoriesModel(
//            3,
//            "مسافرخانه ها",
//            R.drawable.motel,
//            Color(0xffF2E6FF),
//            apiCategory = "healthcare.hospital"
//        )
//    )


}