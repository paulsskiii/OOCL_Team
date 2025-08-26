package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.demo.service.EmailService;

// This test is bad because it relies on a real, external EmailService.
// It will be slow and may fail unpredictably.
public class FlakyEmailTest {
    // This test relies on a real instance of EmailService which is a dependency
    // that depends on the network and other infrastructure
    // which makes it slow and unpredictable.

    @Mock
    private EmailService emailService;

    @Test
    void testSendRegistrationEmail ()
}

