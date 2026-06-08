package ir.company.namadapplication.data

import androidx.compose.ui.graphics.Color
import ir.company.namadapplication.R
import ir.company.namadapplication.data.model.LocationModel
import ir.company.namadapplication.data.model.SubCategoriesModel

object LocationData {

    val locationCategoriesList = listOf(
        LocationModel(1, "سلامت و درمان", R.drawable.hotel2, Color(0xffDCEEFF)),
        LocationModel(2, "تفریح و سرگرمی", R.drawable.mechanic, Color(0xffDFF3E2)),
        LocationModel(
            3,
            "رستوران و کافه",
            R.drawable.restaurant,
            Color(0xffFFE8CC)
        ),
        LocationModel(4, "خدمات خودرو", R.drawable.mechanic, Color(0xffFFF1B8)),
        LocationModel(5, "خرید و بازار", R.drawable.hotel2, Color(0xffE8E3FF)),
        LocationModel(6, "اقامتگاه", R.drawable.hotel, Color(0xffFFDDE8)),
        LocationModel(7, "مجتمع تجاری و بانک", R.drawable.store, Color(0xffD9F5F8)),
        LocationModel(8, "فرهنگی", R.drawable.hotel, Color(0xffF0DFFF)),
        LocationModel(9, "حمل و نقل و پارکینگ", R.drawable.hotel, Color(0xffE7EDF2)),
        LocationModel(10, "خدمات عمومی", R.drawable.hotel, Color(0xffE4F4E4)),
    )

    val locationHospitalList = listOf(
        SubCategoriesModel(
            title = "بیمارستان",
            apiCategory = "hospital",
            icon = R.drawable.hospital,
            color = Color(0xffFFECEC)
        ),
        SubCategoriesModel(
            title = "درمانگاه",
            apiCategory = "clinic",
            icon = R.drawable.hospital,
            color = Color(0xffFFECEC)
        ), SubCategoriesModel(
            title = "مجتمع پزشکی",
            apiCategory = "complex_health",
            icon = R.drawable.hospital,
            color = Color(0xffFFECEC)
        )
    )


    val EntertainmentList = listOf(
        SubCategoriesModel(
            "تفریحی و سرگرمی",
            icon = R.drawable.repairshop,
            color = Color(0xffFFECEC),
            apiCategory = "entertainment"
        ),
        SubCategoriesModel(
            "بوستان",
            icon = R.drawable.gasstation,
            color = Color(0xffFFF2DA),
            apiCategory = "park"
        ),
        SubCategoriesModel(
            "جاذبه طبیعی",
            icon = R.drawable.gasstation,
            color = Color(0xffFFF2DA),
            apiCategory = "feature_natural"
        ),
        SubCategoriesModel(
            "مکان دیدنی",
            icon = R.drawable.gasstation,
            color = Color(0xffFFF2DA),
            apiCategory = "interests"
        ),
        SubCategoriesModel(
            "مکان تاریخی",
            icon = R.drawable.gasstation,
            color = Color(0xffFFF2DA),
            apiCategory = "historical"
        ),
    )

    val RestaurantList = listOf(
        SubCategoriesModel(
            title = "کافیشاپ",
            apiCategory = "cafe",
            icon = R.drawable.restaurant,
            color = Color(0xffFFECEC),
        ),
        SubCategoriesModel(
            title = "رستوران",
            apiCategory = "restaurant",
            icon = R.drawable.cafe,
            color = Color(0xffFFF2DA),
        ),
        SubCategoriesModel(
            title = "کافه رستوران",
            apiCategory = "restaurant_cafe",
            icon = R.drawable.cafe,
            color = Color(0xffFFF2DA),
        ),
        SubCategoriesModel(
            title = "آبمیوه و بستنی",
            apiCategory = "shop_juice",
            icon = R.drawable.cafe,
            color = Color(0xffFFF2DA),
        ),
    )

    val CarServiceList = listOf(
        SubCategoriesModel(
            "نمایندگی خودرو",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "car_dealer_official"
        ),
        SubCategoriesModel(
            "معاینه فنی",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "inspection_car"
        ),
    )


    val entertainmentCentersList = listOf(
        SubCategoriesModel(
            "بازار و مرکز خرید",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "shopping_mall"
        ),
        SubCategoriesModel(
            "بازار روز و میوه تره بار",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "vegetable_market"
        )
    )


    val HotelList = listOf(
        SubCategoriesModel(
            "هتل",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "hotel"
        ),
        SubCategoriesModel(
            "مهمانپذیر و پانسیون",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "lodging"
        )
    )


    val CommercialList = listOf(
        SubCategoriesModel(
            "بانک",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "hotel"
        ),
        SubCategoriesModel(
            "موسسه اعتباری",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "lodging"
        )
    )


    val CulturalList = listOf(
        SubCategoriesModel(
            "مسجد",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "mosque"
        ),
        SubCategoriesModel(
            "کتابخانه",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "library"
        ),
        SubCategoriesModel(
            "مدرسه",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "formal_school"
        ),
    )


    val TransportList = listOf(
        SubCategoriesModel(
            "پارکینگ",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "parking"
        ),
        SubCategoriesModel(
            "ایستگاه قطار",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "station_train"
        )
    )


    val PublicServicesList = listOf(
        SubCategoriesModel(
            "اداره پست",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "shopping_mall"
        ),
        SubCategoriesModel(
            "پلیس راهنمایی و رانندگی",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "foreign_consulate"
        )
    )


}