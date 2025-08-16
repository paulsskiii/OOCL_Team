import { useContext } from "react";
import { AppContext } from "../context/AppContext";

const About = () => {
  const { user } = useContext(AppContext);

  return (
    <section className=" py-[2rem] shadow-md px-[10rem] mt-[10rem]" id="about">
      <h3 className=" text-2xl pb-[.7rem]">All about me :)'</h3>
      <p>{user?.about || 'Edit about...'}</p>
    </section>
  );
};

export default About;
