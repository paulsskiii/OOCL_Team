import { useState } from "react";

function Home ({message}) {
    return (
        <section id="home" className="content-container">
              <div id="div-content-home">
                  <h1 id="h1-home-name">{message}</h1>
                  <p id="div-home-more">-</p>
              </div>
        </section>
    )
}

export default Home;