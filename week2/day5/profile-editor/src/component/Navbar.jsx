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
    <nav className="fixed backdrop-blur-lg bg-black/10 w-auto top-[1%] left-[50%] -translate-x-[50%] z-10 justify-center text-primary px-[5%] py-[1rem] min-h-0 rounded-[100px]">
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
        <li className={style}>
          {user ? (
            <Link to={"/editor"}>{user?.name|| 'Profile Editor'} </Link>
          ) : (
            <Link to={"/editor"}>Profile Editor</Link>
          )}
        </li>
        <li className={style}>
          <Logout />
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
