import React from "react";

type InfoSectionLeftProps = {
    text: string
}

export const InfoSectionText: React.FC<InfoSectionLeftProps> = ({text}) => {
    return (
        <>
            <article style={{width: "100%"}}>
                {text}
            </article>
        </>
    )
}