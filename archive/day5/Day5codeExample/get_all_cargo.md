# GET All Cargo Items

**Objective:** Retrieve a list of all cargo items currently stored in the system.

**Method:** `GET`

**URL:** `http://localhost:8081/cargo`

**Expected Response (Status: 200 OK):** A JSON array containing all cargo items.

```json
[
    {
        "id": 1,
        "name": "Electronics",
        "weight": 150.0,
        "origin": "Manila",
        "destination": "Cebu"
    },
    {
        "id": 2,
        "name": "Apparel",
        "weight": 50.5,
        "origin": "Davao",
        "destination": "Manila"
    },
    {
        "id": 3,
        "name": "Perishables",
        "weight": 200.0,
        "origin": "Cebu",
        "destination": "Manila"
    }
]