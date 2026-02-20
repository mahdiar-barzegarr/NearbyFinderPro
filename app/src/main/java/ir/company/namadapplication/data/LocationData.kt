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
            "خدمات مالی و بانکی",
            R.drawable.restaurant,
            Color(0xffFFF2DA)
        ),
        LocationModel(4, "خوراک و خرید روزمره", R.drawable.hotel, Color(0xffFFECEC)),
        LocationModel(5, "حمل\u200Cونقل عمومی", R.drawable.hotel, Color(0xffFFF4E6)),
        LocationModel(6, "مراکز خرید و تفریح", R.drawable.hotel, Color(0xffFFF0F6)),
    )

    val locationHospitalList = listOf(
        SubCategoriesModel(
            title = "بیمارستان",
            apiCategory = "hospital",
            icon = R.drawable.hospital,
            color = Color(0xffFFECEC)
        ),
        SubCategoriesModel(
            title = "داروخانه",
            apiCategory = "pharmacy",
            icon = R.drawable.drugstore,
            color = Color(0xffFFF2DA)
        )
    )


    val carServiceList = listOf(
        SubCategoriesModel(
            "تعمیرگاه و خدمات خودرو",
            icon = R.drawable.repairshop,
            color = Color(0xffFFECEC),
            apiCategory = "car_repair"
        ),
        SubCategoriesModel(
            "پمپ بنزین و سوخت",
            icon = R.drawable.gasstation,
            color = Color(0xffFFF2DA),
            apiCategory = "gas_station"
        )
    )

    val Bank = listOf(
        SubCategoriesModel(
            title = "بانک",
            apiCategory = "bank",
            icon = R.drawable.restaurant,
            color = Color(0xffFFECEC),
        ),
        SubCategoriesModel(
            title = "خودپرداز",
            apiCategory = "atm",
            icon = R.drawable.cafe,
            color = Color(0xffFFF2DA),
        )
    )

    val hotelList = listOf(
        SubCategoriesModel(
            "رستوران",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "restaurant"
        ),
        SubCategoriesModel(
            "کافیشاپ",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "cafe"
        ),
        SubCategoriesModel(
            "سوپرمارکت و هایپرمارکت",
            icon = R.drawable.hotel2,
            color = Color(0xffE8FFF8),
            apiCategory = "supermarket"
        ),
        SubCategoriesModel(
            "فروشگاه مواد غذایی",
            icon = R.drawable.hotel2,
            color = Color(0xffF3E8FF),
            apiCategory = "convenience_store"
        ),
        SubCategoriesModel(
            "فروشگاه زنجیره\u200Cای",
            icon = R.drawable.hotel2,
            color = Color(0xffFFF0F6),
            apiCategory = "department_store"
        ),
        SubCategoriesModel(
            "میوه و سبزی فروشی",
            icon = R.drawable.hotel2,
            color = Color(0xffFFF4E6),
            apiCategory = "greengrocer"
        ),
    )


    val transportationList = listOf(
        SubCategoriesModel(
            "ایستگاه مترو",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "subway_station"
        ),
        SubCategoriesModel(
            "ایستگاه اتوبوس",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "bus_station"
        ),
        SubCategoriesModel(
            "پایانه مسافربری و ایستگاه سوار",
            icon = R.drawable.hotel2,
            color = Color(0xffE8FFF8),
            apiCategory = "transit_station"
        )
    )



    val entertainmentCentersList = listOf(
        SubCategoriesModel(
            "بازار و مرکز خرید",
            icon = R.drawable.hotel2,
            color = Color(0xffFFECEC),
            apiCategory = "shopping_mall"
        ),
        SubCategoriesModel(
            "مجتمع تجاری اداری",
            icon = R.drawable.gust,
            color = Color(0xffFFF2DA),
            apiCategory = "commercial_complex"
        ),
        SubCategoriesModel(
            "بازار",
            icon = R.drawable.hotel2,
            color = Color(0xffE8FFF8),
            apiCategory = "market_handicraft"
        ),
        SubCategoriesModel(
            "پارک",
            icon = R.drawable.hotel2,
            color = Color(0xffFFF4E6),
            apiCategory = "park"
        ),
        SubCategoriesModel(
            "سالن و پردیس سینمایی",
            icon = R.drawable.hotel2,
            color = Color(0xffFFF0F6),
            apiCategory = "cinema"
        ),
        SubCategoriesModel(
            "جاذبه\u200Cهای گردشگری",
            icon = R.drawable.hotel2,
            color = Color(0xffEFFFFF),
            apiCategory = "natural_feature"
        )
    )


}