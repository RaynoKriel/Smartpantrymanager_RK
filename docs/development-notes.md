# Smart Pantry Manager Development Notes
## Commit 1 (Project Setup)
Create the project foundation and 
configure source control.

### Created the startup and setup of the app and Github

- Android Studio project created.
- Pixel 8 emulator created and verified.
- Git repository initialized.
- GitHub repository created and linked.
- Initial repository push completed.
- README created.
- Development notes document created.

---

## Commit 2 (Domain Model Classes)
Create the application's domain model classes and 
constructors.

### Files created

- `PantryItem.java`
- `Recipe.java`
- `RecipeIngredient.java`

### The first three models designed

- Created the `PantryItem` model for ingredients stored in the user's pantry.
- Created the `Recipe` model for recipe names, preparation steps, and ingredient collections.
- Created the `RecipeIngredient` model for ingredients required by recipes.
- Added constructors, fields, getters, and setters.

---

## Commit 3 (SQLite Database Helper and Pantry CRUD)
Create the SQLite database and pantry CRUD operations.

### Files created

- `DatabaseHelper.java`

### Original DB creation and First CRUD tables

- Created the SQLite database helper.
- Created the pantry table.
- Implemented the Create operation for pantry records.
- Implemented the Read operations for all pantry records and individual records.
- Implemented the Update operation for existing pantry records.
- Implemented the Delete operation for pantry records.
- Verified that the database was created when the app launched.

---

## Commit 4 (Recipe Database Layer)
Extend SQLite to support recipes and 
recipe ingredients.

### Files added or updated

- `DatabaseHelper.java`
- `RecipeSeedData.java`

### Updated the database to hold recipies as well.

- Added the recipes table to the database.
- Added the recipe ingredients table to the database.
- Added the relationship between recipes and their required ingredients.
- Added the recipe seed-data mechanism.
- Added three starter recipes for initial testing.
- Implemented methods for retrieving recipes from SQLite.
- Verified that three recipes were inserted and retrieved successfully.

---

## Commit 5 (Pantry List User Interface)
Build the Pantry List user interface and 
display pantry records in a RecyclerView.

### Files added or updated

- `activity_main.xml`
- `item_pantry.xml`
- `PantryAdapter.java`
- `MainActivity.java`

### Completed the main screens for ingredients

- Created the main pantry screen with ConstraintLayout.
- Created the individual pantry row with LinearLayout.
- Implemented the pantry RecyclerView.
- Implemented the custom `PantryAdapter` and ViewHolder.
- Connected pantry data from SQLite to the RecyclerView.
- Added an empty-pantry message.
- Added the Floating Action Button as the future entry point for adding ingredients.

---

## Commit 6 (Add Ingredient and Create Operation)
Implement the Add Ingredient screen and 
the Create part of CRUD.

### Files added or updated

- `activity_add_edit_ingredient.xml`
- `AddEditIngredientActivity.java`
- `arrays.xml`
- `strings.xml`
- `AndroidManifest.xml`
- `MainActivity.java`

### Completed the first 2 CRUD functions

- Created the Add Ingredient form.
- Added fields for ingredient name and quantity.
- Added a Spinner with predefined units.
- Added input validation for required fields and valid quantities.
- Connected the Save button to the SQLite insert method.
- Connected the Floating Action Button to the Add Ingredient screen with an Intent.
- Used `onResume()` to refresh the pantry list after returning to the main screen.
- Verified that newly added ingredients appeared in the RecyclerView.

---

## Commit 7 (Edit and Delete Pantry Items)
Complete the Update and Delete parts of CRUD.

### Files updated

- `MainActivity.java`
- `PantryAdapter.java`
- `AddEditIngredientActivity.java`
- `activity_add_edit_ingredient.xml`
- `strings.xml`

### Completed the additional 2 CRUD processes

- Made RecyclerView pantry rows clickable.
- Passed the selected pantry item ID through an Intent extra.
- Reused `AddEditIngredientActivity` for both Add and Edit modes.
- Loaded an existing pantry record into the form.
- Implemented SQLite Update functionality.
- Added a Delete button for Edit mode.
- Implemented SQLite Delete functionality.
- Added confirmation and feedback messages.
- Added back navigation for the Add/Edit screen.
- Verified a full Create, Read, Update, and Delete cycle.

---

## Commit 8 (Strict Recipe Matching and Suggested Recipes)
Implement the application's core strict-matching rule 
and the Suggested Recipes screen.

### Files added or updated

- `MatchingUtils.java`
- `RecipeAdapter.java`
- `SuggestedRecipesActivity.java`
- `activity_suggested_recipes.xml`
- `item_recipe.xml`
- `DatabaseHelper.java`
- `AndroidManifest.xml`

### Functionality implemented on this part.

- Added a method to retrieve recipe ingredients from SQLite.
- Updated recipe retrieval methods to attach ingredients to each recipe object.
- Implemented ingredient-name normalization.
- Implemented the strict recipe-matching algorithm.
- Required every recipe ingredient to exist in sufficient quantity before showing a recipe.
- Created the Suggested Recipes RecyclerView and custom adapter.
- Added a message for situations where no recipes match the pantry.
- Verified that a recipe appeared when all ingredients were present.
- Verified that the recipe disappeared when a required ingredient was removed.

---

## Commit 9 (Toolbar Navigation and Settings)
Add shared application navigation 
and the Settings screen for toggling checks.

### Files added or updated

- `BaseNavActivity.java`
- `SettingsActivity.java`
- `activity_settings.xml`
- `nav_menu.xml`
- `themes.xml`
- `MainActivity.java`
- `SuggestedRecipesActivity.java`
- `AndroidManifest.xml`

### Completed the sections below

