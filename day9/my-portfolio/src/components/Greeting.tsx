const user = {
  name: "Philip Uriarte",
  imageUrl:
    "https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYTEyNzI5ZGFmY2Y4NDQ2ZDNmYWM0OTg5OTJmZTgwZWVjMjUyM2MyYSZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PXM/mQVGgQvPdjYc45XAXo/giphy.gif",
  imageSize: 200,
};

function Greeting() {
  return (
    <div className="Greeting">
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
    </div>
  );
}
