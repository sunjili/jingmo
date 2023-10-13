package com.hefengbao.jingmo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.hefengbao.jingmo.data.database.entity.PoemEntity
import com.hefengbao.jingmo.data.database.entity.PoemWithWriterAndTags
import com.hefengbao.jingmo.data.database.model.PoemSimpleInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface PoemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(poemEntity: PoemEntity)

    @Transaction
    @Query("select * from poems where id = :id")
    suspend fun getPoem(id: Long): PoemWithWriterAndTags

    @Query("select id from poems where id > :id order by id asc limit 1")
    suspend fun getNextId(id: Long): Long

    @Query("select id from poems where id < :id order by id desc limit 1")
    suspend fun getPrevId(id: Long): Long

    @Query("select id,writer_name, dynasty, title from poems order by id asc")
    fun getPoemSimpleInfoList(): Flow<List<PoemSimpleInfo>>

    @Query("select id,writer_name, dynasty, title from poems where writer_name like :query or title like :query order by id asc")
    fun searchPoemSimpleInfoList(query: String): Flow<List<PoemSimpleInfo>>
}