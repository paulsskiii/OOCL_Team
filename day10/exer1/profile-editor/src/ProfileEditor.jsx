import React, { useState, useEffect } from 'react';
import { useLogin } from './LogInContext';

const ProfileEditor = () => {
  const { isLoggedIn, logout } = useLogin();
  const [userData, setUserData] = useState({ name: '', email: '', bio: '' });

  useEffect(() => {
    const savedData = JSON.parse(localStorage.getItem('userData')) || { name: '', email: '', bio: '' };
    setUserData(savedData);
  }, []);

  if (!isLoggedIn) {
    return (
      <div>
        <h2>You need to be logged in to edit your profile</h2>
        <button onClick={logout}>Logout</button>
      </div>
    );
  }

  const handleSave = () => {
    localStorage.setItem('userData', JSON.stringify(userData));
  };

  return (
    <div>
      <h2>Edit Profile</h2>
      <img src="https://tse3.mm.bing.net/th/id/OIP.YN7qi8WM391xccpWWUp7jAHaI4?r=0&rs=1&pid=ImgDetMain&o=7&rm=3" alt="Profile" className="avatar" /><br></br>
      <input
        type="text"
        value={userData.name}
        onChange={(e) => setUserData({ ...userData, name: e.target.value })}
        placeholder="Name"
      /><br></br>
      <input
        type="email"
        value={userData.email}
        onChange={(e) => setUserData({ ...userData, email: e.target.value })}
        placeholder="Email"
      /><br></br>
      <textarea
        value={userData.bio}
        onChange={(e) => setUserData({ ...userData, bio: e.target.value })}
        placeholder="Bio"
      /><br></br>
      <button onClick={handleSave}>Save</button>
      <button onClick={logout}>Logout</button>
    </div>
  );
};

export default ProfileEditor;
