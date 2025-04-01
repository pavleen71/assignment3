package com.example.woofapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

data class tips(
    @DrawableRes val imageResourceId: Int,
    @StringRes val tip : Int,
    val day: Int,
    @StringRes val explain:Int
)
val fitnessTips = listOf(
    tips(R.drawable.day1, R.string.tip1, 1, R.string.explain1),
    tips(R.drawable.day2, R.string.tip2, 2, R.string.explain2),
    tips(R.drawable.day3, R.string.tip3, 3, R.string.explain3),
    tips(R.drawable.day4, R.string.tip4, 4, R.string.explain4),
    tips(R.drawable.day5, R.string.tip5, 5, R.string.explain5),
    tips(R.drawable.day6, R.string.tip6, 6, R.string.explain6),
    tips(R.drawable.day7, R.string.tip7, 7, R.string.explain7),
    tips(R.drawable.day8, R.string.tip8, 8, R.string.explain8),
    tips(R.drawable.day9, R.string.tip9, 9, R.string.explain9),
    tips(R.drawable.day10, R.string.tip10, 10, R.string.explain10),
    tips(R.drawable.day11, R.string.tip11, 11, R.string.explain11),
    tips(R.drawable.day12, R.string.tip12, 12, R.string.explain12),
    tips(R.drawable.day13, R.string.tip13, 13, R.string.explain13),
    tips(R.drawable.day14, R.string.tip14, 14, R.string.explain14),
    tips(R.drawable.day15, R.string.tip15, 15, R.string.explain15),
    tips(R.drawable.day16, R.string.tip16, 16, R.string.explain16),
    tips(R.drawable.day17, R.string.tip17, 17, R.string.explain17),
    tips(R.drawable.day18, R.string.tip18, 18, R.string.explain18),
    tips(R.drawable.day19, R.string.tip19, 19, R.string.explain19),
    tips(R.drawable.day20, R.string.tip20, 20, R.string.explain20),
    tips(R.drawable.day21, R.string.tip21, 21, R.string.explain21),
    tips(R.drawable.day22, R.string.tip22, 22, R.string.explain22),
    tips(R.drawable.day23, R.string.tip23, 23, R.string.explain23),
    tips(R.drawable.day24, R.string.tip24, 24, R.string.explain24),
    tips(R.drawable.day25, R.string.tip25, 25, R.string.explain25),
    tips(R.drawable.day26, R.string.tip26, 26, R.string.explain26),
    tips(R.drawable.day27, R.string.tip27, 27, R.string.explain27),
    tips(R.drawable.day28, R.string.tip28, 28, R.string.explain28),
    tips(R.drawable.day29, R.string.tip29, 29, R.string.explain29),
    tips(R.drawable.day30, R.string.tip30, 30, R.string.explain30)
)