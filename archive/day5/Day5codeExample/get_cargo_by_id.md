# GET a Single Cargo Item by ID

**Objective:** Retrieve details for a specific cargo item using its unique ID.

**Method:** `GET`

**URL:** `http://localhost:8081/cargo/{id}` (e.g., `http://localhost:8081/cargo/1`)

**Expected Response (Status: 200 OK):** A JSON object representing the cargo item with the specified ID.

```json
{
    "id": 1,
    "name": "Electronics",
    "weight": 150.0,
    "origin": "Manila",
    "destination": "Cebu"
}
