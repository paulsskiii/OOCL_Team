import { useEffect, useState } from 'react';
import SocialTwitter from '../assets/social-twitter.png';
import SocialLinkedIn from '../assets/social-linkedin.png';
import SocialInstagram from '../assets/social-instagram.png';
import SocialFacebook from '../assets/social-facebook.png';


function Contact ({setMessage}) {
    const formSubmit = (event) => {
        event.preventDefault ();
        setMessage (`Hello to you, ${event.target[0].value}`);
        window.scrollTo ({top: 0, behavior: 'smooth'})
    }

    return (
        <section id="contact" className="content-container">
              <div id="div-content-contact">
                  <h2>Let's Talk</h2>
                  <div id="div-contact-desc" className="div-content-desc">
                      <aside id="div-contact-form">
                          <h3>Let me greet you</h3>
                          <form className="form-contact" onSubmit={formSubmit}>
                              <label>Your Name</label>
                              <input id="name" type="text"/>
                              <label>Email</label>
                              <input id="email" type="email"/>
                              <label>Message</label>
                              <textarea id="message" rows={5}></textarea>
                              <input id="btn-contact-submit" type="submit" value="Greet Me"/>
                          </form>
                      </aside>
                      <aside id="div-contact-socials">
                          <h3>Or reach me through my socials</h3>
                          <section>
                              <a href="https://twitter.com/" target="_blank">
                                  <img src={SocialTwitter}/>
                              </a>
                              <a href="https://www.linkedin.com/" target="_blank">
                                  <img src={SocialLinkedIn} alt="LinkedIn"/>
                              </a>
                              <a href="https://www.instagram.com/" target="_blank">
                                  <img src={SocialInstagram} alt="Instagram"/>
                              </a>
                              <a href="https://www.facebook.com/" target="_blank">
                                  <img src={SocialFacebook} alt="Facebook"/>
                              </a>
                          </section>
                          <div>
                              <h3>Or via the following contact details</h3>
                              <p>Contact: 09XX XXX XXXX</p>
                              <p>Email: aweouifhasl@gmail.com</p>
                          </div>
                      </aside>
                  </div>
              </div>
        </section>
    )
}

export default Contact;