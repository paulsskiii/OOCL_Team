import { useEffect, useState } from "react";
import BioSection from "./BioSection";
import ProfilePicture from "./ProfilePicture";
import EditBioInformation from "./EditBioInformation";
import Spinner from "./Spinner";

function AboutMePage() {
  // to simulate waiting for form to appear
  const [isButtonClicked, setIsButtonClicked] = useState(false);

  // form appears
  const [showEditForm, setShowEditForm] = useState(false);

  const [name, setName] = useState("Abi");
  const [birthday, setBirthday] = useState(new Date(2002, 7, 7));
  const [personType, setPersonType] = useState("Inverter");

  // condition for spinner
  const [loading, setLoading] = useState(false);

  // this triggers the useEffect
  const editForm = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
    setIsButtonClicked(true);
    setLoading(true);
    setShowEditForm(false);
  };

  // show spinner for 3 seconds
  useEffect(() => {
    if (!isButtonClicked) {
      return;
    }
    const timer = setTimeout(() => {
      setLoading(false); // turn off spinner after 3 seconds
      setShowEditForm(true); // Show form after 3 seconds
    }, 2000);
    return () => clearTimeout(timer);
  }, [isButtonClicked]);

  // display spinner

  return (
    <div>
      <div className="grid gap">
        <div className="card mb-3">
          <div className="row g-0">
            <div className="col-md-4">
              <ProfilePicture />
            </div>
            <div className="col-md-8">
              <div className="d-grid gap-2 d-md-flex justify-content-md-end">
                <button
                  className="btn btn-primary"
                  style={{ backgroundColor: "#FF00C8", color: "#00FF37" }}
                  type="button"
                  onClick={editForm}
                >
                  Edit Information
                </button>
              </div>

              {/* NESTED TERNARY OPEWRTATOR */}
              {loading ? (
                <Spinner />
              ) : showEditForm ? (
                <EditBioInformation
                  setName={setName}
                  setBirthday={setBirthday}
                  setPersonType={setPersonType}
                  setShowEditForm={setShowEditForm}
                />
              ) : (
                <BioSection
                  name={name}
                  birthday={birthday}
                  personType={personType}
                />
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AboutMePage;
