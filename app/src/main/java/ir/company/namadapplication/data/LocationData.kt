package ir.company.namadapplication.data

import androidx.compose.ui.graphics.Color
import ir.company.namadapplication.R
import ir.company.namadapplication.data.model.LocationModel
import ir.company.namadapplication.data.model.SubCategoriesModel

object LocationData {

    val locationCategoriesList = listOf(
        LocationModel(1, "مراکز درمانی", R.drawable.hospital, Color(0xffE4F1FF)),
        LocationModel(2, "خدمات خودرو و سوخت", R.drawable.supermarket, Color(0xffE8F9E9)),
        LocationModel(3, "رستوران\u200Cها و کافه\u200Cها", R.drawable.restaurant, Color(0xffFFF2DA)),
        LocationModel(4, "سوپرمارکت و فروشگاه\u200Cها", R.drawable.mechanic, Color(0xffF2E6FF)),
        LocationModel(5, "هتل ها و مسافرخانه ها", R.drawable.hotel, Color(0xffFFECEC)),
    )

    val locationHospitalList = listOf(
        SubCategoriesModel(1, "بیمارستان ها", R.drawable.hospital2, Color(0xffFFECEC)),
        SubCategoriesModel(2, "داروخانه ها", R.drawable.drugstore, Color(0xffFFF2DA)),
        SubCategoriesModel(3, "آزمایشگاه ها", R.drawable.laboratory, Color(0xffF2E6FF)),
        SubCategoriesModel(4, "کلینیک های پزشکی", R.drawable.clinic, Color(0xffE4F1FF))
    )

    val supermarketList = listOf(
        SubCategoriesModel(1, "هایپرمارکت ها", R.drawable.supermarket1, Color(0xffFFF2DA)),
        SubCategoriesModel(2, "سوپرمارکت ها", R.drawable.store, Color(0xffE8F9E9)),
        SubCategoriesModel(3, "فروشگاه های پروتئینی", R.drawable.proteins, Color(0xffF2E6FF))
    )

    val restaurantList = listOf(
        SubCategoriesModel(1, "رستوران ها", R.drawable.restaurant2, Color(0xffFFECEC)),
        SubCategoriesModel(2, "کافه ها", R.drawable.cafe, Color(0xffFFF2DA)),
        SubCategoriesModel(3, "فست فودها", R.drawable.fastfood, Color(0xffF2E6FF))
    )

    val carServiceList = listOf(
        SubCategoriesModel(1, "تعمیرگاه ها", R.drawable.repairshop, Color(0xffFFECEC)),
        SubCategoriesModel(2, "پمپ بنزین و سوخت", R.drawable.gasstation, Color(0xffFFF2DA)),
        SubCategoriesModel(3, "کارواش ها", R.drawable.carwash, Color(0xffF2E6FF))
    )

    val hotelList = listOf(
        SubCategoriesModel(1, "هتل ها", R.drawable.hotel2, Color(0xffFFECEC)),
        SubCategoriesModel(2, "مهمانسراها", R.drawable.gust, Color(0xffFFF2DA)),
        SubCategoriesModel(3, "مسافرخانه ها", R.drawable.motel, Color(0xffF2E6FF))
    )


}