import SocialTwitter from '../assets/social-twitter.png';

function Contact () {
    return (
<section id="contact" className="content-container">
              <div id="div-content-contact">
                  <h2>Contact Me</h2>
                  <div id="div-contact-desc" className="div-content-desc">
                      <aside id="div-contact-form">
                          <h3>Send me a message</h3>
                          <form className="form-contact">
                              <label>Name</label>
                              <input id="name" type="text"/>
                              <label>Email</label>
                              <input id="email" type="email"/>
                              <label>Message</label>
                              <textarea id="message" rows={5}></textarea>
                              <input id="btn-contact-submit" type="submit" value="Send Message"/>
                          </form>
                      </aside>
                      <aside id="div-contact-socials">
                          <h3>Or reach me through my socials</h3>
                          <section>
                              <a href="https://twitter.com/" target="_blank">
                                  <img src={SocialTwitter}/>
                              </a>
                              <a href="https://www.linkedin.com/" target="_blank">
                                  <img src="img/social-linkedin.png" alt="LinkedIn"/>
                              </a>
                              <a href="https://www.instagram.com/" target="_blank">
                                  <img src="img/social-instagram.png" alt="Instagram"/>
                              </a>
                              <a href="https://www.facebook.com/" target="_blank">
                                  <img src="img/social-facebook.png" alt="Facebook"/>
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