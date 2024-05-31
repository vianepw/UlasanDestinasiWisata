package id.ac.unpas.ulasandestinasiwisata2.service



import androidx.room.*
import id.ac.unpas.ulasandestinasiwisata2.data.Destination
import id.ac.unpas.ulasandestinasiwisata2.data.Review
import id.ac.unpas.ulasandestinasiwisata2.data.TripPlan
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface AppDao {
    @Query("SELECT * FROM trip_plans")
    fun getAllTripPlans(): Flow<List<TripPlan>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTripPlan(tripPlan: TripPlan)

    @Query("SELECT * FROM destinations")
    fun getAllDestinations(): Flow<List<Destination>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: Destination)

    @Query("SELECT * FROM reviews WHERE destinationId = :destinationId")
    fun getReviewsForDestination(destinationId: UUID): Flow<List<Review>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(review: Review)
}
