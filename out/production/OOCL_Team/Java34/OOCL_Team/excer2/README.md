# Exercise 2: Cargo Tracking System Instructions

## 1. Encapsulation

Create a class `Ship` with the following **private attributes**:

- `shipName` (String)  
- `captainName` (String)  
- `speedKnots` (double)  
- `fuelLevelPercentage` (int)  

### Requirements:

- Provide appropriate **public getter and setter** methods for each attribute.
- Ensure `fuelLevelPercentage` **cannot be set to a value less than 0 or greater than 100**.
  - If invalid, **print an error** and **do not change** the value.

---

## 2. Inheritance with Tanker

- Add a new subclass `Tanker` that extends `Ship`.
- Add one new attribute:
  - `cargoTypeCarried` (String — e.g., "Oil", "Gas", "Chemicals")

### Requirements:

- Implement a **constructor** for `Tanker` that:
  - Calls the **superclass constructor** (`Ship`)
  - Initializes its own attribute
- Override the `displayShipInfo()` method (if you create one in `Ship`) to:
  - Print the `cargoTypeCarried` in addition to the inherited attributes.

---

## 3. Polymorphism

### a. Create another subclass `ContainerShip` that extends `Ship`.
- Add an additional private attribute:
  - `numberOfTEU` (int — Twenty-foot Equivalent Units, standard container size)

### b. Implement its constructor

### c. Override the `displayShipInfo()` method
- Also print the `numberOfTEU` for `ContainerShip` objects.

### d. In a `TestVessels` class (with `main` method):
- Create an **ArrayList of Ship objects**
- Add instances of:
  - `Ship`
  - `Tanker`
  - `ContainerShip`

### e. Loop through the collection
- Call `displayShipInfo()` on each object
- Observe how **polymorphism** ensures the correct `displayShipInfo()` is called based on the actual object type.

