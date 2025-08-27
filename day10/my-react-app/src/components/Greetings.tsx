function Greetings({name}: {name: string}) {
    return (
        <>
            <h2>This is a greeting</h2>
            <h3>{name}</h3>
        </>
    );
}

export default Greetings;