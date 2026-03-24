# StoreManagementSystem

A Java-based console application for managing grocery store operations including product catalog management, sales, and supplier interactions.

## Features

### Product Management
- Add new products to catalog
- Display all products
- Update product details (name, quantity, price, quality)
- Search products by ID, name, quantity, price, or quality

### Sales Management
- Sell products to customers
- Generate detailed bills with quality-based extra charges
- Automatic stock updates after sales

### Supplier Management
- Add stock when products are out of stock
- Add quantity by product ID, name, price, or quality
- Generate supplier receipts with 20% commission

### Validation Rules
- Product ID: Must be numeric only
- Product Name: First letter capital, remaining lowercase
- Quality Rating: A, B, C, D, or E only
- Quantity and Price: Cannot be negative

## How to Run

1. **Compile the program**
```bash
javac StoreManagementSystem.java Run.java
