package id.ac.unpas.ulasandestinasiwisata2.data

// Review.kt


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val destinationId: UUID,
    val author: String,
    val rate: Float,
    val content: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

