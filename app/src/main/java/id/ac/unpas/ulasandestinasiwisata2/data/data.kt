package id.ac.unpas.ulasandestinasiwisata2.data

// TripPlan.kt


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "trip_plans")
data class TripPlan(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val destinationId: UUID,
    val visitDate: Date,
    val notes: String?,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
