import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class FoodRatingsSystemTest {
    private lateinit var foodRatingsSystem: FoodRatingsSystem

    @BeforeEach
    fun setUp() {
        val foods = listOf("tacos", "pizza", "pad thai", "spaghetti", "hot dog", "enchiladas")
        val cuisines = listOf("mexican", "italian", "thai", "italian", "american", "mexican")
        val ratings = listOf(3, 5, 10, 9, 2, 6)

        foodRatingsSystem = FoodRatingsSystem(foods, cuisines, ratings)
    }

    @Test 
    fun testNoMatchingFood() {
        assertEquals("", foodRatingsSystem.highestRatedFood("chinese"))
    }

    @Test
    fun testHighestRatedFoodMexican() {
        assertEquals("enchiladas", foodRatingsSystem.highestRatedFood("mexican"))
    }

    @Test
    fun testHighestRatedFoodItalian() {
        assertEquals("spaghetti", foodRatingsSystem.highestRatedFood("italian"))
    }

    @Test
    fun testChangeFoodRatingMexican() {
        foodRatingsSystem.changeFoodRating("tacos", 10)
        assertEquals("tacos", foodRatingsSystem.highestRatedFood("mexican"))
    }

    @Test
    fun testTiedFoodRatings() {
        foodRatingsSystem.changeFoodRating("spaghetti", 16)
        foodRatingsSystem.changeFoodRating("pizza", 16)
        assertEquals("pizza", foodRatingsSystem.highestRatedFood("italian"))
    }
}
