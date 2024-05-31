package id.ac.unpas.ulasandestinasiwisata2.data

// Destination.kt

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "destinations")
data class Destination(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val location: String,
    val price: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)

