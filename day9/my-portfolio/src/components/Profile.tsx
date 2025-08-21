import React from "react";

const Profile = ({ data }) => {
  console.log(data);
  return (
    <section id="profile" className="flex gap-8">
      <div className="text-justify space-y-2">
        <h2 className="text-2xl">
          Hi, I'm {data.firstName + " " + data.lastName} 👋 - {data.location}
        </h2>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
          minim veniam, quis nostrud eiusmod tempor incididunt ut labore et
          dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
        </p>
      </div>
      <img
        className="w-40 h-40 rounded-2xl"
        src="https://th.bing.com/th/id/R.e9a52ddd75d9fae90f9fc209c66a699f?rik=eB9s6zrDUGddCA&riu=http%3a%2f%2fimages2.fanpop.com%2fimage%2fphotos%2f13100000%2fKoala-animals-13168798-1600-1200.jpg&ehk=NVToLP6YECL7jGv6PUbbMgUqNEduugjr1kS9xGvlEv8%3d&risl=&pid=ImgRaw&r=0"
        alt="profile"
      />
    </section>
  );
};

export default Profile;
