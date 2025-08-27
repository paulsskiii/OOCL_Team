package com.example.day12miniproject;

import org.junit.jupiter.api.Test;

public class ContainerServiceTest {
    
    // Test to add container with complete and valid fields
    // expected: success, created
    @Test
    void testAddValidContainer () {}

    // Test to add container with incomplete fields
    // expected: error, no creation
    @Test
    void testAddIncompleteContainer () {}

    // Test to add container with invalid fields (e.g., string in weight)
    // expected: error, no creation
    @Test
    void testAddInvalidContainer () {}

    // Test to delete existing container
    // expected: success, 1 container with matching id deleted
    @Test
    void testDeleteExistingContainer () {}

    // Test to delete non existing container (e.g., ID not in system)
    // expected: error, no containers deleted
    @Test
    void testDeleteNonExistingContainer () {}

    // Test to delete container with invalid identifier (e.g., passed non-id as param)
    // expected: error, no containers deleted
    @Test
    void testDeleteInvalidContainer () {}

    // Test to get all containers
    // expected: success, return populated list
    @Test
    void testGetAllContainersPopulated () {}

    // Test to get all containers
    // expected: success, return empty list
    @Test
    void testGetAllContainersEmpty () {}

    // Test to get single container based on id (container exists)
    // expected: success, return 1 container with matching id
    @Test
    void testGetExistingContainer () {}

    // Test to get single container based on id (container does not exist)
    // expected: success, return 0 containers
    @Test
    void testGetNonExistingContainer () {}
}
