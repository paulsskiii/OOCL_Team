import Interest1 from '../assets/interest-1.jpg';
import Interest2 from '../assets/interest-2.png';
import Interest3 from '../assets/interest-3.png';
import Interest4 from '../assets/interest-4.jpg';

function Interests () {
    return (
        <section id="interests" className="content-container">
              <div id="div-content-interests">
                  <h2>My Interests</h2>
                  <div id="div-interests-desc" className="div-content-desc">
                      <article className="div-container-skill">
                          <img src={Interest1} alt="Skill image"/>
                          <h3>Interest 1</h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                              Nulla lacinia cursus consectetur...</p>
                      </article>
                      <article className="div-container-skill">
                          <img src={Interest2} alt="Skill image"/>
                          <h3>Interest 2</h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                              Nulla lacinia cursus consectetur...</p>
                      </article>
                      <article className="div-container-skill">
                          <img src={Interest3} alt="Skill image"/>
                          <h3>Interest 3</h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                              Nulla lacinia cursus consectetur...</p>
                      </article>
                      <article className="div-container-skill">
                          <img src={Interest4} alt="Skill image"/>
                          <h3>Interest 4</h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                              Nulla lacinia cursus consectetur...</p>
                      </article>
                  </div>
              </div>
        </section>
    )
}

export default Interests