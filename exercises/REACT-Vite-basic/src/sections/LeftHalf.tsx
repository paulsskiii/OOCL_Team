import React from "react";

type ImageProps = {
    imgSrc: string;
}

export const LeftHalf: React.FC<ImageProps> = ({imgSrc}) => {
    return ( <>
        <section style={{maxWidth: "100%", height: "100vh"}}>
        <img src={imgSrc} style={{height: "50vh"}}/>
        </section>
    </>)
}