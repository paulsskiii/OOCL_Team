type NavigationProps = {
    name: string;
}


export const Navigation: React.FC<NavigationProps> = ({ name }) => {
    return(
        <div className="text-center mt-[50px]">
            <button onClick={() => alert(`Hi ${name}, you clicked the button!`)}>Press</button>
        </div>
    )
}