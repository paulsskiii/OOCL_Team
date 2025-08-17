import BioSection from "./BioSection";
import ProfilePicture from "./ProfilePicture";

function AboutMePage() {
  return (
    <div>
      <div className="card mb-3">
        <div className="row g-0">
          <div className="col-md-4">
            <ProfilePicture />
          </div>
          <div className="col-md-8">
            <BioSection />
          </div>
        </div>
      </div>
    </div>
  );
}

export default AboutMePage;
