import skills from "../assets/local-storage/skills.json";
import experiences from "../assets/local-storage/experience.json";
import contacts from "../assets/local-storage/contacts.json";

type Slide = {
  page: number;
  setPageName: React.Dispatch<React.SetStateAction<string>>;
  setName: React.Dispatch<React.SetStateAction<string>>;
  setQuote: React.Dispatch<React.SetStateAction<string>>;
};

export const Content: React.FC<Slide> = ({
  page,
  setPageName,
  setName,
  setQuote,
}) => {
  function submitForm() {}

  if (page == 1) {
    setPageName("SKILLS");
    return (
      <div className="content">
        <div id="skills">
          {skills.map((skill) => (
            <div className="skills-cont">
              <h2>{skill.name}</h2>
              <img src={skill.picsrc} alt="" />
            </div>
          ))}
        </div>
      </div>
    );
  } else if (page == 2) {
    setPageName("EXPERIENCE");
    return (
      <div className="content">
        <div id="experience">
          <ul>
            {experiences.map((experience) => (
              <li>
                <h4>{experience.position}</h4>
                <p>
                  At &nbsp;<strong>{experience.company}</strong>&nbsp;{" "}
                  {experience.yearStart}-{experience.yearEnd}
                </p>
              </li>
            ))}
          </ul>
        </div>
      </div>
    );
  } else if (page == 3) {
    setPageName("CONTACTS");
    return (
      <div className="content">
        <div className="contacts">
          <p>Let's get connected</p>
          <h2>{contacts.email}</h2>
          <h2>{contacts.viber}</h2>
          <h2>{contacts.linkedin}</h2>
          <form>
            <label>Send me a message::</label>
            <textarea
              onChange={(event) => {
                event.preventDefault();
                setQuote(event.target.value);
              }}
            ></textarea>
          </form>
        </div>
      </div>
    );
  } else if (page == 4) {
    setPageName("EDIT PAGE");
    return (
      <div className="content">
        <div className="form-container">
          <form>
            <label>
              New name:
              <input
                type="text"
                onChange={(event) => {
                  event.preventDefault();
                  setName(event.target.value);
                }}
              />
            </label>

            <label>
              New Quote:
              <textarea
                onChange={(event) => {
                  event.preventDefault();
                  setQuote(event.target.value);
                }}
              ></textarea>
            </label>
          </form>
        </div>
      </div>
    );
  }
};
