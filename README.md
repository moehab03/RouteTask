
# Project Overview: Product List Display App

## Architecture
- **Clean Code Architecture**
- **MVVM (Model-View-ViewModel) Design Pattern**

## Dependencies
- **Hilt** for Dependency Injection
- **Retrofit** for API calls
- **RecyclerView** for displaying the product list
- **XML** for UI design

## Project Structure

### Data Layer
- **Repository**: Handles data operations and provides a clean API for data access to the rest of the application.
- **Retrofit Service**: Defines API endpoints and methods for network operations.
- **Data Source**: Manages data from different sources (e.g., network, database).

### Domain Layer
- **Use Cases**: Encapsulate a single action or functionality of the application.
- **Models**: Define the structure of the data used in the application.

### Presentation Layer
- **ViewModel**: Exposes data to the UI and handles the logic for displaying data.
- **UI (Activity/Fragment)**: Displays data and interacts with the user.
- **RecyclerView Adapter**: Binds the product list data to the RecyclerView.

## Implementation Details

### Dependency Injection with Hilt
- **Hilt Modules**: Provide dependencies like Retrofit service, repositories, etc.
- **@Inject Annotation**: Used to request dependencies.

### Network Calls with Retrofit
- **Retrofit Interface**: Define API endpoints.
- **Repository**: Make network calls through Retrofit and manage data.

### Displaying Data with RecyclerView
- **RecyclerView Adapter**: Manages and binds the data to the RecyclerView.
- **ViewHolder**: Holds the view for each list item.

## UI Design
- **XML Layouts**: Define the user interface.
  - **Activity Layout**: Contains the RecyclerView.
  - **Item Layout**: Defines the layout for each item in the RecyclerView.
