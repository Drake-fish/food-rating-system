# Food Ratings System

This project implements a food rating system in Kotlin.

## Features
- Initialize the system with a list of foods, cuisines, and ratings.
- Modify the rating of a food item.
- Return the highest-rated food item for a specific cuisine.

## Explanation of Code
### Initialization (init block):

Iterates through the provided lists to create Food objects.
Populates foodMap with Food objects.
Populates cuisineMap with TreeSet of Food objects. `computeIfAbsent` is used to initialize the TreeSet if it doesn't already exist.

TreeSet's are used here because it will maintain the order of the foods, per cuisine making is super simple and efficient to get the highest rated food, as well as inserting new foods. 

### Change Food Rating (changeFoodRating method):

Retrieves the Food object from foodMap.
Removes it from the TreeSet in cuisineMap.
Updates the rating.
Re-inserts it into the TreeSet to maintain order.

### Get Highest Rated Food (highestRatedFood method):

Retrieves the TreeSet for the specified cuisine.
Returns the first element, which is the highest-rated food due to the ordering defined in Comparable.

### Design Patterns
1. Factory Method (computeIfAbsent): This pattern is used in initializing the TreeSet in cuisineMap.
1. Strategy Pattern (Comparable Implementation): Defines a strategy for comparing Food objects to maintain the sorted order in TreeSet.


### Expanding from in memory to a database
* SQL create a table for foods, each food would have a rating, cuisine, and a name.
   * to update we would just find the food by the name, and update the rating in the database. We could index on name to make lookups more efficent.
   * To get highest rating we could use a SQL query to get the cuisines, and order them by rating desc, and take the first one. Again we could implement indexes on cuisine and ratings, to increase lookup speed.

* NoSQL would follow a similar pattern, using an ORM to update, and get data.

### Tradeoffs
The choice between SQL and NoSQL databases depends on the specific requirements of the application, such as scalability, consistency, and schema flexibility.

* SQL databases offer strong consistency and structured schema, making them suitable for applications with complex transactions. 
* NoSQL databases provide flexibility and scalability, ideal for handling large-scale, unstructured data with high performance needs.

## Setup and Running Tests
1. Ensure you have Java and Kotlin installed.
2. If using Gradle, you can build and test the project using the following commands:
   ```sh
   ./gradlew build
   ./gradlew test