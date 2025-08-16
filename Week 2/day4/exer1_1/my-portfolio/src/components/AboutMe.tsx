import React from 'react';

export const AboutMe: React.FC<{}> = ({}) => {
    return(
        <article className="body1 d-flex-block flex-column align-items-center justify-content-center mx-auto">
            <section className="d-flex flex-column align-items-center justify-content-center">
                <h2 className="about">ABOUT ME</h2>
            </section>
            <section className="d-flex flex-column align-items-center justify-content-center">
                <h2 className="me">I am Monique, I live at Tanauan City, Batangas.
                    My favorite color is yellow and I like dogs. I work at OOCL (Philippines) Inc
                    with a role of Programmer. I am almost 1 year working. I am also a Tiktok Affiliate 
                    wherein I am creating video content and gain commission from sales. I am also a 
                    co-manager of Dragon Of Time where we sell Seiko watches.
                </h2>
            </section>
        </article>
    )
}