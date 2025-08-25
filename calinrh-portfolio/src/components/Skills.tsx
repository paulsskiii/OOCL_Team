import { useState, useEffect, FormEvent } from "react";

function Skills() {
  const [skills, setSkills] = useState<string[]>([
    "C#",
    "Java",
    "SQL",
    "React",
    "Tailwind CSS"
  ]);

  const [newSkill, setNewSkill] = useState("");
  const [loading, setLoading] = useState(false);

  const handleAddSkill = (e: FormEvent) => {
    e.preventDefault();
    if (newSkill.trim() === "") return;

    setLoading(true); // trigger loading
  };

  // Effect to handle "fake loading" for 3 seconds
  useEffect(() => {
    if (loading) {
      const timer = setTimeout(() => {
        setSkills((prev) => [...prev, newSkill.trim()]);
        setNewSkill("");
        setLoading(false);
      }, 1000);

      return () => clearTimeout(timer); // cleanup
    }
  }, [loading, newSkill]);

  return (
    <>
      <div className="flex flex-col md:flex-row justify-center items-center gap-16 min-h-screen bg-[#697565] px-9">
        <section
          id="skills"
          className="bg-[#697565] min-h-screen px-9 py-20 text-white flex flex-col items-center"
        >
          <h2 className="text-4xl font-bold mb-6 text-[#ECDFCC]">My Skills</h2>

          {/* Skills List */}
          <ul className="grid grid-cols-2 md:grid-cols-3 gap-4 w-full max-w-2xl">
            {skills.map((skill, index) => (
              <li
                key={index}
                className="bg-[#3C3D37] text-white py-2 px-4 rounded-lg shadow-md hover:scale-105 transition"
              >
                {skill}
              </li>
            ))}
          </ul>

          {/* Add Skill Form */}
          <form
            onSubmit={handleAddSkill}
            className="mt-10 flex flex-col sm:flex-row gap-4 w-full max-w-md"
          >
            <input
              type="text"
              placeholder="Add a new skill"
              value={newSkill}
              onChange={(e) => setNewSkill(e.target.value)}
              className="flex-1 px-4 py-2 rounded-lg text-black outline-none border border-gray-300 focus:border-[#ECDFCC]"
              disabled={loading}
            />
            <button
              type="submit"
              disabled={loading}
              className={`${
                loading ? "bg-gray-400 cursor-not-allowed" : "bg-[#ECDFCC] hover:bg-[#d8cbb4]"
              } text-[#3C3D37] font-semibold px-6 py-2 rounded-lg shadow transition`}
            >
              {loading ? "Loading..." : "Add"}
            </button>
          </form>
        </section>
      </div>
    </>
  );
}

export default Skills;
