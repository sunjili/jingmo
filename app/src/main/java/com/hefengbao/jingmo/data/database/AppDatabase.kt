package com.hefengbao.jingmo.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hefengbao.jingmo.data.database.dao.ChineseKnowledgeDao
import com.hefengbao.jingmo.data.database.dao.ChineseWisecrackDao
import com.hefengbao.jingmo.data.database.dao.IdiomDao
import com.hefengbao.jingmo.data.database.dao.PeopleDao
import com.hefengbao.jingmo.data.database.dao.PoemDao
import com.hefengbao.jingmo.data.database.dao.PoemSentenceDao
import com.hefengbao.jingmo.data.database.dao.PoemTagDao
import com.hefengbao.jingmo.data.database.dao.RiddleDao
import com.hefengbao.jingmo.data.database.dao.TagDao
import com.hefengbao.jingmo.data.database.dao.TongueTwisterDao
import com.hefengbao.jingmo.data.database.dao.WriterDao
import com.hefengbao.jingmo.data.database.dao.WritingDao
import com.hefengbao.jingmo.data.database.entity.ChineseKnowledgeEntity
import com.hefengbao.jingmo.data.database.entity.ChineseWisecrackCollectionEntity
import com.hefengbao.jingmo.data.database.entity.ChineseWisecrackEntity
import com.hefengbao.jingmo.data.database.entity.IdiomCollectionEntity
import com.hefengbao.jingmo.data.database.entity.IdiomEntity
import com.hefengbao.jingmo.data.database.entity.PeopleEntity
import com.hefengbao.jingmo.data.database.entity.PoemEntity
import com.hefengbao.jingmo.data.database.entity.PoemSentenceCollectionEntity
import com.hefengbao.jingmo.data.database.entity.PoemSentenceEntity
import com.hefengbao.jingmo.data.database.entity.PoemTagCrossRef
import com.hefengbao.jingmo.data.database.entity.RiddleEntity
import com.hefengbao.jingmo.data.database.entity.TagEntity
import com.hefengbao.jingmo.data.database.entity.TongueTwisterEntity
import com.hefengbao.jingmo.data.database.entity.WriterEntity
import com.hefengbao.jingmo.data.database.entity.WritingCollectionEntity
import com.hefengbao.jingmo.data.database.entity.WritingEntity
import com.hefengbao.jingmo.data.database.util.DetailInfoListConverter
import com.hefengbao.jingmo.data.database.util.IntListConverter
import com.hefengbao.jingmo.data.database.util.PeopleAliasListConverter
import com.hefengbao.jingmo.data.database.util.PeopleDetailListConverter
import com.hefengbao.jingmo.data.database.util.PeopleHometownListConverter
import com.hefengbao.jingmo.data.database.util.StringListConverter
import com.hefengbao.jingmo.data.database.util.WritingAllusionListConverter
import com.hefengbao.jingmo.data.database.util.WritingClauseListConverter
import com.hefengbao.jingmo.data.database.util.WritingCommentListConverter
import com.hefengbao.jingmo.data.database.util.WritingQuoteListConverter

/**
 *  entities 数组中添加 data class 或其中的 data class 发生任何变化， 先 version + 1, 然后再 Build。
 *  app/schemas 目录下，保存 exportSchema 数据
 */
@Database(
    entities = [
        ChineseKnowledgeEntity::class,
        ChineseWisecrackCollectionEntity::class,
        ChineseWisecrackEntity::class,
        IdiomCollectionEntity::class,
        IdiomEntity::class,
        PeopleEntity::class,
        PoemEntity::class,
        PoemSentenceCollectionEntity::class,
        PoemSentenceEntity::class,
        PoemTagCrossRef::class,
        RiddleEntity::class,
        TagEntity::class,
        TongueTwisterEntity::class,
        WriterEntity::class,
        WritingCollectionEntity::class,
        WritingEntity::class,
    ],
    version = 7,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4),
        AutoMigration(from = 4, to = 5),
        AutoMigration(from = 5, to = 6),
        AutoMigration(from = 6, to = 7),
    ],
    exportSchema = true
)
@TypeConverters(
    DetailInfoListConverter::class,
    IntListConverter::class,
    PeopleAliasListConverter::class,
    PeopleDetailListConverter::class,
    PeopleHometownListConverter::class,
    StringListConverter::class,
    WritingAllusionListConverter::class,
    WritingClauseListConverter::class,
    WritingCommentListConverter::class,
    WritingQuoteListConverter::class,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chineseKnowledgeDao(): ChineseKnowledgeDao
    abstract fun chineseWisecrackDao(): ChineseWisecrackDao
    abstract fun idiomDao(): IdiomDao
    abstract fun peopleDao(): PeopleDao

    @Deprecated("")
    abstract fun poemDao(): PoemDao

    @Deprecated("")
    abstract fun poemTagDao(): PoemTagDao
    abstract fun riddleDao(): RiddleDao

    @Deprecated("")
    abstract fun tagDao(): TagDao
    abstract fun tongueTwisterDao(): TongueTwisterDao
    abstract fun poemSentenceDao(): PoemSentenceDao

    @Deprecated("")
    abstract fun writerDao(): WriterDao
    abstract fun writingDao(): WritingDao
}