package id.ac.unpas.ulasandestinasiwisata2.viewmodel

// TripPlansScreen.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.unpas.ulasandestinasiwisata2.data.Destination
import id.ac.unpas.ulasandestinasiwisata2.data.Review
import id.ac.unpas.ulasandestinasiwisata2.data.TripPlan
import id.ac.unpas.ulasandestinasiwisata2.repository.TripPlannerRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class TripPlannerViewModel(private val repository: TripPlannerRepository) : ViewModel() {

    val allTripPlans: StateFlow<List<TripPlan>> = repository.allTripPlans.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val allDestinations: StateFlow<List<Destination>> = repository.allDestinations.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun getReviewsForDestination(destinationId: UUID): StateFlow<List<Review>> =
        repository.getReviewsForDestination(destinationId).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertTripPlan(tripPlan: TripPlan) {
        viewModelScope.launch {
            repository.insertTripPlan(tripPlan)
        }
    }

    fun insertDestination(destination: Destination) {
        viewModelScope.launch {
            repository.insertDestination(destination)
        }
    }

    fun insertReview(review: Review) {
        viewModelScope.launch {
            repository.insertReview(review)
        }
    }
}
