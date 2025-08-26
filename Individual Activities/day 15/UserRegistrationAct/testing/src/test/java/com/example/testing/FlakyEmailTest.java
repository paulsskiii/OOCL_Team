package com.example.testing;

public class FlakyEmailTest {
    // This test relies on a real instance of EmailService which is a dependency
    // that depends on the network and other infrastructure
    // which makes it slow and unpredictable.
}
