import React from 'react';

export const PictureSection: React.FC<{}> = ({}) => {
    return(
        <div className="body2 d-flex flex-column align-items-center justify-content-center p-5">
            <section className="d-flex flex-column align-items-center justify-content-center">
                <h2 className="portfolio" id="click">MY PORTFOLIO</h2>
            </section>

            <section className="mini-picture d-flex flex-row align-items-center justify-content-center">
                <div className="first-picture">
                    <img className="picture1" src="src\assets\1.jpeg"/>
                </div>
                <div className="sec-picture">
                    <img className="picture3" src="src\assets\3.jpeg"/>
                </div>
                <div className="third-picture">
                    <img className="picture2" src="src\assets\2.jpeg"/>
                </div>
            </section>
        </div>
    )
}