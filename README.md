# BookFinderApp
Android application that fetches and displays books from the Google Books API. It uses a GridView to present book titles along with their cover images retrieved from the API.

## Features

### Book.java
This class defines the structure of a Book object containing a title and an image URL.

### BookAdapter.java
The BookAdapter class extends BaseAdapter to populate the GridView with Book objects. It uses Picasso for efficient image loading.

### BookFetcher.java
BookFetcher manages the asynchronous task of fetching books from the Google Books API. It handles UI updates and cancellation using coroutines.

### MainActivity.java
MainActivity sets up the GridView and ProgressBar. It initializes BookFetcher to fetch and display books on app launch.

### NetworkHelper.kt
NetworkHelper is a Kotlin object that handles network operations. It fetches book data from the Google Books API using HttpURLConnection and parses the JSON response.

### XML Layouts
- **activity_main.xml**: Contains the GridView and ProgressBar for displaying books.
- **grid_item.xml**: Defines the layout for each item in the GridView, displaying a book's cover image and title.

## Usage
1. Clone or download the project repository.
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Dependencies
- **Picasso**: For image loading and caching.
- **Apache Commons IO**: For IO operations in Kotlin.

## Notes
- Ensure an active internet connection to fetch book data from the Google Books API.
- The app handles network operations asynchronously to avoid blocking the UI thread.

## Technologies Used
- Java: Programming language used for Android development.
- Android Studio: Official IDE for Android development.
- Google Books API: Used to fetch the list of books.
- Picasso: Library for image loading and caching.
- CoroutineScope: Used for managing asynchronous operations.
- GridView: Used to display the list of books in a grid format.
- JSON: Format used to parse data fetched from the API.
- HTTPURLConnection: Used to make network requests.

## You can contribute by:
- Reporting bugs
- Suggesting new features
- Submitting pull requests to improve the codebase
