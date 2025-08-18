import card1 from '../assets/card1.webp';
import card2 from '../assets/card2.webp';
import card3 from '../assets/card3.png';
import card4 from '../assets/card4.jfif';

import data from '../assets/json-dummy/projects.json';

function Projects() {
    const dummydata = data;

    return (
        <div className="d-flex justify-content-center">
            <div className="project-banner p-5 text-start rounded-5 row">
                {dummydata.map((card, index) => (
                        <div className="card m-2 rounded-3" style={{width: "18rem"}} key={card.id}>
                            <img src={card.image} className="card-img-top p-3" alt="..." />
                            <div className="card-body">
                                <h5 className="card-title">{card.title}</h5>
                                <p className="card-text">{card.desc}</p>
                            </div>
                        </div>
                ))}
                {/* <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card1} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Vi Real</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card2} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Mobile App</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card3} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Data Analytics</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card4} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Analytics</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card1} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Vi Real</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card2} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Mobile App</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card3} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Data Analytics</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card4} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Analytics</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>
                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card3} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Data Analytics</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div>

                <div className="card m-2 rounded-3" style={{width: "18rem"}}>
                    <img src={card4} className="card-img-top p-3" alt="..." />
                    <div className="card-body">
                        <h5 className="card-title">Analytics</h5>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                    </div>
                </div> */}

            </div>
        </div>  
   );
}

export default Projects;