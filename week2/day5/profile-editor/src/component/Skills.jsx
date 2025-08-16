const Skills = () => {
  const head = "text-xl font-bold";
  const style =
    "bg-zinc-100 w-[12rem] rounded-lg px-[3rem] py-[2rem] shadow-lg hover:bg-white";

  const skills = [
    { skill: "HTML", description: "Structure of web pages" },
    { skill: "CSS", description: "Styling and layouts" },
    { skill: "JavaScript", description: "Dynamic interactions" },
    { skill: "React", description: "Frontend library" },
    { skill: "Node.js", description: "Backend runtime" },
    { skill: "Express", description: "Server framework" },
    { skill: "MongoDB", description: "NoSQL database" },
    { skill: "SQL", description: "Relational databases" },
    { skill: "Git", description: "Version control" },
    { skill: "Tailwind", description: "Utility-first CSS" },
  ];

  return (
    <section
      className="grid grid-cols-5 gap-[5rem] my-[5rem] px-[20%] mt-[10rem]"
      id="skill"
    >
        {skills.map(skill => (
            <div className={style}>
                <h3 className={head}>{skill.skill}</h3>
                <p>{skill.description}</p>
            </div>
        ))}
    </section>
  );
};

export default Skills;
