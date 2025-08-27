import { useContext } from "react";
import Logout from "./Logout";
import { AppContext } from "../context/AppContext";
import { Link } from "react-router";
import Login from "./Login";
import ProfileEditor from "./ProfileEditor";

const Navbar = () => {
  const { user } = useContext(AppContext);

  const style = "text-lg font-bold hover:dark:text-white";

  return (
    <>
      <nav className="fixed flex justify-between backdrop-blur-lg bg-black/10 w-auto top-[1%] left-[50%] -translate-x-[50%] z-10 text-primary px-[5%] py-[1rem] min-h-0 rounded-[100px]">
        <ul className="flex items-center justify-between gap-[2rem] ">
          <li className={style}>
            <Link to={"/home"}>Home</Link>
          </li>
          <li className={style}>
            <Link to={"/about"}>About</Link>
          </li>
          <li className={style}>
            <Link to={"/skill"}>Skills</Link>
          </li>
        </ul>
      </nav>
      <div className="flex justify-end items-center w-full pr-6">
        <ul className="flex items-center top-[1%] mt-[.5rem] py-[1rem] gap-6 backdrop-blur-lg bg-black/10 w-auto z-10 text-primary px-6 rounded-[100px]">
          <li className={style}>
            {user ? (
              <Link to={"/editor"}>{user?.name || "Login"}</Link>
            ) : (
              <Link to={"/editor"}>Login</Link>
            )}
          </li>
          <li className={style}>
            <Logout />
          </li>
        </ul>
      </div>
    </>
  );
};

export default Navbar;
