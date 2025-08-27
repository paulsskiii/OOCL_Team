// import Greeting from "./components/Greeting";

const user = {
  name: "Philip Uriarte",
  imageUrl:
    "https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYTEyNzI5ZGFmY2Y4NDQ2ZDNmYWM0OTg5OTJmZTgwZWVjMjUyM2MyYSZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PXM/mQVGgQvPdjYc45XAXo/giphy.gif",
  imageSize: 200,
};

function Portfolio() {
  return (
    <>
      <section className="NavBar"></section>

      <section className="Greeting">
        <p>Hello, I'm</p>
        <h1>{user.name}</h1>
        <img
          className="avatar"
          src={user.imageUrl}
          alt={"GIF of " + user.name}
          style={{
            width: user.imageSize,
            height: user.imageSize,
          }}
        />
      </section>

      <section className="About">
        <p>Get To Know More</p>
        <h1>About Me</h1>
        <p>
          I'm a Programmer in OOCL, my home team is CIP (Customer Innovation
          Platform).
        </p>
        <br />
      </section>

      <section className="Skills">
        <p>View My</p>
        <h1>Relevant Skills</h1>
        <ul>
          <li>Python</li>
          <li>Java</li>
        </ul>
        <br />
      </section>

      <section className="Experience">
        <p>Explore</p>
        <h1>My Experience</h1>
        <br />
      </section>

      <section className="Contact">
        <p>Get In Touch</p>
        <h1>Contact Me</h1>
        <p>
          philiproninu@gmail.com
          <br /> +63 123 456 6789
        </p>
        <br />
      </section>
    </>
  );
}

export default Portfolio;
