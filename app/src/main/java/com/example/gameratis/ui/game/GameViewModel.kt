package com.example.gameratis.ui.game

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.gameratis.data.remote.GameRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@SuppressLint("ParcelCreator")
@Suppress("DEPRECATION")
class GameViewModel @AssistedInject @ViewModelInject constructor(private val repository: GameRepository,
 @Assisted state: SavedStateHandle
) : ViewModel(), Parcelable {

    companion object{
        private const val PLATFORM_QUERY = "platform_query"
        private const val CATEGORY_QUERY = "category_query"
        private const val SORTBY_QUERY = "sortby_query"
        private const val EMPTY_QUERY = ""

    }
    private val platformQuery = state.getLiveData(PLATFORM_QUERY, EMPTY_QUERY)
    private val categoryQuery = state.getLiveData(CATEGORY_QUERY, EMPTY_QUERY)
    private val sortbyQuery = state.getLiveData(SORTBY_QUERY, EMPTY_QUERY)

    val games = platformQuery.switchMap { platform ->
        categoryQuery.switchMap { category ->
            sortbyQuery.switchMap { sortBy ->
                if (!sortBy.isEmpty() || !category.isEmpty() || !platform.isEmpty()){
                    repository.getSearchGames(platform, category, sortBy)
                }else {
                    repository.getPosts()
                }
            }
        }
    }

    fun searchGames(platfrom: String, category: String, sortBy: String){
        platformQuery.value = platfrom
        categoryQuery.value = category
        sortbyQuery.value = sortBy
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

}


















//
//
//import androidx.hilt.Assisted
//import androidx.hilt.lifecycle.ViewModelInject
//import androidx.lifecycle.MediatorLiveData
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.asFlow
//import androidx.lifecycle.asLiveData
//import androidx.lifecycle.liveData
//import androidx.lifecycle.switchMap
//import androidx.room.util.query
//import com.example.gameratis.data.remote.GameRepository
//import retrofit2.http.Query
//
//@Suppress("DEPRECATION")
//class GameViewModel @ViewModelInject constructor(
//    private val repository: GameRepository,
//    @Assisted state: SavedStateHandle
//) : ViewModel() {
//
//    companion object{
////        private const val CURRENT_QUERY = "current_query"
////        private const val EMPTY_QUERY = ""
//
//        private const val PLATFORM_QUERY = "platform_query"
//        private const val CATEGORY_QUERY = "category_query"
//        private const val SORTBY_QUERY = "sortby_query"
//
//    }
//    private val platformQuery = state.getLiveData<String?>(PLATFORM_QUERY, null)
//    private val categoryQuery = state.getLiveData<String?>(CATEGORY_QUERY, null)
//    private val sortByQuery = state.getLiveData<String?>(SORTBY_QUERY, null)
//
//    // mengabungkan 3 query kedalam satu mediaQuery
//    private val queryParameters = MediatorLiveData<Triple<String?, String?, String?>>().apply {
//        addSource(platformQuery) { value = Triple(it, categoryQuery.value, sortByQuery.value) }
//        addSource(categoryQuery) { value = Triple(platformQuery.value, it, sortByQuery.value) }
//        addSource(sortByQuery) { value = Triple(platformQuery.value, categoryQuery.value, it) }
//    }
//
//    val games = queryParameters.switchMap { (platform, category, sortBy) ->
//        liveData {
//            if (platform != null || category != null || sortBy != null) {
//                repository.getSearchGames(platform, category, sortBy).collect{
//                    emit(it)
//                }
//            } else {
//                repository.getPosts().collect{
//                    emit(it)
//                }
//
//            }
//        }
//    }
//
////    val games = platformQuery.switchMap { platform ->
////        categoryQuery.switchMap { category ->
////            sortByQuery.switchMap { sortBy ->
////                if (platform != null || category != null || sortBy != null) {
////                    return@switchMap repository.getSearchGames(platform, category, sortBy)
////                } else {
////                    return@switchMap repository.getPosts()
////                }
////            }
////        }
////    }
//
//    fun searchGames(platform: String?, category: String?, sortBy: String?){
//        platformQuery.value = platform as Nothing?
//        categoryQuery.value = category as Nothing?
//        sortByQuery.value = sortBy as Nothing?
//    }
//
////    val games = repository.getPosts()
//}
//
//
