import { useState } from "react";
import "./App.css";
import ProfileTab from "./components/ProfileTab";
import ProfileEditor from "./components/ProfileEditor";

function App() {
  const [activeTab, setActiveTab] = useState("profile");

  console.log("Active Tab:", activeTab); //debugger

  return (
    <div id="container" align="center">
      <header className="tabs-nav">
        <ul>
          <li
            className={activeTab === "profile" ? "active" : ""}
            onClick={() => setActiveTab("profile")}
          >
            <a href="#" onClick={(e) => { e.preventDefault(); setActiveTab("profile"); }}>Profile</a>
          </li>
          <li
            className={activeTab === "profileeditor" ? "active" : ""}
            onClick={() => setActiveTab("profileeditor")}
          >
            <a href="#" onClick={(e) => { e.preventDefault(); setActiveTab("profileeditor"); }}>Profile Editor</a>
          </li>
        </ul>
      </header>

      <section className="tabs-content">
        {activeTab === "profile" && <ProfileTab />}
        {activeTab === "profileeditor" && <ProfileEditor />}
      </section>
    </div>
  );
}

export default App;
