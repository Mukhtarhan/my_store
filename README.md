# MyStore App

## Overview
MyStore App is a mobile application that serves as an online store where users can browse and purchase a variety of products including clothes, shoes, and furniture.

## Features
- Browse products by category: Users can view products categorized into clothes, shoes, and furniture.
- Search functionality: Users can search for specific products using keywords.
- Sort products: Users can sort products by categories.
- View product details: Users can view detailed information about each product, including images, descriptions, and prices.
- Add to cart: Users can add products to their shopping cart for later purchase.


## Dependencies
- Retrofit: Used for networking and API requests.
- RecyclerView: Used for displaying lists of products.


## API Documentation
### ProductService
- `getProductsByCategory(category: String)`: Retrieves a list of products belonging to the specified category.
- Parameters:
 - `category`: The category of products to retrieve (e.g., "clothes", "shoes", "furniture", "electronics").
- Returns:
 - `List<Product>`: A list of product objects.

- `getProducts()`: Retrieves a list of products
- Returns:
 - `List<Product>`: A list of product objects.

## Prototype

