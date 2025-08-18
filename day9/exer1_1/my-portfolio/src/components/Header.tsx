import React from 'react';

type PictureProps = {
    name: string;
};

export const Header: React.FC<PictureProps> = ({name}) => {
    return(
        <header className="d-flex-block align-items-center justify-content-center mx-auto">
            <section className="inside d-flex align-items-center justify-content-center">
                <h1 className="title">PORT<span className="title1">FOLIO</span>
                </h1>

                <h2 className="sub">Home</h2>
                <h2 className="sub">About</h2>
                <h2 className="sub">Portfolio</h2>
                <h2 className="sub">Contact</h2>
            </section>

            <section className="d-flex flex-column align-items-center justify-content-center">
                <h2 className="name">MONIQUE AIRA T. DESENGAÑO</h2>
            </section>

            <section className="d-flex flex-column align-items-center justify-content-center">
                <h2 className="des">OOCL (Philippines) Inc.</h2>
            </section>

            <div className="button1 d-flex flex-column align-items-center justify-content-center">
                <div style={{
                    textAlign:"center",
                    color: 'black'}}>
                <h1> Hello, {name} </h1>
                <button onClick={() => alert(`Hi ${name}, Nice Meeting you!`)}>
                    Click Me
                </button>
                </div>
            </div>
        </header>
    )
}