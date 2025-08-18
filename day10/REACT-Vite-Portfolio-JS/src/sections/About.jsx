import mainImage from '../assets/main-picture.png';

function About () {
    return (
        <section id="about" className="content-container">
              <div id="div-content-about">
                  <h2>About Me</h2>
                  <figure id="div-about-desc" className="div-content-desc">
                      <img src={mainImage} alt="Profile picture"/>
                      <figcaption>
                          Hi! I&apos;m Hello World! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eget lacus porttitor nunc bibendum viverra.
                      </figcaption>
                  </figure>
              </div>
        </section>
    )
}

export default About;