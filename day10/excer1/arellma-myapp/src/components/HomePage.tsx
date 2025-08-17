import { useState, useContext, createContext } from "react";
import image from "../assets/image 3.png";
import { UserProfile } from "./UserProfile";
import { About } from "./About";
import { Header } from "./Header";
import { Context } from "../App";
import Tilt from "react-parallax-tilt";
import { Login } from "./Login";
type HomePageProps = {};
export const HomePage: React.FC<HomePageProps> = ({}) => {
	debugger;

	const context = useContext(Context);

	if (!context) return null;
	const { profileModalOpen } = context;

	return (
		<div className="bg-cover bg-[url(assets/background.png)] text-white mx-auto h-screen w-screen flex flex-col items-center ">
			<section className="relative z-10">
				<Header />
			</section>
			<section>
				<UserProfile />
				<Login />
			</section>
			<section className="h-3/4 w-3/4 flex items-center justify-center">
				<Tilt tiltMaxAngleX="3" tiltMaxAngleY="3" transitionSpeed="500">
					<section className=" flex flex-row gap-10 rounded-xl border border-white items-center justify-center backdrop-blur-lg drop-shadow p-8">
						<div className="flex items-center justify-center h-120 w-120 w-1/2">
							<img src={image} className="rounded-lg" />
						</div>
						<About />
					</section>
				</Tilt>
			</section>
		</div>
	);
};
