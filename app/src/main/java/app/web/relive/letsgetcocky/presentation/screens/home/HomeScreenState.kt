package app.web.relive.letsgetcocky.presentation.screens.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import app.web.relive.letsgetcocky.R

@Immutable
enum class HomeScreenState(
    @StringRes val title:Int,
    @DrawableRes val icon:Int
) {
    NON_ALCOHOLIC(R.string.non_alcoholic,R.drawable.ic_non_alcoholic),
    ALCOHOLIC(R.string.alcoholic, R.drawable.ic_alcoholic),
    SEARCH(R.string.search, R.drawable.ic_search),
    SAVE(R.string.save, R.drawable.ic_save);
}