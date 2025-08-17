import { useState, useEffect } from "react";
import { useAuth } from "../context/AuthContext";

function ProfileEditor() {
  const { isLoggedIn, login, logout } = useAuth();

  console.log("DEBUG -> isLoggedIn:", isLoggedIn);

  const [profile, setProfile] = useState({
    name: "",
    email: "",
    bio: "",
  });

  // Load saved profile on mount
  useEffect(() => {
    const savedProfile = localStorage.getItem("userProfile");
    if (savedProfile) {
      setProfile(JSON.parse(savedProfile));
    }
  }, []);

  const handleChange = (e) => {
    setProfile({ ...profile, [e.target.name]: e.target.value });
  };

  const handleSave = () => {
    localStorage.setItem("userProfile", JSON.stringify(profile));
    alert("Profile saved!");
  };

  return (
    <div id="Tab2">
      <h2>Profile Editor</h2>
      {/* Login/Logout Toggle */}
      {isLoggedIn ? (
        <button onClick={logout}>Logout</button>
      ) : (
        <button onClick={login}>Login</button>
      )}

      {isLoggedIn ? (
        <div style={{ marginTop: "1rem"}}>
          <input type="text" name="name" placeholder="Name"
            value={profile.name} onChange={handleChange}
          />
          <input type="email" name="email" placeholder="Email"
            value={profile.email} onChange={handleChange}
          />
          <textarea name="bio" placeholder="Write something about yourself..."
            value={profile.bio} onChange={handleChange}
          />
          <button type="button" onClick={handleSave}>
            Save
          </button>
        </div>
      ) : (
        <p>Please log in to edit your profile.</p>
      )}
    </div>
  );
}
export default ProfileEditor;