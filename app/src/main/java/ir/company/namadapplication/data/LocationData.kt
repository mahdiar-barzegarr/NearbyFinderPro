package ir.company.namadapplication.data

import androidx.compose.ui.graphics.Color
import ir.company.namadapplication.R
import ir.company.namadapplication.data.model.LocationModel
import ir.company.namadapplication.data.model.SubCategoriesModel

object LocationData {

    val locationCategoriesList = listOf(
        LocationModel(1, "مراکز درمانی", R.drawable.hospital, Color(0xffE4F1FF)),
        LocationModel(2, "خدمات خودرو و سوخت", R.drawable.mechanic, Color(0xffE8F9E9)),
        LocationModel(
            3,
            "رستوران\u200Cها و کافه\u200Cها",
            R.drawable.restaurant,
            Color(0xffFFF2DA)
        ),
        LocationModel(4, "هتل ها و مسافرخانه ها", R.drawable.hotel, Color(0xffFFECEC)),
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
            icon = R.drawable.cafe,
            color = Color(0xffFFECEC),
        ),
        SubCategoriesModel(
            title = "فست فود",
            apiCategory = "",
            icon = R.drawable.fastfood,
            color = Color(0xffFFECEC),
        ),
    )

    val carServiceList = listOf(
        SubCategoriesModel(
            "تعمیرگاه ها",
            icon = R.drawable.repairshop,
            color = Color(0xffFFECEC),
            apiCategory = "healthcare.hospital"
        ),
        SubCategoriesModel(
            "پمپ بنزین و سوخت",
            icon = R.drawable.gasstation,
            color = Color(0xffFFF2DA),
            apiCategory = "healthcare.hospital"
        ),
        SubCategoriesModel(
            "کارواش ها",
            icon = R.drawable.carwash,
            color = Color(0xffF2E6FF),
            apiCategory = "healthcare.hospital"
        )
    )

    val hotelList = listOf(
        SubCategoriesModel(
            "هتل ها",
            icon =R.drawable.hotel2,
            color =Color(0xffFFECEC),
            apiCategory = "healthcare.hospital"
        ),
        SubCategoriesModel(
            "مهمانسراها",
            icon = R.drawable.gust,
            color =Color(0xffFFF2DA),
            apiCategory = "healthcare.hospital"
        ),
        SubCategoriesModel(
            "مسافرخانه ها",
            icon = R.drawable.motel,
            color =Color(0xffF2E6FF),
            apiCategory = "healthcare.hospital"
        )
    )


}