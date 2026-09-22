# Smart Pantry Manager Development Notes

## Commit 1 (my initial creation and git repo opening)

### Objective

Create project foundation and configure source control.

### created the startup 
- Android project created
- Emulator verified (made the pixel 8 one)
- Git repository initialized
- GitHub connected, linked and also initial push
- README created and also this dev path doc summary


## Commit 2 (making the classes and constructors for a recipy)
Created the application's domain model classes.
### Files created so far (Completed)

* PantryItem class
* Recipe class
* RecipeIngredient class

## Commit 3 (made the DB helper and CRUD functions)
Created SQLite DB and pantry/ingredients CRUD operations.
### Files created next
DatabaseHelper.java : 
- DatabaseHelper created
- SQLite database created
- Pantry table created
- THEN CRUD :
  * Create operation implemented
  * Read operation implemented
  * Update operation implemented
  * Delete operation implemented

## Commit 4 (extending the DB part to take and retrive recipies)
### Objective fo this part achieved was
Extend SQLite to support recipes and recipe ingredients.
### files changes by me on this commit or added
- Recipes table added to DBhelper
- Recipe ingredients table added to DBhelper
- Seed data mechanism added 
- 3 starter recipes inserted for now
- Recipe retrieval methods implemented and checked

## Commit 5 (added the first UI xml data for a simple nested view)
### Objective
Build the Pantry List user interface to display the items in the 
recyclerview. Using both contraint and linear view placements

### Completed

- activity_main.xml
- item_pantry.xml
- PantryAdapter.java
- RecyclerView implemented
- Empty pantry message implemented
- Pantry loaded from SQLite

