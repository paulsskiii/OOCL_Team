import profileImg from '../assets/me.jpg';


function Home() {
  return (
    <section className="flex flex-col md:flex-row justify-center items-center gap-16 min-h-screen bg-[#697565] px-9">
      {/* Left side (Image placeholder) */}
      {/* <div className="home-img hidden md:block"> */}
        <img
          src={profileImg}
          alt="Profile"
          className="w-64 h-64 shadow-lg cursor-pointer transition hover:scale-105"
        />
      {/* </div> */}

      {/* Right side (Text) */}
      <div className="home-content text-white">
        <h1 className="text-6xl font-bold leading-snug">
          Hi, It's <span className="text-[#ECDFCC]">Rhandel</span>
        </h1>
        <h3 className="typing-text text-4xl font-bold mb-4">
          I'm a <span></span>
        </h3>
        <p className="text-lg max-w-xl">
          I'm Rhandel Calingasan, a Programmer from OOCL. I belong to the EDI
          Support Team. An Information Technology graduate from the Batangas
          State University.
        </p>
        {/* Social Links */}
        <div className="flex mt-6 space-x-4">
          <a
            href="#"
            className="flex items-center justify-center w-12 h-12 border-2 border-[#3C3D37] rounded-full text-[#3C3D37] text-2xl hover:bg-[#3C3D37] hover:text-black transition"
          >
            <i className="fa-brands fa-linkedin"></i>
          </a>
          <a
            href="#"
            className="flex items-center justify-center w-12 h-12 border-2 border-[#3C3D37] rounded-full text-[#3C3D37] text-2xl hover:bg-[#3C3D37] hover:text-black transition"
          >
            <i className="fa-brands fa-github"></i>
          </a>
        </div>
      </div>
    </section>
  );
}

export default Home;
