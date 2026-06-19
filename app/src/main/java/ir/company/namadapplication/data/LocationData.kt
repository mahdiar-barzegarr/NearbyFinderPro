package ir.company.namadapplication.data

import androidx.compose.ui.graphics.Color
import ir.company.namadapplication.R
import ir.company.namadapplication.data.model.LocationModel
import ir.company.namadapplication.data.model.SubCategoriesModel

object LocationData {

    val locationCategoriesList = listOf(
        LocationModel(
            1, "سلامت و درمان", R.drawable.hospital, color = Color(0xffDCEEFF),
            listOf(
                Color(0xffA9C9E8),
                Color(0xffDCEEFF),
                Color(0xFFFFFFFF),
                Color(0xffF3F9FF),
                Color(0xffC7E0F5)
            )
        ),
        LocationModel(
            2, "تفریح و سرگرمی", R.drawable.entertainment, Color(0xffDFF3E2),
            listOf(
                Color(0xffB9DDBF),
                Color(0xffDFF3E2),
                Color(0xFFFFFFFF),
                Color(0xffF3FBF4),
                Color(0xffCDE8D3)
            )
        ),
        LocationModel(
            3,
            "رستوران و کافه",
            R.drawable.restaurant,
            Color(0xffFFE8CC),
            listOf(
                Color(0xffF2C48A),
                Color(0xffFFE8CC),
                Color(0xFFFFFFFF),
                Color(0xffFFF7ED),
                Color(0xffFFD9A8)
            )
        ),
        LocationModel(
            4, "خدمات خودرو", R.drawable.mechanic, Color(0xffFFF1B8),
            listOf(
                Color(0xffE6D37A),
                Color(0xffFFF1B8),
                Color(0xFFFFFFFF),
                Color(0xffFFFBE0),
                Color(0xffFFE98A)
            )
        ),
        LocationModel(
            5, "خرید و بازار", R.drawable.store, Color(0xFFFFE2EF),
            listOf(
                Color(0xffF2AFC9),
                Color(0xffffe2ef),
                Color(0xFFFFFFFF),
                Color(0xfffff3f8),
                Color(0xffFFC7DD)
            )
        ),
        LocationModel(
            6, "اقامتگاه", R.drawable.hotel, Color(0xffE8E3FF),
            listOf(
                Color(0xffB8AEEA),
                Color(0xffE8E3FF),
                Color(0xFFFFFFFF),
                Color(0xffF6F4FF),
                Color(0xffD3CCFF)
            )
        ),
        LocationModel(
            7, "مجتمع تجاری و بانک", R.drawable.bank, Color(0xFFFCD2E1),
            listOf(
                Color(0xffF2A0B8),
                Color(0xFFFCD2E1),
                Color(0xFFFFFFFF),
                Color(0xffFFF0F5),
                Color(0xffF8B9CC)
            )
        ),
        LocationModel(
            8, "فرهنگی", R.drawable.culture, Color(0xffF0DFFF),
            listOf(
                Color(0xffCBB3E8),
                Color(0xffF0DFFF),
                Color(0xFFFFFFFF),
                Color(0xffFAF5FF),
                Color(0xffDCC7F5)
            )
        ),
        LocationModel(
            9, "حمل و نقل و پارکینگ", R.drawable.car, Color(0xffE7EDF2),
            listOf(
                Color(0xffB7C6D1),
                Color(0xffE7EDF2),
                Color(0xFFFFFFFF),
                Color(0xffF6F9FB),
                Color(0xffD2DCE5)
            )
        ),
        LocationModel(
            10, "خدمات عمومی", R.drawable.school, Color(0xffE4F4E4),
            listOf(
                Color(0xffBFDDBF),
                Color(0xffE4F4E4),
                Color(0xFFFFFFFF),
                Color(0xffF1FAF1),
                Color(0xffD6EED6)
            )
        ),
    )

    val locationHospitalList = listOf(
        SubCategoriesModel(
            title = "بیمارستان",
            apiCategory = "hospital",
            icon = R.drawable.hospital,
            color = Color(0xffEAF4FF)
        ),
        SubCategoriesModel(
            title = "درمانگاه",
            apiCategory = "clinic",
            icon = R.drawable.clinic,
            color = Color(0xffD9EBFF)
        ), SubCategoriesModel(
            title = "مجتمع پزشکی",
            apiCategory = "health_complex",
            icon = R.drawable.apartment,
            color = Color(0xffC8E2FF)
        )
    )