- Created a shared `BaseNavActivity` for reusable navigation logic.
- Added a toolbar overflow menu.
- Added navigation between Pantry, Suggested Recipes, and Settings.
- Changed the application theme to display the ActionBar.
- Added screen titles.
- Added back navigation to Settings and Suggested Recipes.
- Added the expiry-alert toggle to the Settings screen.
- Corrected layout spacing so content was not hidden by the toolbar.
- Moved the Floating Action Button higher for devices with bottom navigation controls.

---

## Commit 10 (Recipe Detail Screen)
Added the required Recipe Detail screen to view steps etc.

### Files added or updated

- `RecipeDetailActivity.java`
- `activity_recipe_detail.xml`
- `RecipeAdapter.java`
- `SuggestedRecipesActivity.java`
- `AndroidManifest.xml`

### Completed the following functionality

- Made suggested recipe rows clickable.
- Passed the selected recipe ID through an Intent extra.
- Loaded the selected recipe from SQLite.
- Displayed the recipe name.
- Displayed the full recipe ingredient list.
- Displayed the preparation steps.
- Added back navigation to return to Suggested Recipes.
- Verified that different recipes opened with the correct details.

---

## Commit 11 (Full Recipe Dataset)
Expanded the recipe collection to meet 
the assignment requirement of 15 to 20 recipes.
I added some home favorites to the list.

### Files updated

- `RecipeSeedData.java`
- `DatabaseHelper.java`

### Added and changed the following

Expanded the recipe collection to 18 recipes:

- Scrambled Eggs, Cheese Toast, Garlic Rice
- Tomato and Cheese Toasted Sandwich, Avocado Toast
- Egg Fried Rice, 
- Beef Tacos, Chicken Tacos, Pork Tacos
- Beef Nachos, Chicken Nachos, Pork Nachos 
- Beef Enchiladas, Chicken Enchiladas, Pork Enchiladas 
- Beef Quesadilla, Chicken Quesadilla, Pork Quesadilla

Some changes i made to get matching easier:

- Simplified ingredient names for more reliable pantry matching.
- Used consistent quantities and units.
- Simplified preparation steps for the student application.
- Increased the database version so the expanded seed data was loaded.
- Verified that the application contained the complete recipe collection.

---

## Commit 12 (Expiry Tracking and Alerts)
Added expiry-date tracking and connected 
the Settings toggle to a working expiry-warning feature
saved in shared preferences.

### Files added or updated

- `SettingsActivity.java`
- `AddEditIngredientActivity.java`
- `activity_add_edit_ingredient.xml`
- `PantryAdapter.java`
- `item_pantry.xml`
- `ExpiryChecker.java`
- `MainActivity.java`

### Part A: SharedPreferences Toggle state saving

- Connected the expiry-alert toggle to SharedPreferences.
- Saved the toggle as a Boolean value.
- Restored the saved value when the Settings screen reopened.
- Verified that the toggle remained enabled or disabled after closing and reopening the app.

### Part B: Expiry Date Tracking and checking

- Added an expiry-date field to the Add/Edit Ingredient screen.
- Added a DatePickerDialog to prevent invalid manual date entry.
- Stored expiry dates in `yyyy-MM-dd` format.
- Saved expiry dates to SQLite.
- Loaded existing expiry dates when editing pantry items.
- Displayed expiry dates in pantry RecyclerView rows.

### Part C: Three-Day Expiry Alerts using toast not notifications

- Created `ExpiryChecker.java`.
- Used API 24-compatible date handling with `SimpleDateFormat`, `Date`, and `TimeUnit`.
- Read the expiry-alert preference before checking expiry dates.
- Checked pantry records when the main pantry screen resumed.
- Displayed a Toast warning when an item was within three days of expiry.
- Disabled expiry warnings when the Settings toggle was off.
- Verified the alert using a pantry item with a near expiry date.

---

## Commit 13 (Visual Styling and Usability)
Improve the application's visual appearance, 
readability, and usability.

### Files added or updated

- `colors.xml`
- `themes.xml`
- `activity_main.xml`
- `item_pantry.xml`
- `item_recipe.xml`
- `PantryAdapter.java`

### Completed changes added

- Added a Royal Blue application colour scheme.
- Added a Royal Blue toolbar with white text and icons.
- Styled the Floating Action Button in Royal Blue with a white plus icon.
- Added card-style backgrounds, margins, padding, and elevation to pantry rows.
- Added matching card-style presentation to recipe rows.
- Used Royal Blue for pantry and recipe titles.
- Added dynamic expiry-date colouring.
- Displayed expiry dates within three days in red.
- Kept non-urgent expiry dates black.
- Improved spacing and visual hierarchy throughout the lists.
- Verified that all existing functionality still worked after applying the styling changes.

---

# Current Application Features used in my app

## Pantry section

- Add pantry items. (C)
- View pantry items. (R)
- Edit pantry items. (U)
- Delete pantry items. (D)
- Store optional expiry dates. 
- Display near-expiry warnings in red for toggle.

## Recipe section

- 18 seeded recipes.
- Strict pantry-to-recipe matching.
- Suggested Recipes screen.
- Recipe Detail screen.
- Ingredient and preparation-step display.

## Storage and DB chosen

- SQLite database for pantry and recipe data.
- SharedPreferences for the expiry-alert setting.

## UI and colors i chose

- RecyclerView lists with custom adapters.
- Toolbar overflow navigation.
- Back navigation.
- Settings screen.
- Royal Blue theme.
- Card-style pantry and recipe rows.
- Conditional expiry highlighting.

## Commit 14 (readme for dev inserted)
added a development commit readme as well 
to explain my commits.

### Files added or updated

- `development-notes.md`