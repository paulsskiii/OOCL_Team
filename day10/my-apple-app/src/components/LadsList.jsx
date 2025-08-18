function LadsList(){
    const lads1 = ['Caleb', 'Zayne', 'Rafayel', 'Sylus', 'Xavier'];

    const [c1,c2,c3,c4,c5] = ['Caleb', 'Zayne', 'Rafayel', 'Sylus', 'Xavier'];

    const lads = [
                {
                    id: 1,
                    first_name : "Caleb",
                    last_name : "Xia"
                },
                {
                    id: 2,
                    first_name : "Zayne",
                    last_name : "Li"
                },
                {
                    id: 3,
                    first_name : "Sylus",
                    last_name : "Qin"
                }
            ]

    return(
        <div>
            <h1>Love and Deepspacee</h1>
            <ol>
                
                   {/* <li>
                        {c1}
                   </li> */}

                   {lads.map((lad, index) => (
                        <li key={lad.id + index} style={{color:"#e78787ff"}}>
                            {lad.first_name} {lad.last_name}
                        </li>
                   ))}
                
            </ol>
        </div>
    )
}

export default LadsList;