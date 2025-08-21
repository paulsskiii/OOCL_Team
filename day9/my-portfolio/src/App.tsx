import { useState } from "react";

import About from "./components/About";
import Navbar from "./components/Navbar";
import Profile from "./components/Profile";
import ProfileEditor from "./components/ProfileEditor";
import Project from "./components/Project";
import Skills from "./components/Skills";

const App = () => {
  const [data, setData] = useState({
    firstName: "Chris",
    lastName: "Victorio",
    location: "Philippines",
  });
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    location: "",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    setData(formData);
  };

  return (
    <main className="mx-150 my-10 px-6 py-4 border rounded-lg space-y-4">
      <Profile data={data} />
      <About />
      <Skills />
      <Navbar />
      <Project />
      <section className="space-y-2">
        <h2 className="text-2xl">Profile Editor</h2>
        <form onSubmit={handleSubmit} className="space-y-4">
          <div className="flex flex-col">
            <label htmlFor="">First Name:</label>
            <input
              type="text"
              placeholder="First Name"
              value={formData.firstName}
              onChange={(e) =>
                setFormData({ ...formData, firstName: e.target.value })
              }
              className="border rounded-md px-2 py-1"
            />
          </div>
          <div className="flex flex-col">
            <label htmlFor="">Last Name:</label>
            <input
              type="text"
              placeholder="Last Name"
              value={formData.lastName}
              onChange={(e) =>
                setFormData({ ...formData, lastName: e.target.value })
              }
              className="border rounded-md px-2 py-1"
            />
          </div>
          <div className="flex flex-col">
            <label htmlFor="">Location</label>
            <input
              type="text"
              placeholder="Location"
              value={formData.location}
              onChange={(e) =>
                setFormData({ ...formData, location: e.target.value })
              }
              className="border rounded-md px-2 py-1"
            />
          </div>
          <div className="flex gap-4">
            <button
              type="submit"
              className="w-full py-1 rounded-md cursor-pointer bg-black text-white"
            >
              Confirm
            </button>
            <button className="w-full py-1 rounded-md cursor-pointer border bg-gray-300">
              Delete
            </button>
          </div>
        </form>
      </section>
    </main>
  );
};

export default App;
