import React, { useState } from "react";
import { MyName } from "../components/MyName";
import InfoSection from "../components/InfoSection";

type RightProps = {
    text: string;
}


export const RightHalf: React.FC<RightProps> = ({text}) => {

    return (<>
        <InfoSection/>
    </>)
}