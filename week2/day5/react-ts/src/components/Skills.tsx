type SkillsProps = {
    skill: string;
    description: string;
}

const Skills: React.FC<SkillsProps> = ({ skill, description }) => {

    const head = "text-xl font-bold";
    const style = "bg-zinc-100 w-[12rem] rounded-lg px-[3rem] py-[2rem] shadow-lg hover:bg-white";

    return (
        <section className="grid grid-cols-5 gap-[5rem] my-[5rem] px-[20%]" id="skill">
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
            <div className={style}>
                <h3 className={head}>{skill}</h3>
                <p>{description}</p>
            </div>
        </section>
    )
}

export default Skills