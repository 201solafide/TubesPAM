package com.example.gameratis.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class GamePagingSource(
    private val gameAPI: GameAPI,
    private val platform: String?,
    private val category: String?,
    private val sortBy: String?,

) : PagingSource<Int, GameRatis>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameRatis> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response =
                if (platform != null || category != null || sortBy != null) {
                    gameAPI.getSearch(
                        platform = platform ?: "",
                        category = category ?: "",
                        sortBy = sortBy ?: ""
                    )
                } else {
                    gameAPI.getPosts(position)
                }

            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: retrofit2.HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GameRatis>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}