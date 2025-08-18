function Feeter () {
    return (
        <section id="div-work-full" className="invisible">
          <button id="work-full-back">&#10006; Back</button>
          <div id="div-work-full-content">
              <figure id="div-work-full-img">
                  <img src="img/work-3.jpg" id="work-full-img" alt="Work full preview"/>
              </figure>
              <article id="div-work-full-desc">
                  <h1 id="h1-work-full-title">Faker Unkillable Demon King</h1>
                  <p id="p-work-full-desc">
                      The first magazine cover I made. I made this for a school activity
                      and I just decided hey wouldn&apos;t it be nice if I just use Faker
                      as the cover and so this came out. I think this aesthetic basically
                      defines my style when it comes to creating, minimal and simple.
                  </p>
                  <p className="div-work-full-desc-details">Date: <time id="work-full-date">Month Day, Year</time></p>
                  <p className="div-work-full-desc-details">Content Type: <span id="work-full-type">TYPE</span></p>
                  <p className="div-work-full-desc-details"><a id="work-full-url" target="_blank">URL</a></p>
              </article>
            </div>
        </section>
    )
}

export default Feeter;