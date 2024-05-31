package id.ac.unpas.ulasandestinasiwisata2.service

import androidx.databinding.adapters.Converters
import id.ac.unpas.ulasandestinasiwisata2.data.Destination
import id.ac.unpas.ulasandestinasiwisata2.data.Review
import id.ac.unpas.ulasandestinasiwisata2.data.TripPlan


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TripPlan::class, Destination::class, Review::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "trip_planner_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
