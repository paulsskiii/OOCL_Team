import React, { useState } from "react";
import myImage from "../assets/shared image.jpg";
import mySecondForm from "../assets/cat.jpg";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function ProfilePicture() {
  const images = { myImage, mySecondForm };
  const [displayedImage, setDisplayedImage] = useState(images.myImage);
  return (
    <div className="card float" style={{ float: "right", width: "18rem" }}>
      <img
        id="card1Img"
        src={displayedImage}
        className="card-img-top object-fit border rounded"
        alt="iz me"
      />
      <div className="card-body">
        <p className="card-text">
          <button
            type="button"
            className="btn btn-outline-secondary float-start"
            onClick={() => setDisplayedImage(images.myImage)}
          >
            First Form
          </button>
          <button
            type="button"
            className="btn btn-outline-secondary float-end"
            onClick={() => setDisplayedImage(images.mySecondForm)}
          >
            Final Form
          </button>
        </p>
      </div>
    </div>
  );
}

function handleClick() {}

export default ProfilePicture;
