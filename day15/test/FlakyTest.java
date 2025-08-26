package test;

import org.mockito.Mock;

import dependency.EmailService;

// This test is bad because it relies on a real, external EmailService.
// It will be slow and may fail unpredictably.
public class FlakyTest {
    // This test relies on a real instance of EmailService which is a dependency
    // that depends on the network and other infrastructure
    // which makes it slow and unpredictable.
    @Mock
    private EmailService emailService;
}