    val EntertainmentList = listOf(
        SubCategoriesModel(
            "تفریحی و سرگرمی",
            icon = R.drawable.entertainment,
            color = Color(0xffEAF8EC),
            apiCategory = "entertainment"
        ),
        SubCategoriesModel(
            "بوستان",
            icon = R.drawable.park,
            color = Color(0xffDDF3E0),
            apiCategory = "park"
        ),
        SubCategoriesModel(
            "جاذبه طبیعی",
            icon = R.drawable.landscape,
            color = Color(0xffCFEED3),
            apiCategory = "natural_feature"
        ),
        SubCategoriesModel(
            "مکان دیدنی",
            icon = R.drawable.scenic,
            color = Color(0xffC2E9C7),
            apiCategory = "interests"
        ),
        SubCategoriesModel(
            "مکان تاریخی",
            icon = R.drawable.church,
            color = Color(0xffB4E4BA),
            apiCategory = "historical"
        ),
    )

    val RestaurantList = listOf(
        SubCategoriesModel(
            title = "کافیشاپ",
            apiCategory = "cafe",
            icon = R.drawable.cafe,
            color = Color(0xffFFF2DD),
        ),
        SubCategoriesModel(
            title = "رستوران",
            apiCategory = "restaurant",
            icon = R.drawable.restaurant,
            color = Color(0xffFFE9C7),
        ),
        SubCategoriesModel(
            title = "کافه رستوران",
            apiCategory = "cafe_restaurant",
            icon = R.drawable.cafe1,
            color = Color(0xffFFE0B1),
        ),
        SubCategoriesModel(
            title = "آبمیوه و بستنی",
            apiCategory = "juice_shop",
            icon = R.drawable.icecream,
            color = Color(0xffFFD79B),
        ),
    )

    val CarServiceList = listOf(
        SubCategoriesModel(
            "نمایندگی خودرو",
            icon = R.drawable.repairshop,
            color = Color(0xFFFFF3CE),
            apiCategory = "car_dealer_official"
        ),
        SubCategoriesModel(
            "معاینه فنی",
            icon = R.drawable.warranty,
            color = Color(0xffFFF2B8),
            apiCategory = "car_inspection"
        ),
    )


    val entertainmentCentersList = listOf(
        SubCategoriesModel(
            "بازار و مرکز خرید",
            icon = R.drawable.supermarket1,
            color = Color(0xffFFF9D9),
            apiCategory = "shopping_mall"
        ),
        SubCategoriesModel(
            "بازار روز و میوه تره بار",
            icon = R.drawable.stand,
            color = Color(0xffFFF2B8),
            apiCategory = "vegetable_market"
        )
    )


    val HotelList = listOf(
        SubCategoriesModel(
            "هتل",
            icon = R.drawable.hotel2,
            color = Color(0xffEEE9FF),
            apiCategory = "hotel"
        ),
        SubCategoriesModel(
            "مهمانپذیر و پانسیون",
            icon = R.drawable.gust,
            color = Color(0xffE0D7FF),
            apiCategory = "lodging"
        )
    )


    val CommercialList = listOf(
        SubCategoriesModel(
            "بانک",
            icon = R.drawable.bank,
            color = Color(0xffFFE7F0),
            apiCategory = "bank"
        ),
        SubCategoriesModel(
            "موسسه اعتباری",
            icon = R.drawable.bank1,
            color = Color(0xffFFD6E7),
            apiCategory = "lodging"
        )
    )


    val CulturalList = listOf(
        SubCategoriesModel(
            "مسجد",
            icon = R.drawable.mosque,
            color = Color(0xffF6EBFF),
            apiCategory = "mosque"
        ),
        SubCategoriesModel(
            "کتابخانه",
            icon = R.drawable.book,
            color = Color(0xffEEDCFF),
            apiCategory = "library"
        ),
        SubCategoriesModel(
            "مدرسه",
            icon = R.drawable.education,
            color = Color(0xffE5CDFF),
            apiCategory = "formal_school"
        ),
    )


    val TransportList = listOf(
        SubCategoriesModel(
            "پارکینگ",
            icon = R.drawable.parking,
            color = Color(0xffF1F4F6),
            apiCategory = "parking"
        )
    )


    val PublicServicesList = listOf(
        SubCategoriesModel(
            "اداره پست",
            icon = R.drawable.postalservice,
            color = Color(0xffF0FAF0),
            apiCategory = "shopping_mall"
        ),
        SubCategoriesModel(
            "پلیس راهنمایی و رانندگی",
            icon = R.drawable.policestation,
            color = Color(0xFFE0FDE0),
            apiCategory = "foreign_consulate"
        )
    )


}