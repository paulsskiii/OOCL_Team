type Slide = {
  page: number;
  setName: React.Dispatch<React.SetStateAction<string>>;
  setQuote: React.Dispatch<React.SetStateAction<string>>;
};

export const Content: React.FC<Slide> = ({ page, setName, setQuote}) => {
  
  function submitForm() {}

  if (page == 1) {
    return (
      <div className="content">
        <div id="home">
          <p>Fast Learner</p>
          <p>Problem Solver</p>
          <p>Bot Lane Supporter</p>
          <p>Setter and Getter</p>
          <p>Liver Lover</p>
        </div>
      </div>
    );
  } else if (page == 2) {
    return (
      <div className="content">
        <div id="about">
          <h1>EXPERIENCE</h1>
          <p>Programmer in OOCL: 2025-Present</p>
          <p>SE in Exist: 2025-Present</p>
        </div>
      </div>
    );
  } else if (page == 3) {
    return (
      <div className="content">
        <p>Contacts: {page}</p>
      </div>
    );
  } else if (page == 4) {
    return (
      <div className="content">
        <div className="form-container">
          <form>
            <label>
              New name:
              <input type="text" 
                onChange={(event) => {
                event.preventDefault();
                setName(event.target.value);
              }}
              />
            </label>

            <label>
              New Quote:
              <textarea onChange={(event) => {
                event.preventDefault();
                setQuote(event.target.value);
              }}></textarea>
            </label>
          </form>
        </div>
      </div>
    );
  }
};
