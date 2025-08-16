function Navbar () {

    
    return (<header>
          <nav id="navbar-holder">
              <ul id="div-navbar">
                  <li className="div-navbar-item">
                      <a href="#home" className="navbar-text navbar-text-invisible">Home</a>
                      <span className="navbar-dot"></span>
                  </li>
                  <li className="div-navbar-item">
                      <a href="#about" className="navbar-text navbar-text-invisible">About</a>
                      <span className="navbar-dot"></span>
                  </li>
                  <li className="div-navbar-item">
                      <a href="#interests" className="navbar-text navbar-text-invisible">Interests</a>
                      <span className="navbar-dot"></span>
                  </li>
                  <li className="div-navbar-item">
                      <a href="#works" className="navbar-text navbar-text-invisible">Works</a>
                      <span className="navbar-dot"></span>
                  </li>
                  <li className="div-navbar-item">
                      <a href="#contact" className="navbar-text navbar-text-invisible">Contact</a>
                      <span className="navbar-dot"></span>
                  </li>
              </ul>
          </nav>
      </header>)
}

export default Navbar;
 