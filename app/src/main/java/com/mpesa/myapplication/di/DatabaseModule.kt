//// di/DatabaseModule.kt
//import android.app.Application
//import androidx.room.Room
//import com.mpesa.myapplication.data.AppDatabase
//import com.mpesa.myapplication.data.TransferDao
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DatabaseModule {
//    @Provides
//    @Singleton
//    fun provideDatabase(application: Application): AppDatabase {
//        return Room.databaseBuilder(
//            application,
//            AppDatabase::class.java,
//            "mpesa-database"
//        )
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Provides
//    fun provideTransferDao(database: AppDatabase): TransferDao {
//        return database.transferDao()
//    }
//}