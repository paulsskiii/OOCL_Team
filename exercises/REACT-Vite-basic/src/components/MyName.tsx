import React from "react";

type MyNameProps = {
    name: string;
}

export const MyName: React.FC<MyNameProps> = ({name}) => {
    return (
        <div style={{ textAlign: "center" }}>
            <h1>Hi, I'm {name}</h1>
        </div>
    )
}