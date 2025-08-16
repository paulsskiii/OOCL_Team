import React, { useContext, useEffect, useState } from "react";
import { AppContext } from "../context/AppContext";

const ProfileEditor = () => {
  const { user, dispatch } = useContext(AppContext);
  const [formUser, setFormUser] = useState(user);

  const [isLoading, setIsLoading] = useState(false);

  const handleChange = (e) => {
    setFormUser({
      ...formUser,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!formUser.name || !formUser.email || !formUser.about) {
      console.log("Complete all the fields!");
      alert("Complete all the fields");
      return;
    }
    setIsLoading(true);

    setTimeout(() => {
      dispatch({ type: "UPDATE", payload: formUser });

      alert(`Name: ${formUser.name} Email: ${formUser.email}`);

      setIsLoading(false);
    }, 1000);
    setFormUser({ email: "", name: "", about: "" });
  };

  return (
    <section className="flex justify-center mt-[10rem]">
      <div className="flex justify-center items-center w-[40%] bg-zinc-200 rounded-xl shadow-lg p-8">
        {isLoading ? (
          <p className="text-lg font-medium text-gray-600">Loading...</p>
        ) : (
          <form onSubmit={handleSubmit} className="flex flex-col gap-4 w-full">
            <h2 className="text-2xl font-bold text-center  mb-4">
              Update Profile
            </h2>

            <input
              type="text"
              name="name"
              value={formUser.name}
              onChange={handleChange}
              placeholder="Enter your name..."
              className="px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-black focus:border-black"
            />

            <input
              type="email"
              name="email"
              value={formUser.email}
              onChange={handleChange}
              placeholder="Enter your email..."
              className="px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-black focus:border-black"
            />

            <textarea
              name="about"
              onChange={handleChange}
              value={formUser.about}
              className="px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-black focus:border-black"
              placeholder="Enter about..."
            />
            {/* <input
              type="password"
              name="password"
              value={formUser.password}
              onChange={handleChange}
              placeholder="Enter your password..."
              className="px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-black focus:border-black"
            /> */}

            <button
              type="submit"
              className="bg-black cursor-pointer text-white py-2 rounded-lg hover:bg-white hover:text-black transition-colors duration-200 font-semibold"
            >
              Update Profile
            </button>
          </form>
        )}
      </div>
    </section>
  );
};

export default ProfileEditor;
