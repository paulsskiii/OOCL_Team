import test from '../assets/test.png';
import { useState } from 'react';

function Home({ profile }) {

    return (
        <div className="d-flex justify-content-center">
            <div className="banner p-5 text-start rounded-5">
                <p className="display-2 fw-bold p-5 text-uppercase">{profile.name}</p>
            
                <div className="fw-normal pl-5 p-5">
                    <p className="lead">
                        {profile.description}
                    </p>
                    <p>
                        {profile.email}
                    </p>
                </div>
            </div>
            
                <div className="text-end" style={{zIndex:"200", position:"absolute", right: "0"}}>
                    <img src={test} alt="..." style={{width:"700px", height:"1000px"}}/>
                </div>
        </div>  
    );
}

export default Home;