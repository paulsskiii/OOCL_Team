import React, { useState } from "react";

const Skills = () => {
  const [skills, setSkills] = useState([]);

  return (
    <section className="space-y-2">
      <div className="flex justify-between items-center">
        <h2 className="text-2xl">Skills</h2>
        <form className="flex items-center justify-between gap-2">
          <label>Add skill:</label>
          <input type="text" className="border rounded-lg px-2" />
          <button className="bg-green-200 border px-4 rounded-lg cursor-pointer hover:bg-green-300">
            ✓
          </button>
        </form>
      </div>
      <div className="flex flex-wrap gap-4">
        <div className="rounded-lg px-6 py-1 bg-black">
          <p className="text-white">HTML</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">CSS</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">JavaScript</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">Java</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">Test</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">Test</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">Test</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">Test</p>
        </div>
        <div className="rounded-lg px-4 py-1 bg-black">
          <p className="text-white">Test</p>
        </div>
      </div>
    </section>
  );
};

export default Skills;
