import profilePic from "../assets/CAOAL-PIC.jpg";
import ProfileEditor from "./ProfileEditor";

function ProfileTab() {
  return (
    <div id="tab1">
      {/* Overview Section */}
      <img src={profilePic} alt="Alexis-Cao" className="profile-pic" />
      
      <h1>Alexis D. Cao</h1>
      <p style={{textAlign: "center", fontWeight: "bold"}}>Dasmarinas City, Cavite, Philippines<br/>
      <i className="fa fa-phone"/>&nbsp;Contact no.: +63977-xxxx-xxx<br/>
      <i className="fa fa-envelope"/>&nbsp;Email: {" "}
      <a href="mailto:alexis.cao@oocl.com">alexis.cao@oocl.com</a>
      <br/>
      </p>

      <hr />
      <h2>ABOUT ME</h2>
      <p align="justify">
          Hello everyone! My name is Alexis Cao, currently working as programmer
          in OOCL Philippines Inc. Aside from programming, I also have a little
          background in basic drafting and designing. I also do graphic designing
          and digital artwork as a hobby.
      </p>

      {/* Profile Section */}
      <hr />
      <h3>Experience</h3>
      <p>
        Job Position: PROGRAMMER <br />
        Team: DOCU-DPMCP <br />
        Date Hired: OCT 2024 - PRESENT
      </p>
      <p>
        Job Position: PROGRAMMER INTERN <br />
        Team: DOCU-DPMCP <br />
        Date Hired: FEB 2024 - SEPT 2024
      </p>

      <h3>Personal Background</h3>
      <p>
        Date of Birth: January 8 <br />
        Birthplace: Baliuag, Bulacan <br />
        Sex: Female <br />
        Nationality: Filipino
      </p>

      <h3>Educational Attainment</h3>
      <p>
        College: FEU - ALABANG <br />
        BS Information Technology <br />
        with specialization in Service Management and Business Analytics
        <br />
        2019 – 2024
      </p>

      <h3>Skills</h3>
      <p>
        Computer Skills: Microsoft Office <br />
        Programming Language/s: Java.....
      </p>

      <hr />
      <h3>Checkout My Links!</h3>

      <button type="text" onClick={() => handleButtonClick('https://www.facebook.com')}>
          <p>
          <i className="fa fa-facebook" /> &nbsp;&nbsp;Add me on Facebook
          </p>
      </button>
      <br />

      <button type="text" onClick={() => handleButtonClick('https://www.linkedin.com')}>
          <p>
          <i className="fa fa-linkedin" /> &nbsp;&nbsp;Connect with me on LinkedIn
          </p>
      </button>
      <br />

      <button type="text" onClick={() => handleButtonClick('https://www.instagram.com')}>
          <p>
          <i className="fa fa-instagram" /> &nbsp;&nbsp;Follow me on Instagram
          </p>
      </button>

    </div>
  );
}

export default ProfileTab;
