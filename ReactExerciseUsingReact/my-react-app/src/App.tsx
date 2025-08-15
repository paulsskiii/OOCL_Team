//import{Greeting} from "./components/Greeting";
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import ProfileEditPage from "./components/ProfileEditPage";
import HomePage from "./components/HomePage";


function App(){
  return(
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/homePage">Home</Link>
            </li>
            <li>
              <Link to="/profileEdit">Edit Profile</Link>
            </li>
          </ul>
        </nav>
      </div>
      <Routes>
        <Route path = "/homePage" element={<HomePage />} />
        <Route path = "/profileEdit" element={<ProfileEditPage />} />
        {/* <Route path = "/" element={<HomePage />} /> */}
        {/* <Route path = "/about" element={<AboutPage />} /> */}
    </Routes>
    </Router>
    // <>
    //   <HeaderProps name = "Cyrus Katigbac" position = "Programmer" />
    //   <BioSection />
    //   <SkillsList />
    // </>
  )
};

export default App;