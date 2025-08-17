import React, { useState } from "react";

type EditBioInformationProps = {
  setName: (name: string) => void;
  setBirthday: (date: Date) => void;
  setPersonType: (type: string) => void;
  setShowEditForm: (showEditForm: boolean) => void;
};

function EditBioInformation({
  setName,
  setBirthday,
  setPersonType,
  setShowEditForm,
}: EditBioInformationProps) {
  // variables/placeholders for my input
  const [nameInput, setNameInput] = useState("");
  const [birthdayInput, setBirthdayInput] = useState("");
  const [personTypeInput, setPersonTypeInput] = useState("");

  // boolean: is fake submit button clicked?
  const [showSubmit, setShowSubmit] = useState(false);

  // this function shows the real submit button when the fake submit button is clicked
  const handleFirstClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
    setShowSubmit(true);
  };

  // my true submit button
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log("Form submitted!");

    // update values
    setName(nameInput);
    setBirthday(new Date(birthdayInput));
    setPersonType(personTypeInput);
    setShowEditForm(false);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-3">
        <label className="form-label">Name</label>
        <input
          type="text"
          className="form-control"
          placeholder="WHAT IS THY NAME?"
          value={nameInput}
          onChange={(event) => setNameInput(event.target.value)}
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Birthday</label>
        <input
          type="date"
          className="form-control"
          value={birthdayInput}
          onChange={(event) => setBirthdayInput(event.target.value)}
        />
      </div>
      <div className="mb-3">
        <label className="form-label">Type of Person</label>
        <input
          type="text"
          className="form-control"
          placeholder="ANONG KLASENG TAO KA?"
          value={personTypeInput}
          onChange={(event) => setPersonTypeInput(event.target.value)}
        />
      </div>

      {/* Trick users first */}
      <div className="d-grid gap-2 d-md-block">
        {!showSubmit ? (
          <button
            className="btn btn-primary"
            type="button"
            onClick={handleFirstClick}
          >
            Submit
          </button>
        ) : (
          <button className="btn btn-primary" type="submit">
            Submit na talaga
          </button>
        )}
      </div>
    </form>
  );
}

export default EditBioInformation;
