import Profile from "./Profile";

const Navbar = () => {

  const style = "text-lg font-bold hover:dark:text-white";

  return (
    <nav className="fixed backdrop-blur-lg bg-black/10 w-auto top-[1%] left-[50%] -translate-x-[50%] z-10 justify-center text-primary px-[5%] py-[1rem] min-h-0 rounded-[100px]">
      {/* <div className="flex justify-center items-center cursor-crosshair">
        <span className={`${style}`}>RUSSEL</span>
      </div> */}
      <ul className="flex items-center justify-between gap-[2rem] ">
        <li>
          <a href="#home" className={style}>Home</a>
        </li>
        <li>
          <a href="#about" className={style}>About</a>
        </li>
        <li>
          <a href="#skill" className={style}>Skills</a>
        </li>
        <li>
          <a href="#" className={style}><Profile /></a>
        </li>
      </ul>
    </nav>
  )
}

export default Navbar