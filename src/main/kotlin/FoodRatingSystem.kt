import java.util.*

class FoodRatingsSystem(foods: List<String>, cuisines: List<String>, ratings: List<Int>) {
    private val foodMap = mutableMapOf<String, Food>()
    private val cuisineMap = mutableMapOf<String, TreeSet<Food>>()

    init {
        for (i in foods.indices) {
            val food = Food(foods[i], cuisines[i], ratings[i])
            foodMap[foods[i]] = food
            cuisineMap.computeIfAbsent(cuisines[i]) { sortedSetOf() }.add(food)
        }
    }

    fun changeFoodRating(foodName: String, newRating: Int) {
        val food = foodMap[foodName] ?: return
        cuisineMap[food.cuisine]?.remove(food)
        food.rating = newRating
        cuisineMap[food.cuisine]?.add(food)
    }

    fun highestRatedFood(cuisine: String): String {
        return cuisineMap[cuisine]?.first()?.name ?: ""
    }

    data class Food(val name: String, val cuisine: String, var rating: Int) : Comparable<Food> {
        override fun compareTo(other: Food): Int {
            return if (this.rating != other.rating) {
                other.rating - this.rating
            } else {
                this.name.compareTo(other.name)
            }
        }
    }
}