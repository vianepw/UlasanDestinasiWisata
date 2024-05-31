package id.ac.unpas.ulasandestinasiwisata2.repository



import id.ac.unpas.ulasandestinasiwisata2.data.Destination
import id.ac.unpas.ulasandestinasiwisata2.data.Review
import id.ac.unpas.ulasandestinasiwisata2.data.TripPlan
import id.ac.unpas.ulasandestinasiwisata2.service.AppDao
import kotlinx.coroutines.flow.Flow
import java.util.*

class TripPlannerRepository(private val appDao: AppDao) {

    val allTripPlans: Flow<List<TripPlan>> = appDao.getAllTripPlans()
    val allDestinations: Flow<List<Destination>> = appDao.getAllDestinations()

    suspend fun insertTripPlan(tripPlan: TripPlan) {
        appDao.insertTripPlan(tripPlan)
    }

    suspend fun insertDestination(destination: Destination) {
        appDao.insertDestination(destination)
    }

    fun getReviewsForDestination(destinationId: UUID): Flow<List<Review>> {
        return appDao.getReviewsForDestination(destinationId)
    }

    suspend fun insertReview(review: Review) {
        appDao.insertReview(review)
    }
}
